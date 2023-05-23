/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.domain.entity;

import static java.lang.Boolean.TRUE;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 *
 * @author lemon
 */
@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class Product {

    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public static Boolean comparaProduct(Product productBD, Product novoProduct) {

        boolean semModificacoes = TRUE;

        return semModificacoes;
    }
}
