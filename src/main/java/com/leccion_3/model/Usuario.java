/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leccion_3.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author igorr
 */
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String email;
    private String username;
    private String password;
    private int estatus;
    //no utilizar MAYUCULAS
    private Date fecharegistro ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Usuarioperfil",
               joinColumns = @JoinColumn(name="idusuario"),
               inverseJoinColumns = @JoinColumn(name="idperfil"))
    //Hay que iniciar la losta ,sino no funciona
    private List<Perfil> perfiles = new LinkedList<Perfil>();
    
    public void agregar(Perfil tempPerfil){
        //lo que hace el if es basicamente si perfil es nullo se crea nuevo perfil, 
        //en cambio se añade el perfil existente
        if(perfiles==null){
            List <Perfil> listaPerfiles= new LinkedList<Perfil>();
        }
        perfiles.add(tempPerfil);
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fecharegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public int getEstatus() {
        return estatus;
    }

    public Date getFechaRegistro() {
        return fecharegistro;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", username=" + username + ", estatus=" + estatus + ", fechaRegistro=" + fecharegistro + '}';
    }
    
    
}
