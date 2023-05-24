/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.application.exception;

import lombok.Getter;

/**
 *
 * @author jose.roldan
 */
@Getter
public class ObterProductException extends RuntimeException {

    private final Long id;

    public ObterProductException(Long id) {
        super();
        this.id = id;
    }
}
