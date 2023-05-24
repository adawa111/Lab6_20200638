package com.example.lab6_sol.controller;

import com.example.lab6_sol.entity.Usuario;
import com.example.lab6_sol.repository.UsuarioRepository;
import groovy.xml.StreamingDOMBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/lista")
    public String listaUsuarios(Model model){
        List<Usuario> estudiantes = usuarioRepository.findByRolid(5);
        model.addAttribute("estudiantes", estudiantes);
        return "lista_usuarios";
    }


    @GetMapping("/edita")
    public String editarEstudiante(Model model, @RequestParam("id") Integer id, RedirectAttributes attr){
        Usuario estudiante;
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            estudiante = optionalUsuario.get();
            model.addAttribute("estudiante", estudiante);
            return "formsEditCreate";
        } else {
            estudiante = null;
            model.addAttribute("estudiante",estudiante);
            return "formsEditCreate";
        }
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("estudiante") @Valid Usuario estudiante, BindingResult bindingResult,
                              Model model, RedirectAttributes attr){
        if(bindingResult.hasErrors()){
            return "formsEditCreate";
        }
        else {
            attr.addFlashAttribute("msg", "Estudiante editado exitosamente");
            usuarioRepository.save(estudiante);
            return "redirect:/estudiante/lista";
        }
    }
}
