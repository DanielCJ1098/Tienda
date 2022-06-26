package com.tienda.controller;
import com.tienda.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Ahora utilizamos MVC");
        var clientes=clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        /*Cliente cliente = new Cliente ("Anthony" , "Aguilera" , "anthonyag7@hotmail.com" , "85839617");
        Cliente cliente2 = new Cliente ("Pandolfo" , "Ramos" , "anthonyag7@hotmail.com" , "85839617");
        var clientes = Arrays.asList(cliente,cliente2);
        model.addAttribute("clientes",clientes);*/
        return "index";
    }
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        log.info("Ingresando nuevo cliente");
        return "modificarCliente";
    }
    @PostMapping("/guardarCliente")
    public String guardarCliente (Cliente cliente){
        log.info("Guardando informacion sobre un cliente");
        clienteService.save(cliente);
        return "redirect:/";
    }
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente, Model model){
        clienteService.delete(cliente);
        return "redirect:/";
    }
}