package in.spinsoft.TaskAppWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("home")
	public String home() {
		System.out.println("Welcome to TaskApp Web Application");
		return "home.jsp";
	}
}
