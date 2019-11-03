package com.wendel.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wendel.brewer.model.Cerveja;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CervejasController {
	
	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			System.out.println("TEM ERRO SIM");
			System.out.println(result.getAllErrors());
			model.addAttribute("mensagem", "Erro no fomulário.");
			return "cerveja/CadastroCerveja";
		}
		
		System.out.println("sku >> " + cerveja.getSku());
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
		return "redirect:/cervejas/novo";
	}

}