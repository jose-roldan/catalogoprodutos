/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.adapter;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository.ProductDomainRepository;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.RemoverProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.RemoverProductOutPort;
import java.util.Optional;
import lombok.AllArgsConstructor;

/**
 *
 * @author lemon
 */
@AllArgsConstructor
public class RemoverProductOutAdapter implements RemoverProductOutPort {

    private final ProductDomainRepository repository;

    @Override
    public void removerPor(Long id) {

        Optional<Product> productBD = repository.obterPor(id);

        if (productBD.isPresent()) {
            repository.removerPor(id);
        } else {
            throw new RemoverProductException(id);
        }
    }

}
