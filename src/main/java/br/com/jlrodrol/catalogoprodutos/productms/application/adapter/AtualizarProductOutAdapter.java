/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.adapter;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository.ProductDomainRepository;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.port.out.AtualizarProductOutPort;
import java.util.Optional;
import lombok.AllArgsConstructor;

/**
 *
 * @author jose.roldan
 */
@AllArgsConstructor
public class AtualizarProductOutAdapter implements AtualizarProductOutPort {

    private final ProductDomainRepository repository;

    @Override
    public Product atualizar(Long id, Product product) {

        Optional<Product> productBD = repository.obterPor(id);

        if (productBD.isPresent()) {

            Product productAtualizado = new Product(id,
                    product.getName(),
                    product.getDescription(),
                    product.getPrice());

            return repository.incluir(productAtualizado);

        } else {

            throw new ObterProductException(id);
        }
    }

    @Override
    public Product modificar(Long id, Product product) {

        Optional<Product> productBD = repository.obterPor(id);

        if (productBD.isPresent()) {

            Product productAtualizado = new Product(id,
                    product.getName(),
                    product.getDescription(),
                    product.getPrice());

            return repository.incluir(productAtualizado);

        } else {

            throw new ObterProductException(id);
        }
    }
}
