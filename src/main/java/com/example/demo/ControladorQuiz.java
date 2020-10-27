package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorQuiz {
	
	@GetMapping("/quiz")
	public String process(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("USUARIOS");
		if(messages == null) {
			messages = new ArrayList<>();
		}
		model.addAttribute("sessionMessages", messages);
		return "quiz";
	}
	
	@PostMapping("/nombreUsuarios")
	public String nombreUsuarios(@RequestParam("nombre") String nombre, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("USUARIOS");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("USUARIOS", messages);
		}
		messages.add(nombre);
		request.getSession().setAttribute("USUARIOS",messages);
		return "Pagina2";
	}
	
	@PostMapping("/Pagina2")
	public String pagina2(@RequestParam("nombre") String nombre, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("USUARIOS");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("USUARIOS", messages);
		}
		messages.add(nombre);
		request.getSession().setAttribute("USUARIOS",messages);
		return "Pagina2";
	}
	
	@PostMapping("/volverInicio")
	public String volverInicio() {
		return "quiz";
	}
	
}
