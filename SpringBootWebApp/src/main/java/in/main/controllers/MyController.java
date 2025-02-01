// In spring boot, a controller class is a class which manage web requests and responses. It handles user inputs
// processes data and returns views or other response
//@Controller annotation marks a class as a Spring MVC Controller allowing it to handle HTTP request and return 
//views or data.

package in.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.main.entities.User;
import in.main.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	private UserService userService;

	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/regForm")
	public String SubmitRegForm(@ModelAttribute("user") User user, Model model) {
		boolean status= userService.registerUser(user);
		if(status) {
			model.addAttribute("SuccessMasg","User registered Successfully");
		}
		else {
			model.addAttribute("ErrorMasg","User not registered Successfully");
		}
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user", new User());
		
		
		return "login";
	}
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model) {
		User validUser = userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser != null) {
			model.addAttribute("modelName", validUser.getName());
			return "profile";
		}
		else {
			model.addAttribute("errorMsg","Email id and password didn't matched");
			return "login";
		}
	
		
	}
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate(); // this will delete the session
		}
		return "login";
	}

}
