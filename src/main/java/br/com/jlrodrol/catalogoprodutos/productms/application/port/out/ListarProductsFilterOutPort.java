/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.port.out;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jose.roldan
 */
public interface ListarProductsFilterOutPort {

    List<Product> listarFilter(String q, BigDecimal min_price, BigDecimal max_price);

}
