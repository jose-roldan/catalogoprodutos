/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.memory;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository.ProductDomainRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

/**
 *
 * @author jose.roldan
 */
@AllArgsConstructor
public class ProductPersistenceInMemoryDomainAdapter implements ProductDomainRepository {

    private List<Product> products;

    /**
     * Gera o proximo id baseado em todas os product que estao na memoria.
     *
     * @return id
     */
    private Long gerarId() {

        return products.isEmpty() ? 1
                : products.size() + 1L;
    }

    @Override
    public Product incluir(Product product) {

        if (product.getId() != null) {
            obterPor(product.getId()).ifPresent(products::remove);
            products.add(product);
            return product;
        } else {
            Product productComId = new Product(gerarId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice());

            products.add(productComId);
            return productComId;
        }
    }

    @Override
    public Optional<List<Product>> listar() {

        return Optional.of(products == null ? new ArrayList<>() : products);
    }

    @Override
    public Optional<Product> obterPor(Long id) {

        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Product> obterPorName(String productName) {

        return products.stream().filter(p -> p.getName().equals(productName)).findFirst();
    }

    @Override
    public void removerPor(Long id) {

        Optional<Product> productPorId = obterPor(id);

        if (productPorId.isPresent()) {
            products.remove(productPorId.get());
        }
    }

    @Override
    public Optional<List<Product>> listarFilter(String q, BigDecimal min_price, BigDecimal max_price) {

        List<Product> productsFilter = new ArrayList<>();
        List<Product> outProducts = new ArrayList<>();
        Integer countFilter = 0;
        if (q != null && !q.trim().isEmpty()) {
            productsFilter = products.stream()
                    .filter(product -> product.getName().toUpperCase().contains(q.toUpperCase()))
                    .collect(Collectors.toList());

            productsFilter = products.stream()
                    .filter(product -> product.getDescription().toUpperCase().contains(q.toUpperCase()))
                    .collect(Collectors.toList());

            countFilter++;

        }
        if (min_price != null && !(min_price.compareTo(BigDecimal.ZERO) == 0)) {
            for (Product product : products) {
                if (product.getPrice().compareTo(min_price) > 0) {
                    productsFilter.add(product);
                }
            }

            countFilter++;

        }
        if (max_price != null && !(max_price.compareTo(BigDecimal.ZERO) == 0)) {
            for (Product product : products) {
                if (product.getPrice().compareTo(max_price) < 0) {
                    productsFilter.add(product);
                }
            }

            countFilter++;

        }

        Map<Product, Integer> mapProducts = new HashMap<>();
        for (Product product : productsFilter) {
            if (mapProducts.containsKey(product)) {
                mapProducts.put(product, mapProducts.get(product) + 1);
            } else {
                mapProducts.put(product, 1);
            }
        }

        List<Product> dup = new ArrayList<>();
        for (Product product : productsFilter) {
            int count = mapProducts.get(product);
            if (count >= countFilter) {
                dup.add(product);
            }
        }

        outProducts = dup.stream().distinct().collect(Collectors.toList());

        return Optional.of(outProducts.isEmpty() ? new ArrayList<>() : outProducts);
    }

}
