/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.IncluirProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ListarProductsFilterOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ListarProductsOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.IncluirProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ListarProductsFilterService;
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
public class ListarProductsFilterServiceTest {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ListarProductsFilterServiceTest.class);
    private ListarProductsFilterService listarProductsFilterService;
    private IncluirProductService incluirProductService;

    @BeforeEach
    public void setUp() {

        ProductPersistenceInMemoryDomainAdapter productPersistenceInMemoryDomainAdapter = new ProductPersistenceInMemoryDomainAdapter(new ArrayList<>());

        IncluirProductOutAdapter incluirProductOutAdapter = new IncluirProductOutAdapter(productPersistenceInMemoryDomainAdapter);
        incluirProductService = new IncluirProductService(incluirProductOutAdapter);

        ListarProductsFilterOutAdapter listarProductsFilterOutAdapter = new ListarProductsFilterOutAdapter(productPersistenceInMemoryDomainAdapter);
        listarProductsFilterService = new ListarProductsFilterService(listarProductsFilterOutAdapter);

    }

    @Test
    public void listarProduct_comDadosCorretos_retornaListaComProducts() {

        logger.info("Teste listar os Product filter");

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
        String q = "32GB";
        BigDecimal min_price= new BigDecimal("200.50");
        BigDecimal max_price= new BigDecimal("520.25");     
        List<Product> listadoProductsFilter = listarProductsFilterService.listarFilter(q, min_price, max_price);

        // então - verifica a saída
        assertThat(listadoProductsFilter).isNotNull();
        assertThat(listadoProductsFilter.size()).isEqualTo(1);

    }

    @Test
    public void listarProducts_vazio_retornaNotNull() {

        logger.info("Teste listar Product vazio");
        
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
        String q = "64GB";
        BigDecimal min_price= new BigDecimal("200.50");
        BigDecimal max_price= new BigDecimal("520.25");     
        List<Product> listadoProductsFilter = listarProductsFilterService.listarFilter(q, min_price, max_price);
        
        // então - verifica a saída
        assertThat(listadoProductsFilter).isNotNull();
        assertThat(listadoProductsFilter.size()).isEqualTo(0);
    }

}
