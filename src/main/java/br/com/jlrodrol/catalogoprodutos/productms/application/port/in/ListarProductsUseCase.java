/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.port.in;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;

import java.util.List;

/**
 *
 * @author jose.roldan
 */
public interface ListarProductsUseCase {

    List<Product> listar();

}
