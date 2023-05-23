/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.IncluirProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.IncluirProductService;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.memory.ProductPersistenceInMemoryDomainAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lemon
 */
public class IncluirProductServiceTest {

    private IncluirProductService incluirProductService;

    @BeforeEach
    public void setUp() {

        ProductPersistenceInMemoryDomainAdapter productPersistenceInMemoryDomainAdapter
                = new ProductPersistenceInMemoryDomainAdapter(new ArrayList<>());

        IncluirProductOutAdapter incluirProductOutAdapter
                = new IncluirProductOutAdapter(productPersistenceInMemoryDomainAdapter);

        incluirProductService = new IncluirProductService(incluirProductOutAdapter);
    }
    
    @Test
    public void incluirProduct_comDadosCorretos_retornaProduct() {
        
        String name = "Pendrive 16GB B-Max";
        String description = "Pendrive 16GB B-Max USB 3";
        BigDecimal price= new BigDecimal("150.25");    
        Product product1 = new Product(null, name, description, price);
        Product product2 = incluirProductService.incluir(product1);
        
        assertNotNull(product2.getId());
        assertEquals(name, product2.getName());
    
    }
}
