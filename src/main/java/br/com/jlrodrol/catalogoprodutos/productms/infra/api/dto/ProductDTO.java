/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author jose.roldan
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private Long id;
    @NotEmpty(message = "Please enter a name, the name cannot be empty")
    private String name;
    @NotEmpty(message = "Please enter a description, the description cannot be empty")
    private String description;
    @Digits(integer = 6, fraction = 2, message = "Please enter a valid price, less than 999,999.99")
    @DecimalMin(value = "0", inclusive = false, message = "Please enter a valid price must be greater than 0")
    private BigDecimal price;

}
