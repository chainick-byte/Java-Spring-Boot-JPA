/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leccion_3.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author igorr
 */
@Entity
@Table(name="vacantes")
public class Vacante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Double salario;
    private int destacado;
    //al definir la variable imagen aqui , lo que sucedera es que al no tener imagenes se 
    //imprimira esa por defecto la que esta definida aqui
    private String imagen="nologo.png";
    //Añado variables que me faltan los que estan en la vista para poder hacer data binding, genero setters y getters
    //restantes y reescribo el metodo toString
    private String estatus;
    private String detalles;
    //@Transient
    @OneToOne
    @JoinColumn(name="idcategoria")
    private Categoria categoria;

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getDetalles() {
        return detalles;
    }

    
    // al tener todos los metodos de getter y setter de todas las variables , la clase Vacante
    //se convierte en una clase de tipo BEAN 
    //se autogenerea con BD "insert code"
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setDestacado(int destacado) {
        this.destacado = destacado;
    }

    public int getDestacado() {
        return destacado;
    }

    @Override
    public String toString() {
        return "Vacante{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", salario=" + salario + ", destacado=" + destacado + ", imagen=" + imagen + ", estatus=" + estatus + ", detalles=" + detalles + ", categoria=" + categoria + '}';
    }

   
    

  
    
    
    
}
