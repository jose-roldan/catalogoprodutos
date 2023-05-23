/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author lemon
 */
public interface ProductDomainRepository {

    Product incluir(Product product);

    Optional<List<Product>> listar();
    
    Optional<List<Product>> listarFilter(String q, BigDecimal min_price, BigDecimal max_price);

    Optional<Product> obterPor(Long id);

    Optional<Product> obterPorName(String productName);

    void removerPor(Long id);

}
