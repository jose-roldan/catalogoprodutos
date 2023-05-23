/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.port.out;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import java.util.List;

/**
 *
 * @author lemon
 */
public interface ListarProductsOutPort {

    List<Product> listar();

}
