/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.repository;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.model.ProductModel;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jose.roldan
 */
@Slf4j
@Repository
public class ProductJPARepositoryCustomImpl implements ProductJPARepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductModel> findProductFilterParameters(String q, BigDecimal min_price, BigDecimal max_price) {
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

        List<Object> tmp = entityManager.createNativeQuery(sql.toString()).getResultList();

        List<ProductModel> newProductsFilter = new ArrayList<>();

        for (int i = 0; i < tmp.size(); i++) {
            Object[] row = (Object[]) tmp.get(i);
            ProductModel proMod = new ProductModel();
            if (row[0] instanceof BigInteger) {
                BigInteger id = (BigInteger) row[0];
                proMod.setId(id.longValue());
                log.info("id [" + id + "]");
            }
            if (row[1] instanceof String) {
                String name = (String) row[1];
                proMod.setName(name);
                log.info("name [" + name + "]");
            }
            if (row[2] instanceof String) {
                String description = (String) row[2];
                proMod.setDescription(description);
                log.info("description [" + description + "]");
            }
            if (row[3] instanceof BigDecimal) {
                BigDecimal price = (BigDecimal) row[3];
                proMod.setPrice(price);
                log.info("price [" + price + "]");
            }

            newProductsFilter.add(proMod);
        }

        return newProductsFilter;

    }

}
