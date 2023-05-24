/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.adapter;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository.ProductDomainRepository;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.ObterProductOutPort;
import lombok.AllArgsConstructor;

/**
 *
 * @author jose.roldan
 */
@AllArgsConstructor
public class ObterProductOutAdapter implements ObterProductOutPort {

    private final ProductDomainRepository repository;

    @Override
    public Product obterPor(Long id) {

        return repository.obterPor(id)
                .orElseThrow(() -> new ObterProductException(id));
    }

}
