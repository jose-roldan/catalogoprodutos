/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.exception;

import lombok.Getter;

/**
 *
 * @author lemon
 */
@Getter
public class RemoverProductException extends RuntimeException {

    private final Long id;

    public RemoverProductException(Long id) {
        super();
        this.id = id;
    }
}
