/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.application.domain.repository.ProductDomainRepository;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.model.ProductModel;
import br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.repository.ProductJPARepository;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author jose.roldan
 */
@AllArgsConstructor
public class ProductPersistenceJpaDomainAdapter implements ProductDomainRepository {

    private final ProductJPARepository jpa;

    @Override
    public Product incluir(Product product) {
        return jpa.save(ProductModel.fromDomain(product)).toDomain();
    }

    @Override
    public Optional<List<Product>> listar() {

        List<ProductModel> productModelsList = jpa.findAll();

        return Optional.of(productModelsList.stream().map(ProductModel::toDomain).collect(Collectors.toList()));
    }

    @Override
    public Optional<Product> obterPor(Long id) {

        Optional<ProductModel> productModel = jpa.findById(id);

        return productModel.isEmpty() ? Optional.empty() : Optional.of(productModel.get().toDomain());
    }

    @Override
    public Optional<Product> obterPorName(String productName) {

        Optional<ProductModel> productModel = jpa.findByName(productName);

        return productModel.isEmpty() ? Optional.empty() : Optional.of(productModel.get().toDomain());
    }

    @Override
    public void removerPor(Long id) {

        Optional<ProductModel> productDB = jpa.findById(id);
        ProductModel productModel = new ProductModel();
        if (productDB.isPresent()) {
            productModel.setId(id);
            productModel.setName(productDB.get().getName());
            productModel.setDescription(productDB.get().getDescription());
            productModel.setPrice(productDB.get().getPrice());

            jpa.delete(productModel);

        }
    }

    @Override
    public Optional<List<Product>> listarFilter(String q, BigDecimal min_price, BigDecimal max_price) {
        
        List<ProductModel> productModelsFilterList = jpa.findProductFilterParameters(q,min_price, max_price);

        return Optional.of(productModelsFilterList.stream().map(ProductModel::toDomain).collect(Collectors.toList()));

    }
}
