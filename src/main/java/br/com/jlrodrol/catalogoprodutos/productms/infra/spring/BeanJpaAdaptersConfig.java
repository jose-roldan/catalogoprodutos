/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.spring;

import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.ProductPersistenceJpaDomainAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.repository.ProductJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose.roldan
 */
@Component
@Profile({"dev"})
public class BeanJpaAdaptersConfig {

    @Bean
    public ProductPersistenceJpaDomainAdapter productPersistenceJpaDomainAdapterBean(ProductJPARepository productJPARepository) {
        return new ProductPersistenceJpaDomainAdapter(productJPARepository);
    }

}
