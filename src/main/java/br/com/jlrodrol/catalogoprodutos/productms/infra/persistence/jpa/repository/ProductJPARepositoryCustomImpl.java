/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.repository;

import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.model.ProductModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lemon
 */
@Slf4j
@Repository
public class ProductJPARepositoryCustomImpl implements ProductJPARepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductModel> findRuleByParameters(String q, BigDecimal min_price, BigDecimal max_price) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ProductModel> query = cb.createQuery(ProductModel.class);
//        Root<ProductModel> productModel = query.from(ProductModel.class);
//        
//        List<Predicate> predicates = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * from products ");
        sql.append("WHERE 1 = 1 ");

        if (q != null && !q.trim().isEmpty()) {
            sql.append("AND (UPPER(name) like '%");
            sql.append(q.toUpperCase());
            sql.append("%' ");
            sql.append("OR ");
            sql.append("UPPER(description) like '%");
            sql.append(q.toUpperCase());
            sql.append("%') ");
        }
        if (min_price != null && !(min_price.compareTo(BigDecimal.ZERO) == 0)) {
            sql.append("AND price >=  ");
            sql.append(min_price);
            sql.append(" ");
        }
        if (max_price != null && !(max_price.compareTo(BigDecimal.ZERO) == 0)) {
            sql.append("AND price <=  ");
            sql.append(max_price);
            sql.append(" ");
        }
        
        log.info("sql [" + sql + "]");


        return entityManager.createNativeQuery(sql.toString()).getResultList();

    }

}
