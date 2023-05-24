/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.api.dto.mappers;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import br.com.jlrodrol.catalogoprodutos.productms.infra.api.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose.roldan
 */
@Component
@AllArgsConstructor
public class ProductMapper {

    public Product dtoToDomain(ProductDTO productDTO) {

        return new Product(productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice());
    }

    public ProductDTO domainToDTO(Product product) {

        return new ProductDTO(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }
}
