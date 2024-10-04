package com.example.lab6.controller;

import com.example.lab6.entity.Pelicula;
import com.example.lab6.repository.DirectorRepository;
import com.example.lab6.repository.PeliculaRepository;
import com.example.lab6.repository.PeliculasDirectorRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final DirectorRepository directorRepository;
    private final PeliculaRepository peliculaRepository;
    private final PeliculasDirectorRepository peliculasDirectorRepository;


    public HomeController(DirectorRepository directorRepository,
                          PeliculaRepository peliculaRepository,
                          PeliculasDirectorRepository peliculasDirectorRepository) {
        this.directorRepository = directorRepository;
        this.peliculaRepository = peliculaRepository;
        this.peliculasDirectorRepository = peliculasDirectorRepository;
    }


    @GetMapping("gestion/pagPrincipal")
    public String paginaPrincipal(Model model ){


        return "vistas/pagPrincipal";
    }

    @GetMapping("gestion/peliculas")
    public String listaPeliculas(Model model ){

        List<Pelicula> listaPeliculas = peliculaRepository.findAll();
        model.addAttribute("listaPeliculas", listaPeliculas);

        return "vistas/listaPeliculas";
    }

    @GetMapping("gestion/nuevaPelicula")
    public String nuevoPeliculaFrm(Model model, @ModelAttribute("pelicula") Pelicula pelicula) {

        return "vistas/editFrmPelicula";
    }



    @PostMapping("/pelicula/save")
    public String guardarPelicula(RedirectAttributes attr, Model model,
                                  @ModelAttribute("pelicula") @Valid Pelicula pelicula, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "vistas/editFrmPelicula";

        } else {
            if (pelicula.getId() == 0) {
                attr.addFlashAttribute("msg", "Producto creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
            }
            peliculaRepository.save(pelicula);
            return "redirect:/gestion/peliculas";
        }


    }


    @GetMapping("/pelicula/edit")
    public String editarTransportista(@ModelAttribute("product") Pelicula pelicula,
                                      Model model, @RequestParam("id") int id) {

        Optional<Pelicula> optProduct = peliculaRepository.findById(id);

        if (optProduct.isPresent()) {
            pelicula = optProduct.get();
            model.addAttribute("pelicula", pelicula);
            return "vistas/editFrmPelicula";
        } else {
            return "redirect:/gestion/peliculas";
        }
    }


}
