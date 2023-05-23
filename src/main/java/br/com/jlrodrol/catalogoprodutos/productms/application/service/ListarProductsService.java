/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.service;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.in.ListarProductsUseCase;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ListarProductsOutPort;
import java.util.List;
import lombok.AllArgsConstructor;

/**
 *
 * @author lemon
 */
@AllArgsConstructor
public class ListarProductsService implements ListarProductsUseCase {

    private final ListarProductsOutPort listarProductsOutPort;

    @Override
    public List<Product> listar() {

        return listarProductsOutPort.listar();
    }

}
