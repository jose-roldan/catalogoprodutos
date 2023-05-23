/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.adapter;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository.ProductDomainRepository;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ListarProductsFilterOutPort;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ListarProductsOutPort;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

/**
 *
 * @author lemon
 */
@AllArgsConstructor
public class ListarProductsFilterOutAdapter implements ListarProductsFilterOutPort {

    private final ProductDomainRepository repository;

    @Override
    public List<Product> listarFilter(String q, BigDecimal min_price, BigDecimal max_price) {
        
        Optional<List<Product>> products = repository.listarFilter(q, min_price, max_price);

        if (products.isPresent() && !products.get().isEmpty()) {
            return products.get();
        } else {
            return new ArrayList<>();
        }
    }

}
