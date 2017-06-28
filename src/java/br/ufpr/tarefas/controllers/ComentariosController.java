/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.controllers;

import br.ufpr.tarefas.model.Comentarios;
import br.ufpr.tarefas.dao.JdbcComentariosDao;
import br.ufpr.tarefas.model.Topico;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author julio
 */
@Controller
public class ComentariosController {
     @RequestMapping("/novoComentario")
    public String form(Topico topico, Model model){
        model.addAttribute("topico", topico); // passa o topico para frente 
        return "comentario/formulario";
    }

    @RequestMapping("/adicionaComentario")
    public String adicionar(Comentarios comentario, BindingResult result) {
        if (result.hasErrors()) {
            return "comentario/formulario";
        }
        JdbcComentariosDao dao = new JdbcComentariosDao();
        dao.adiciona(comentario, comentario.getId_topico());
        return "redirect:listaComentarios?id="+comentario.getId_topico();
    }  
    
    /**
     *
     * @param topico
     * @param model
     * @return
     */
    @RequestMapping("/listaComentarios")
    public String listar(Topico topico, Model model) {
        JdbcComentariosDao dao = new JdbcComentariosDao();
        List<Comentarios> comentarios = dao.getLista(topico);        
        model.addAttribute("comentarios",comentarios);
        return "comentario/lista";
    }
    
      @RequestMapping("/removeComentario")
    public String remover(Comentarios comentario) {
        JdbcComentariosDao dao = new JdbcComentariosDao();
        dao.remove(comentario);       
        return "redirect:listaComentarios?id="+comentario.getId_topico();
    }
    
       @RequestMapping("mostraComentario")
    public String mostra(Comentarios comentario, Model model){
        JdbcComentariosDao dao = new JdbcComentariosDao();
        model.addAttribute("comentario",dao.buscaPorId(comentario.getId()));
        return "comentario/mostra";
    }
    
    @RequestMapping("/alteraComentario")
    public String altera(Comentarios comentario) {
        JdbcComentariosDao dao = new JdbcComentariosDao();
        dao.altera(comentario);
        return "redirect:listaComentarios?id="+comentario.getId_topico();
    }
    
     
}
