/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.IncluirProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ListarProductsOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.IncluirProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ListarProductsService;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.memory.ProductPersistenceInMemoryDomainAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lemon
 */
public class ListarProductsServiceTest {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ListarProductsServiceTest.class);
    private ListarProductsService listarProductsService;
    private IncluirProductService incluirProductService;

    @BeforeEach
    public void setUp() {

        ProductPersistenceInMemoryDomainAdapter productPersistenceInMemoryDomainAdapter = new ProductPersistenceInMemoryDomainAdapter(new ArrayList<>());

        IncluirProductOutAdapter incluirProductOutAdapter = new IncluirProductOutAdapter(productPersistenceInMemoryDomainAdapter);
        incluirProductService = new IncluirProductService(incluirProductOutAdapter);

        ListarProductsOutAdapter listarProductsOutAdapter = new ListarProductsOutAdapter(productPersistenceInMemoryDomainAdapter);
        listarProductsService = new ListarProductsService(listarProductsOutAdapter);

    }

    @Test
    public void listarProduct_comDadosCorretos_retornaListaComProducts() {

        logger.info("Teste listar os Product");

        //dado - pré-condição ou configuração
        String name = "Pendrive 16GB B-Max";
        String description = "Pendrive 16GB B-Max USB 3";
        BigDecimal price = new BigDecimal("150.25");
        Product product1 = incluirProductService.incluir(new Product(null, name, description, price));

        name = "Pendrive 32GB B-Max";
        description = "Pendrive 32GB B-Max USB 3.1";
        price = new BigDecimal("310.25");
        Product product2 = incluirProductService.incluir(new Product(null, name, description, price));

        // quando - ação ou o comportamento que vamos testar
        List<Product> listadoProducts = listarProductsService.listar();

        // então - verifica a saída
        assertThat(listadoProducts).isNotNull();
        assertThat(listadoProducts.size()).isEqualTo(2);

    }

    @Test
    public void listarProducts_vazio_retornaNotNull() {

        logger.info("Teste listar Product vazio");

        // quando - ação ou o comportamento que vamos testar
        List<Product> listadoProducts = listarProductsService.listar();

        // então - verifica a saída
        assertThat(listadoProducts).isNotNull();
        assertThat(listadoProducts.size()).isEqualTo(0);
    }

}
