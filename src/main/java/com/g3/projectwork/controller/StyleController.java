package com.g3.projectwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StyleController {

	@RequestMapping(value = { "/style.css"}, method = RequestMethod.GET)
    public String foglioDiStile() {
        return "css/style.css";
    }
	@RequestMapping(value = { "/NERD.png"}, method = RequestMethod.GET)
	public String logo() {
		return "images/NERD.png";
	}
}
