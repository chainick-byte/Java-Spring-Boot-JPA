package com.leccion_3;

import com.leccion_3.model.Categoria;
import com.leccion_3.model.Perfil;
import com.leccion_3.model.Usuario;
import com.leccion_3.model.Vacante;
import com.leccion_3.repositorio.CategoriasRepositorio;
import com.leccion_3.repositorio.PerfilesRepositorio;
import com.leccion_3.repositorio.UsuariosRepositorio;
import com.leccion_3.repositorio.VacantesRepositorio;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    private PerfilesRepositorio repositorioPerfil;
    @Autowired
    private UsuariosRepositorio repositorioUsuario;
    @Autowired
    private CategoriasRepositorio repositorioCategoria;
    @Autowired
    private VacantesRepositorio repositorioVacantes;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        buscarVacantesVariosEstatus();
        System.out.println(repositorioCategoria);
    }

    private void buscarVacantesVariosEstatus() {
        String[] estatus = new String[]{"Eliminada", "Creada"};
        List<Vacante> lista = repositorioVacantes.findByEstatusIn(estatus);
        System.out.println("numero de vacantes aprobado y destacado total es: " + lista.size());
        for (Vacante v : lista) {
            System.out.println(v.getId() + "||" + v.getNombre() + "||" + v.getEstatus());

        }
    }

    private void buscarPorSalario() {
        List<Vacante> lista = repositorioVacantes.findBySalarioBetweenOrderBySalarioDesc(7000.0, 14000.0);
        System.out.println("numero de vacantes aprobado y destacado total es: " + lista.size());
        for (Vacante v : lista) {
            System.out.println(v.getId() + "||" + v.getNombre() + "||" + v.getSalario() + "$");

        }

    }

    private void buscarPorDestacadoEstatusOrdenado() {
        List<Vacante> lista = repositorioVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
        System.out.println("numero de vacantes aprobado y destacado total es: " + lista.size());
        for (Vacante v : lista) {
            System.out.println(v.getId() + "||" + v.getNombre() + "||" + v.getEstatus() + "||" + v.getDestacado());

        }
    }

    private void buscarVacantesPorstatus() {
        List<Vacante> lista = repositorioVacantes.findByEstatus("Aprobada");
        System.out.println("numero de vacantes aprobado total es: " + lista.size());
        for (Vacante v : lista) {
            System.out.println(v.getId() + "||" + v.getNombre() + "||");
        }
    }

    private void buscarUsuarios() {
        Optional<Usuario> encontrado = repositorioUsuario.findById(2);
        if (encontrado.isPresent()) {
            Usuario usuario = encontrado.get();
            System.out.println("Usuario:" + usuario.getNombre());
            System.out.println("Perfiles asignados:");
            for (Perfil p : usuario.getPerfiles()) {
                System.out.println("    " + p.getPerfil());
            }

        } else {
            System.out.println("No existe el usuario");
        }

    }

    private void crearUsuarioConPerfil() {
        Usuario user = new Usuario();
        user.setNombre("Igor");
        user.setEmail("igorrepyakh@gmail.com");
        user.setFechaRegistro(new Date());
        user.setUsername("Chiainick");
        user.setPassword("1234");
        user.setEstatus(1);

        Perfil perfilMio = new Perfil();
        perfilMio.setId(2);

        Perfil perfilMio_1 = new Perfil();
        perfilMio_1.setId(3);
        System.out.println(perfilMio + "||" + perfilMio_1 + "||");
        user.agregar(perfilMio);
        user.agregar(perfilMio_1);

        repositorioUsuario.save(user);
    }

    //creo un metodo para empezar llenar la tabla de perfiles donde perfiles es el rol de ususario
    private void crearPerfilesAplicacion() {
        repositorioPerfil.saveAll(getPerfilAplicacion());
    }

    private List<Perfil> getPerfilAplicacion() {
        List<Perfil> listaPerfiles = new LinkedList<Perfil>();
        Perfil perfil_1 = new Perfil();
        Perfil perfil_2 = new Perfil();
        Perfil perfil_3 = new Perfil();

        perfil_1.setPerfil("SUPERVISOR");
        perfil_2.setPerfil("AMINISTARTOR");
        perfil_3.setPerfil("USUARIO");

        listaPerfiles.add(perfil_1);
        listaPerfiles.add(perfil_2);
        listaPerfiles.add(perfil_3);

        return listaPerfiles;
    }

    private void guardarVacante() {
        //creamos objeto de tipo vacante
        Vacante miVacante = new Vacante();
        miVacante.setNombre("Profesor de matematica");
        miVacante.setDescripcion("Hago pensar a la gente y les hago ver operaciones logicas ancestrles");
        miVacante.setFecha(new Date());
        miVacante.setSalario(15000.0);
        miVacante.setEstatus("Aprobada");
        miVacante.setDestacado(0);
        miVacante.setImagen("escuela.png");
        miVacante.setDetalles("<h1> Los requisitos para profesor de matemaitcas</h1>");
        Categoria miCategoria = new Categoria();
        miCategoria.setId(15);
        miVacante.setCategoria(miCategoria);

        //guardamos este objeto 
        repositorioVacantes.save(miVacante);
    }

    private void buscarVacantes() {
        List<Vacante> listaVacantes = repositorioVacantes.findAll();
        for (Vacante v : listaVacantes) {
            System.out.println(v.getId() + "||" + v.getNombre() + "||" + v.getCategoria().getNombre());
        }

    }
//    private void guardarTodo(){
//        
//        repositorioCategoria.saveAll(itrbl)
//    }

    private void borrarUnBloqueDeDatos() {
        //6-10-2020 mucha precaucion
        repositorioCategoria.deleteAllInBatch();
    }

    private void buscarTodoConPaginacionOrdenado() {
        Page<Categoria> paginaDeDatos = repositorioCategoria.findAll(PageRequest.of(1, 5, Sort.by("nombre")));
        for (Categoria c : paginaDeDatos.getContent()) {
            System.out.println(c.getId() + "|| " + c.getNombre() + "||");

        }
    }

    private void buscarTodoConPaginacion() {
        Page<Categoria> paginaDeDatos = repositorioCategoria.findAll(PageRequest.of(1, 5));
        System.out.println("Total registros: " + paginaDeDatos.getTotalElements() + ". Total de paginas "
                + +paginaDeDatos.getTotalPages());
        for (Categoria c : paginaDeDatos.getContent()) {
            System.out.println(c.getId() + "|| " + c.getNombre() + "||");
        }
    }

    private void buscarOrdenado() {
        Iterable<Categoria> categorias = repositorioCategoria.findAll(Sort.by("nombre"));
        for (Categoria c : categorias) {
            System.out.println(c.getId() + "|| " + c.getNombre());

        }
    }

    private void existePorId() {
        boolean existe = repositorioCategoria.existsById(10);
        System.out.println("La categoria " + existe);
    }

    private void encuentraTodo() {
        List<Categoria> categorias = repositorioCategoria.findAll();
        for (Categoria c : categorias) {
            System.out.println(c.getId() + "|| " + c.getNombre() + "||");
        }
    }

    private void encontrarPorId() {
        List<Integer> ids = new LinkedList<Integer>();
        ids.add(2);
        ids.add(11);
        ids.add(7);
        Iterable<Categoria> categorias = repositorioCategoria.findAllById(ids);
        for (Categoria cat : categorias) {
            System.out.println(cat);
        }
    }

    private void eliminarTodo() {
        repositorioCategoria.deleteAll();
    }

    private void conteo() {
        long count = repositorioCategoria.count();
        System.out.println("Total categorias: " + count);
    }

    private void buscarId() {
        Optional<Categoria> optional = repositorioCategoria.findById(1);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("El objeto no ha encotrador");
        }
    }

    private void eliminar() {
        int idCategoria = 1;
        repositorioCategoria.deleteById(idCategoria);
    }

    private void modificar() {
        Optional<Categoria> optional = repositorioCategoria.findById(1);
        if (optional.isPresent()) {
            Categoria categoriaAuxiliar = optional.get();
            categoriaAuxiliar.setNombre("Ingeniero de software");
            categoriaAuxiliar.setDescripcion("diseño arquitectura de programas, desarrollo de sistemas");
            repositorioCategoria.save(categoriaAuxiliar);
            System.out.println(optional.get());
        } else {
            System.out.println("El objeto no ha encotrador");
        }
    }

    private void guardar() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Finanzas");
        categoria.setDescripcion("Es un hecho establecido hace demasiado tiempo que un lector"
                + " se distraerá con el contenido del texto de un sitio mientras que mira su"
                + " diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o"
                + " menos normal de las letras, al contrario de usar textos como por ejemplo "
                + "\"Contenido aquí, contenido aquí\". Estos textos hacen parecerlo un "
                + "español que se puede leer. Muchos paquetes de autoedición y editores de "
                + "páginas web usan el Lorem Ipsum como su texto por defecto, y al hacer una "
                + "búsqueda de \"Lorem Ipsum\" va a dar por resultado muchos sitios web que "
                + "usan este texto si se encuentran en estado de desarrollo. Muchas versiones"
                + " han evolucionado a través de los años, algunas veces por "
                + "accidente, otras veces a propósito (por ejemplo insertándole humor y cosas "
                + "por el estilo).");

        //con esta linia de codigo se produce el insert a la tabla de categoria
        repositorioCategoria.save(categoria);
        System.out.println(categoria);

    }

}
