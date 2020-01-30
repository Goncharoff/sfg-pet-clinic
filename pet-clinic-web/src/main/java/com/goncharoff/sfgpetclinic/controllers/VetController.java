package com.goncharoff.sfgpetclinic.controllers;

import com.goncharoff.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/vets", "vets.htmlgi"})
@Controller
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listController(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
