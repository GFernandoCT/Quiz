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
	
	
	@GetMapping("/Pagina3")
	public String pagina3(Model model, HttpSession session) {
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
		return "Pagina3";
	}
	
	@GetMapping("/Pagina4")
	public String pagina4(Model model, HttpSession session) {
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
		return "Pagina4";
	}
	
	@GetMapping("/Pagina5")
	public String pagina5(Model model, HttpSession session) {
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
		return "Pagina5";
	}
	
	@GetMapping("/Pagina6")
	public String pagina6(Model model, HttpSession session) {
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
		return "Pagina6";
	}
	
	@GetMapping("/Pagina7")
	public String pagina7(Model model, HttpSession session) {
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
		
		int resultado = 0;
		if(session.getAttribute("RESULTADO") != null) {
			resultado = (int) session.getAttribute("RESULTADO");
		} 
		
		model.addAttribute("sessionMessages", messages);
		model.addAttribute("sessionPuntuacion",puntuaciones);
		model.addAttribute("sessionResultado",resultado);
		return "Pagina7";
	}
	
	@GetMapping("/paginaResultado")
	public String paginaResultado(Model model, HttpSession session) {
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
		@SuppressWarnings("unchecked")
		int puntos = 0;
		for (Integer suma : puntuaciones) {
			puntos += suma; 
		}
		model.addAttribute("sessionMessages", messages);
		model.addAttribute("sessionPuntuacion",puntuaciones);
		model.addAttribute("sessionResultado",puntos);
		return "paginaResultado";
	}
	
	@PostMapping("/paginaPregunta1")
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
	
	@PostMapping("/paginaPregunta2")
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
		return "redirect:/Pagina3";
	}
	
	@PostMapping("/paginaPregunta3")
	public String pagina3(@RequestParam("radio") String puntuacion, HttpServletRequest request) {
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
		return "redirect:/Pagina4";
	}
	
	@PostMapping("/paginaPregunta4")
	public String pagina4(@RequestParam("puntuacion") String puntuacion, HttpServletRequest request) {
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
		return "redirect:/Pagina5";
	}
	
	@PostMapping("/paginaPregunta5")
	public String pagina5(@RequestParam("puntuacion") String puntuacion, HttpServletRequest request) {
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
		return "redirect:/Pagina6";
	}
	
	@PostMapping("/paginaPregunta6")
	public String pagina6(@RequestParam("puntuacion") String puntuacion, HttpServletRequest request) {
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
		return "redirect:/Pagina7";
	}
	
	@PostMapping("/paginaFinal")
	public String pagina7(@RequestParam("puntuacion") String puntuacion, HttpServletRequest request) {
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
		
		@SuppressWarnings("unchecked")
		int puntos = 0;
		for (Integer suma : puntuaciones) {
			puntos += suma; 
		}
		
		request.getSession().setAttribute("USUARIOS",messages);
		request.getSession().setAttribute("PUNTUACION",puntuaciones);
		request.getSession().setAttribute("RESULTADO", puntos);
		return "redirect:/paginaResultado";
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
	
	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
	request.getSession().invalidate();
	return "redirect:/quiz";
	}
}
