/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.IncluirProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ObterProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.IncluirProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ObterProductService;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.memory.ProductPersistenceInMemoryDomainAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose.roldan
 */
public class ObterProductServiceTest {

    private ObterProductService obterProductService;
    private IncluirProductService incluirProductService;

    @BeforeEach
    public void setUp() {

        ProductPersistenceInMemoryDomainAdapter productPersistenceInMemoryDomainAdapter = new ProductPersistenceInMemoryDomainAdapter(new ArrayList<>());

        IncluirProductOutAdapter incluirProductOutAdapter = new IncluirProductOutAdapter(productPersistenceInMemoryDomainAdapter);
        ObterProductOutAdapter obterProductOutAdapter = new ObterProductOutAdapter(productPersistenceInMemoryDomainAdapter);

        obterProductService = new ObterProductService(obterProductOutAdapter);
        incluirProductService = new IncluirProductService(incluirProductOutAdapter);

    }

    @Test
    public void obterProduct_dadosCorretos_retornaEquals() {

        //dado - pré-condição ou configuração
        String name = "Pendrive 16GB B-Max";
        String description = "Pendrive 16GB B-Max USB 3";
        BigDecimal price = new BigDecimal("150.25");
        Product product1 = incluirProductService.incluir(new Product(null, name, description, price));

        // quando - ação ou o comportamento que vamos testar
        Product retorno = obterProductService.obterPor(product1.getId());

        // então - verifica a saída
        Assertions.assertEquals(product1, retorno);

    }

    @Test
    public void obterProduct_idIncorreto_retornaException() {

        //dado - pré-condição ou configuração
        String name = "Pendrive 16GB B-Max";
        String description = "Pendrive 16GB B-Max USB 3";
        BigDecimal price = new BigDecimal("150.25");
        Product product1 = incluirProductService.incluir(new Product(null, name, description, price));
        
        // então - verifica a saída
        assertThrows(ObterProductException.class, () -> obterProductService.obterPor(1457L));

    }

}
