/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.in.IncluirProductUseCase;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.IncluirProductOutPort;
import lombok.AllArgsConstructor;

/**
 *
 * @author lemon
 */
@AllArgsConstructor
public class IncluirProductService implements IncluirProductUseCase {

    private final IncluirProductOutPort incluirProductOutPort;

    @Override
    public Product incluir(Product product) {

        return incluirProductOutPort.incluir(product);
    }

}
