/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.port.in;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;

/**
 *
 * @author lemon
 */
public interface IncluirProductUseCase {

    Product incluir(Product product);

}