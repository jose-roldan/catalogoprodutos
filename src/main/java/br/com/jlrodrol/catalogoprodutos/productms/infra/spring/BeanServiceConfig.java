/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.spring;

import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.AtualizarProductOutPort;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.IncluirProductOutPort;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ListarProductsFilterOutPort;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ListarProductsOutPort;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ObterProductOutPort;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.RemoverProductOutPort;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.AtualizarProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.IncluirProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ListarProductsFilterService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ListarProductsService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.ObterProductService;
import br.com.jlrodrol.catalogoprodutos.productms.application.service.RemoverProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lemon
 */
@Configuration
public class BeanServiceConfig {

    ///// PRODUCT /////
    
    /**
     * Criação de um produto
     *
     * @param incluirProductOutPort
     * @return
     */
    @Bean
    public IncluirProductService incluirProductServiceBean(IncluirProductOutPort incluirProductOutPort) {
        return new IncluirProductService(incluirProductOutPort);
    }

    /**
     * Atualização de um produto
     *
     * @param atualizarProductOutPort
     * @return
     */
    @Bean
    public AtualizarProductService atualizarProductServiceBean(AtualizarProductOutPort atualizarProductOutPort) {
        return new AtualizarProductService(atualizarProductOutPort);
    }
    
    /**
     * Busca de um produto por ID
     *
     * @param obterProductOutPort
     * @return
     */
    @Bean
    public ObterProductService obterProductServiceBean(ObterProductOutPort obterProductOutPort) {
        return new ObterProductService(obterProductOutPort);
    }

    /**
     * Lista de produtos
     *
     * @param listarProductsOutPort
     * @return
     */
    @Bean
    public ListarProductsService listarProductsServiceBean(ListarProductsOutPort listarProductsOutPort) {
        return new ListarProductsService(listarProductsOutPort);
    }
    
    /**
     * Lista de produtos filtrados
     * 
     * @param listarProductsFilterOutPort
     * @return 
     */
    @Bean
    public ListarProductsFilterService listarProductsFilterServiceBean(ListarProductsFilterOutPort listarProductsFilterOutPort) {
        return new ListarProductsFilterService(listarProductsFilterOutPort);
    }
    
    /**
     * Remover um produto
     *
     * @param removerProductOutPort
     * @return
     */
    @Bean
    public RemoverProductService removerProductServiceBean(RemoverProductOutPort removerProductOutPort) {
        return new RemoverProductService(removerProductOutPort);
    }

}
