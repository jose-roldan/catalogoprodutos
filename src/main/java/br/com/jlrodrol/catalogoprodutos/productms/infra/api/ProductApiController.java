/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.api;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.AtualizarProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.IncluirProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ListarProductsFilterService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ListarProductsService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ObterProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.RemoverProductService;
import br.com.jlrodrol.catalogoprodutos.productms.infra.api.dto.ProductDTO;
import br.com.jlrodrol.catalogoprodutos.productms.infra.api.dto.mappers.ProductMapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lemon
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ProductApiController {

    private final ProductMapper productMapper;

    private final IncluirProductService incluirProductService;
    private final ListarProductsService listarProductsService;
    private final ListarProductsFilterService listarProductsFilterService;
    private final ObterProductService obterProductService;
    private final RemoverProductService removerProductService;
    private final AtualizarProductService atualizarProductService;

    /**
     * Criação de um produto
     *
     * @param productDTO
     * @return
     */
    @PostMapping("/products")
    public ResponseEntity<ProductDTO> incluirProduct(@RequestBody @Valid ProductDTO productDTO) {

        log.info("incluirProduct, product(productDTO) {}", productDTO);
        Product product = incluirProductService.incluir(productMapper.dtoToDomain(productDTO));

        return new ResponseEntity<>(productMapper.domainToDTO(product), HttpStatus.CREATED);
    }

    /**
     * Atualização de um produto
     *
     * @param id
     * @param novoProductDTO
     * @return
     */
    @PutMapping(value = "/products/{id}")
    public ResponseEntity<ProductDTO> atualizarProduct(@PathVariable("id") @Positive Long id,
            @RequestBody @Valid ProductDTO novoProductDTO) {

        log.info("atualizarProduct, identificador(id) {}", id);
        log.info("atualizarProduct, product(novoProductDTO) {}", novoProductDTO);
        Product resultado = atualizarProductService.atualizar(id, productMapper.dtoToDomain(novoProductDTO));

        return new ResponseEntity<>(productMapper.domainToDTO(resultado), HttpStatus.OK);
    }

    /**
     * Busca de um produto por ID
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductDTO> obterProduct(@PathVariable("id") @Positive Long id) {

        log.info("obterProduct, identificador(id) {}", id);
        Product resultado = obterProductService.obterPor(id);

        return new ResponseEntity<>(productMapper.domainToDTO(resultado), HttpStatus.OK);
    }

    /**
     * Lista de produtos
     *
     * @return
     */
    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDTO>> listarProducts() {

        log.info("listarProducts");
        List<Product> resultado = listarProductsService.listar();

        return new ResponseEntity<>(resultado.stream().map(productMapper::domainToDTO).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    /**
     * Lista de produtos filtrados
     *
     * @param min_price
     * @param max_price
     * @param q
     * @return
     */
    @GetMapping(value = "/products/search")
    public ResponseEntity<List<ProductDTO>> listarProductsFilter(@RequestParam(required = false) BigDecimal min_price, @RequestParam(required = false) BigDecimal max_price, @RequestParam(required = false) String q) {

        log.info("listarProductsFilter");
        log.info("q [" + q + "]");
        log.info("min_price [" + min_price.toString() + "]");


        List<Product> resultado = listarProductsFilterService.listarFilter(q, min_price, max_price);

        return new ResponseEntity<>(resultado.stream().map(productMapper::domainToDTO).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    /**
     * Deleção de um produto
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<ProductDTO> removerProduct(@PathVariable("id") @Positive Long id) {

        log.info("removerProduct, identificador(id) {}", id);
        removerProductService.removerPor(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
