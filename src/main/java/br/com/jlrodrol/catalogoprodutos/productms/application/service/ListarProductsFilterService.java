/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.in.ListarProductsFilterUseCase;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.in.ListarProductsUseCase;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ListarProductsFilterOutPort;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ListarProductsOutPort;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;

/**
 *
 * @author lemon
 */
@AllArgsConstructor
public class ListarProductsFilterService implements ListarProductsFilterUseCase {

    private final ListarProductsFilterOutPort listarProductsFilterOutPort;

    @Override
    public List<Product> listarFilter(String q, BigDecimal min_price, BigDecimal max_price) {
        return listarProductsFilterOutPort.listarFilter(q, min_price, max_price);
    }

}
