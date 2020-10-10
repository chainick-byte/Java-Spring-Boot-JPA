/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leccion_3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author igorr
 */
@Entity
@Table(name="perfiles")
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String perfil;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public String getPerfil() {
        return perfil;
    }

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", perfil=" + perfil + '}';
    }
    
    
    
}
