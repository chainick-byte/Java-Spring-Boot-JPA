/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leccion_3.repositorio;

import com.leccion_3.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author igorr
 */
public interface PerfilesRepositorio extends JpaRepository<Perfil, Integer>{
    
}
