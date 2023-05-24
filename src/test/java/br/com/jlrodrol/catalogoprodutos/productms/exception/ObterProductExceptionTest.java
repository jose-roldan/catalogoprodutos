/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.exception;

import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose.roldan
 */
public class ObterProductExceptionTest {

    @Test
    public void getId_exception_test() {

        ObterProductException exception = new ObterProductException(1L);
        assertEquals(1L, exception.getId());

    }

}
