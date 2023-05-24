/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.repository;

import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author jose.roldan
 */
@Repository
public interface ProductJPARepository extends JpaRepository<ProductModel, Long>, ProductJPARepositoryCustom {

    Optional<ProductModel> findByName(String productName);

//    @Query("SELECT p FROM products p "
//            + "WHERE ((:q='' or) or ")
//    Optional<ProductModel> findByMinPriceMaxPriceQ(final String q, final BigDecimal min_price, final BigDecimal max_price);

//    @Query(value = theDynamicQuery, nativeQuery = true)
//    Optional<ProductModel> findRuleByParameters(final String q, final BigDecimal min_price, final BigDecimal max_price);

}
