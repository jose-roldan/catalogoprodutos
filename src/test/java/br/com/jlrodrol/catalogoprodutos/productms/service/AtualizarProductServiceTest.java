/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.AtualizarProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.IncluirProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ObterProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.AtualizarProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.IncluirProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ObterProductService;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.memory.ProductPersistenceInMemoryDomainAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lemon
 */
public class AtualizarProductServiceTest {

    private AtualizarProductService atualizarProductService;
    private IncluirProductService incluirProductService;
    private ObterProductService obterProductService;

    @BeforeEach
    public void setUp() {

        ProductPersistenceInMemoryDomainAdapter productPersistenceInMemoryDomainAdapter
                = new ProductPersistenceInMemoryDomainAdapter(new ArrayList<>());

        AtualizarProductOutAdapter atualizarProductOutAdapter
                = new AtualizarProductOutAdapter(productPersistenceInMemoryDomainAdapter);
        IncluirProductOutAdapter incluirProductOutAdapter
                = new IncluirProductOutAdapter(productPersistenceInMemoryDomainAdapter);
        ObterProductOutAdapter obterProductOutAdapter
                = new ObterProductOutAdapter(productPersistenceInMemoryDomainAdapter);

        atualizarProductService = new AtualizarProductService(atualizarProductOutAdapter);
        incluirProductService = new IncluirProductService(incluirProductOutAdapter);
        obterProductService = new ObterProductService(obterProductOutAdapter);
    }

    @Test
    public void atualizarProduct_dadosCorretos_retornaProduct() {

        String name = "Pendrive 16GB B-Max";
        Product product1 = new Product(null, name, "Pendrive 16GB B-Max USB 3", new BigDecimal("150.25"));

        Product productIncluido = incluirProductService.incluir(product1);

        String newName = "Pendrive 32GB B-Max";
        String newDescription = "Pendrive 32GB B-Max USB 3.1";
        BigDecimal newPrice = new BigDecimal("150.25");
        Product newProduct = new Product(productIncluido.getId(), newName, newDescription, newPrice);
        atualizarProductService.atualizar(productIncluido.getId(), newProduct);

        assertEquals(newProduct.getName(), obterProductService.obterPor(productIncluido.getId()).getName());

    }

    @Test
    public void atualizarProduct_idIncorreto_retornaException() {

        String name = "Pendrive 16GB B-Max";
        Product product1 = new Product(null, name, "Pendrive 16GB B-Max USB 3", new BigDecimal("150.25"));

        Product productIncluido = incluirProductService.incluir(product1);

        String newName = "Pendrive 32GB B-Max";
        String newDescription = "Pendrive 32GB B-Max USB 3.1";
        BigDecimal newPrice = new BigDecimal("150.25");
        var newProduct = new Product(1557L, newName, newDescription, newPrice);

        assertThrows(ObterProductException.class, () -> atualizarProductService.atualizar(7L, newProduct));

    }

}
