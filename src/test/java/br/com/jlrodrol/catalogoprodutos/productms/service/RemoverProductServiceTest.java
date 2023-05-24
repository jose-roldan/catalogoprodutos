/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.IncluirProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ObterProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.RemoverProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.RemoverProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.IncluirProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ObterProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.RemoverProductService;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.memory.ProductPersistenceInMemoryDomainAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose.roldan
 */
public class RemoverProductServiceTest {

    private RemoverProductService removerProductService;
    private IncluirProductService incluirProductService;
    private ObterProductService obterProductService;

    @BeforeEach
    public void setUp() {

        ProductPersistenceInMemoryDomainAdapter productPersistenceInMemoryDomainAdapter = new ProductPersistenceInMemoryDomainAdapter(new ArrayList<>());

        RemoverProductOutAdapter removerProductOutAdapter = new RemoverProductOutAdapter(productPersistenceInMemoryDomainAdapter);
        IncluirProductOutAdapter incluirProductOutAdapter = new IncluirProductOutAdapter(productPersistenceInMemoryDomainAdapter);
        ObterProductOutAdapter obterProductOutAdapter = new ObterProductOutAdapter(productPersistenceInMemoryDomainAdapter);

        removerProductService = new RemoverProductService(removerProductOutAdapter);
        incluirProductService = new IncluirProductService(incluirProductOutAdapter);
        obterProductService = new ObterProductService(obterProductOutAdapter);
    }

    @Test
    public void removerProduct_dadosCorretos_retornaException() {

        //dado - pré-condição ou configuração
        String name = "Pendrive 16GB B-Max";
        String description = "Pendrive 16GB B-Max USB 3";
        BigDecimal price = new BigDecimal("150.25");
        Product retorno = incluirProductService.incluir(new Product(null, name, description, price));

        // quando - ação ou o comportamento que vamos testar
        removerProductService.removerPor(retorno.getId());

        // então - verifica a saída
        assertThrows(RemoverProductException.class, () -> removerProductService.removerPor(retorno.getId()));

    }

    @Test
    public void removerProduct_idIncorreto_retornaException() {

        // então - verifica a saída
        assertThrows(RemoverProductException.class, () -> removerProductService.removerPor(1547L));

    }

}
