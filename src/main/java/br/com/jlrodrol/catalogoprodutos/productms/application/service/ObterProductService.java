/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.in.ObterProductUseCase;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ObterProductOutPort;
import lombok.AllArgsConstructor;

/**
 *
 * @author jose.roldan
 */
@AllArgsConstructor
public class ObterProductService implements ObterProductUseCase {

    private final ObterProductOutPort obterProductOutPort;

    @Override
    public Product obterPor(Long id) {

        return obterProductOutPort.obterPor(id);
    }

}
