/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.port.in.RemoverProductUseCase;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.RemoverProductOutPort;
import lombok.AllArgsConstructor;

/**
 *
 * @author lemon
 */
@AllArgsConstructor
public class RemoverProductService implements RemoverProductUseCase {

    private final RemoverProductOutPort removerProductOutPort;

    @Override
    public void removerPor(Long id) {

        removerProductOutPort.removerPor(id);

    }

}
