package com.riwi.primeraweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.services.CoderService;

@Controller
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    /**
     * Metodo para motrar la vista y enviarle la lista coders
     */
    @GetMapping
    public String showViewGetAll(Model objModel) {
        // LLamo el servicio y guardo la lista de coders
        List<Coder> list = this.objCoderService.findAll();
        objModel.addAttribute("coderList", list); // Llave- valor

        // Se debe retornar el nombre exacto de la vista html
        return "viewCoder";
    }

}
