package com.leccion_3;

import com.leccion_3.repositorio.CategoriasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
    
    @Autowired
    private CategoriasRepositorio repositorioCategoria;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(repositorioCategoria);
    }

    private void guardar() {
        System.out.println("insertando el registro");
    }

    private void eliminar() {
        System.out.println("eliminando el registro");
    }

}
