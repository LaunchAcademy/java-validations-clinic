package com.launchacademy.javaspringvalidations.controllers;

import com.launchacademy.javaspringvalidations.models.Contractor;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractors")
public class ContractorsController {

  @GetMapping("/new")
  public String getNew(Model model) {
    Contractor contractor = new Contractor();
    model.addAttribute("contractor", contractor);
    return "contractors/new";
  }
  @PostMapping
  public String addNew(@ModelAttribute @Valid Contractor contractor, BindingResult bindingResult, Model model){
    if(bindingResult.hasErrors()){
      model.addAttribute("contractor", contractor);
      return "contractors/new";
    }
    else {
      return "redirect:/contractors";
    }
  }
}
