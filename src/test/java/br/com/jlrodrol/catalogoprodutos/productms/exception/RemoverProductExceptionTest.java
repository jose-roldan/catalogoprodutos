/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.exception;

import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.RemoverProductException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lemon
 */
public class RemoverProductExceptionTest {

    @Test
    public void getId_exception_test() {

        RemoverProductException exception = new RemoverProductException(1L);
        assertEquals(1L, exception.getId());

    }
}
