/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.in.AtualizarProductUseCase;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.AtualizarProductOutPort;
import lombok.AllArgsConstructor;

/**
 *
 * @author jose.roldan
 */
@AllArgsConstructor
public class AtualizarProductService implements AtualizarProductUseCase {

    private final AtualizarProductOutPort atualizarProductOutPort;

    @Override
    public Product atualizar(Long id, Product novoProduct) {

        return atualizarProductOutPort.atualizar(id, novoProduct);
    }

    @Override
    public Product modificar(Long id, Product novoProduct) {

        return atualizarProductOutPort.modificar(id, novoProduct);
    }
}
