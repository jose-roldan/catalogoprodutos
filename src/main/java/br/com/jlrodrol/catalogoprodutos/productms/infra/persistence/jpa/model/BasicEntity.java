/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jlrodrol.catalogoprodutos.productms.infra.persistence.jpa.model;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author lemon
 */
@MappedSuperclass
public abstract class BasicEntity {

    public abstract Long getId();

}
