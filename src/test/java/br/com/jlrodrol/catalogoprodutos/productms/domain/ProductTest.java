/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.domain;

import br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity.Product;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lemon
 */
public class ProductTest {

    @Test
    public void getNameProduct_dadosCorretos_retornaOk() {

        String name = "Pendrive 16GB B-Max";
        String description = "Pendrive 16GB B-Max USB 3";
        BigDecimal price = new BigDecimal("150.25");
        Product product1 = new Product(null, name, description, price);

        assertEquals(product1.getName(), name);

    }

}
