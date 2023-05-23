/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.adapter;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository.ProductDomainRepository;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.IncluirProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.IncluirProductOutPort;
import java.util.Optional;
import lombok.AllArgsConstructor;

/**
 *
 * @author lemon
 */
@AllArgsConstructor
public class IncluirProductOutAdapter implements IncluirProductOutPort {

    private final ProductDomainRepository repository;

    @Override
    public Product incluir(Product product) {
        Optional<Product> existeName = repository.obterPorName(product.getName());

        if (existeName.isPresent()) {
            throw new IncluirProductException(product.getName());
        }

        return repository.incluir(product);
    }

}
