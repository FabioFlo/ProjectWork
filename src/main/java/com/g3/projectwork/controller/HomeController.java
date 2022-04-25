package com.g3.projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "Benvenuto sul sito";
	}

	@GetMapping("/")
	public String home(HttpSession session) {
		//Se il mapping home viene richiesto e non ha un parametro viene rediretto
		if(session.getAttribute("login") == null) {
			return "redirect:/formlogin";
		}
		return "home.html";
	}
	
	/*
	 * SEZIONE LOGIN
	 * 
	 * 
	 */
	@GetMapping("/formlogin")
	public String formLogin() {
		return "formlogin.html";
	}
	@GetMapping("/login")
	public String login(@RequestParam("email") String email,
						@RequestParam("password") String p,	
						HttpSession session)
	{

		//TODO: CHECK WITH DATABASE IF VALID ELSE REDIRECT TO REGISTER
		if(p!=null && email!=null)
			session.setAttribute("login", "Ok");
			System.out.println(email + " " + p);
		
		return "redirect:/";
		//Altrimenti rimandi a form settando false come fattore pagina
	}
	
	/*
	 * SEZIONE LOGOUT
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("login", null);
		session.setAttribute("username", null);
		session.setAttribute("email", null);
		session.setAttribute("password", null);
		
		return "redirect:/formlogin";
	}
	
	/*
	 * SEZIONE REGISTRAZIONE
	 */
	@GetMapping("/formregistrazione")
	public String formRegistrazione() {
		return "formregistrazione.html";
	}
	//TODO: FINISH THIS
	@GetMapping("/registrazione")
	public String signUp(@RequestParam("username") String userName,
						 @RequestParam("email") String email,
						 @RequestParam("password") String password,
						 @RequestParam("checkpassword") String checkPassword,
						 @RequestParam("acceptterms") boolean acceptterms
			) {
		if(password.contentEquals(checkPassword) && !(password.isBlank() || password.isEmpty())) {
			if(acceptterms) {
				if(!(userName.isBlank() || userName.isEmpty())){
					
				}
			}
		}
		return "";
	}
}