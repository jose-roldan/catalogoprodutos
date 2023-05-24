/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.spring;

import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.memory.ProductPersistenceInMemoryDomainAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 *
 * @author jose.roldan
 */
@Component
@Profile({"test"})
public class BeanMemoryAdaptersConfig {

    @Bean
    public ProductPersistenceInMemoryDomainAdapter productPersistenceInMemoryDomainAdapterBean() {
        return new ProductPersistenceInMemoryDomainAdapter(new ArrayList<>());
    }

}
