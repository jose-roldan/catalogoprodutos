/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.exception;

import br.com.jlrodrol.catalogoprodutos.productms.application.exception.IncluirProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose.roldan
 */
public class IncluirProductExceptionTest {

    @Test
    public void getNameProduct_exception_test() {

        IncluirProductException exception = new IncluirProductException("Pendrive 16GB B-Max");
        assertEquals("Pendrive 16GB B-Max", exception.getNameProduct());

    }

}
