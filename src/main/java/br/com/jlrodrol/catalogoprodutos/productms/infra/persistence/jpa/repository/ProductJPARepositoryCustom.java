/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.repository;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.model.ProductModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lemon
 */
public interface ProductJPARepositoryCustom {

    List<ProductModel> findRuleByParameters(final String q, final BigDecimal min_price, final BigDecimal max_price);
    
}
