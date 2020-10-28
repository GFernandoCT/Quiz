package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
		@SuppressWarnings("unchecked")
		List<Integer> puntuaciones = (List<Integer>) session.getAttribute("PUNTUACION");
		if(puntuaciones == null) {
			puntuaciones = new ArrayList<>();
		}
		model.addAttribute("sessionMessages", messages);
		model.addAttribute("sessionPuntuacion",puntuaciones);
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
		@SuppressWarnings("unchecked")
		List<Integer> puntuaciones = (List<Integer>) request.getSession().getAttribute("PUNTUACION");
		if (puntuaciones == null) {
			puntuaciones = new ArrayList<>();
			request.getSession().setAttribute("PUNTUACION", puntuaciones);
		}
		messages.add(nombre);
		puntuaciones.add(1);
		request.getSession().setAttribute("USUARIOS",messages);
		request.getSession().setAttribute("PUNTUACION",puntuaciones);
		return "redirect:/Pagina2";
	}
	
	@PostMapping("/paginaSiguiente")
	public String paginaSiguiente(@RequestParam("puntuacion") String puntuacion, HttpServletRequest request) {
		StringTokenizer tokenizer = new StringTokenizer(puntuacion,",");
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("USUARIOS");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("USUARIOS", messages);
		}
		@SuppressWarnings("unchecked")
		List<Integer> puntuaciones = (List<Integer>) request.getSession().getAttribute("PUNTUACION");
		if (puntuaciones == null) {
			puntuaciones = new ArrayList<>();
			request.getSession().setAttribute("PUNTUACION", puntuaciones);
		}
		while (tokenizer.hasMoreElements()) {
			puntuaciones.add(Integer.parseInt(tokenizer.nextToken()));
		}		
		request.getSession().setAttribute("USUARIOS",messages);
		request.getSession().setAttribute("PUNTUACION",puntuaciones);
		return "redirect:/Pagina2";
	}
	
	@PostMapping("/volverInicio")
	public String volverInicio(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("USUARIOS");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("USUARIOS", messages);
		}
		@SuppressWarnings("unchecked")
		List<Integer> puntuaciones = (List<Integer>) request.getSession().getAttribute("PUNTUACION");
		if (puntuaciones == null) {
			puntuaciones = new ArrayList<>();
			request.getSession().setAttribute("PUNTUACION", messages);
		} 
		request.getSession().setAttribute("USUARIOS",messages);
		request.getSession().setAttribute("PUNTUACION",puntuaciones);
		return "redirect:/quiz";
	}
	
	@GetMapping("/Pagina2")
	public String pagina2(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("USUARIOS");
		if(messages == null) {
			messages = new ArrayList<>();
		}
		@SuppressWarnings("unchecked")
		List<Integer> puntuaciones = (List<Integer>) session.getAttribute("PUNTUACION");
		if(puntuaciones == null) {
			puntuaciones = new ArrayList<>();
		}
		model.addAttribute("sessionMessages", messages);
		model.addAttribute("sessionPuntuacion",puntuaciones);
		return "Pagina2";
	}
}
