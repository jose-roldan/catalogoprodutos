/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.spring;

import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.AtualizarProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.IncluirProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ListarProductsFilterOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ListarProductsOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.ObterProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.adapter.RemoverProductOutAdapter;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository.ProductDomainRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lemon
 */
@Configuration
public class BeanOutAdaptersConfig {

    ///// PRODUCT /////
    
    /**
     * Criação de um produto
     *
     * @param productDomainRepository
     * @return
     */
    @Bean
    public IncluirProductOutAdapter incluirProductOutAdapterBean(ProductDomainRepository productDomainRepository) {
        return new IncluirProductOutAdapter(productDomainRepository);
    }

    /**
     * Atualização de um produto
     *
     * @param productDomainRepository
     * @return
     */
    @Bean
    public AtualizarProductOutAdapter atualizarProductOutAdapterBean(ProductDomainRepository productDomainRepository) {
        return new AtualizarProductOutAdapter(productDomainRepository);
    }

    /**
     * Busca de um produto por ID
     *
     * @param productDomainRepository
     * @return
     */
    @Bean
    public ObterProductOutAdapter obterProductOutAdapterBean(ProductDomainRepository productDomainRepository) {
        return new ObterProductOutAdapter(productDomainRepository);
    }

    /**
     * Lista de produtos
     *
     * @param productDomainRepository
     * @return
     */
    @Bean
    public ListarProductsOutAdapter listarProductsOutAdapterBean(ProductDomainRepository productDomainRepository) {
        return new ListarProductsOutAdapter(productDomainRepository);
    }

    /**
     * Lista de produtos filtrados
     *
     * @param productDomainRepository
     * @return
     */
    @Bean
    public ListarProductsFilterOutAdapter listarProductsFilterOutAdapterBean(ProductDomainRepository productDomainRepository) {
        return new ListarProductsFilterOutAdapter(productDomainRepository);
    }

    /**
     * Remover um produto
     *
     * @param productDomainRepository
     * @return
     */
    @Bean
    public RemoverProductOutAdapter removerProductOutAdapterBean(ProductDomainRepository productDomainRepository) {
        return new RemoverProductOutAdapter(productDomainRepository);
    }

}
