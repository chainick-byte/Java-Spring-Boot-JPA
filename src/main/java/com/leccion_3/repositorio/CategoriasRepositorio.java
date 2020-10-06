/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leccion_3.repositorio;

import com.leccion_3.model.Categoria;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author igorr
 */

public interface CategoriasRepositorio extends JpaRepository<Categoria, Integer>{
 //   public interface CategoriasRepositorio extends CrudRepository<Categoria, Integer>{

    
    //el repositorio crudrepository ya tiene una serie esenciales de metodos implementados , 
    //para trabajar con bbdd pero si se necesita un metodo especifico se implementa aqui mismito!!
    //para ver metodos pinchar con ctrl + click izquierdo
    
    
}
