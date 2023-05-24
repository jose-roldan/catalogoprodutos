/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.spring;

import br.com.jlrodrol.catalogoprodutos.productms.application.exception.IncluirProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ListarProductsException;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.ObterProductException;
import br.com.jlrodrol.catalogoprodutos.productms.application.exception.RemoverProductException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 *
 * @author jose.roldan
 */
//@ControllerAdvice
//public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
//
//
//}
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(IncluirProductException.class)
    public ResponseEntity<?> handleIncluirProductException(IncluirProductException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 409);
        body.put("message", "Producto com o nome: " + ex.getNameProduct() + " já existe no sistema.");

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ListarProductsException.class)
    public ResponseEntity<?> handleListarProductsException(ListarProductsException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 404);
        body.put("message", "Nenhum product encontrado.");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObterProductException.class)
    public ResponseEntity<?> handleObterProductException(ObterProductException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 404);
        body.put("message", "Product não encontrado. Id: " + ex.getId());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RemoverProductException.class)
    public ResponseEntity<?> handleRemoverProductException(RemoverProductException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 404);
        body.put("message", "Product não encontrado. Id: " + ex.getId());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        List<String> erros = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            erros.add(error.getDefaultMessage());
        });

        body.put("status_code", 400);
//        erros.stream().forEach((e) -> body.put("message", e));
        body.put("message", erros.toString());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 400);
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 400);
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 400);
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 400);
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status_code", 405);
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.METHOD_NOT_ALLOWED);

    }

}
