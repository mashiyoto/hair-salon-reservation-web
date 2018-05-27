package offtocol.app.user;


import offtocol.domain.model.User;
import offtocol.domain.service.user.UserService;
import offtocol.domain.service.user.UserValidator;
import offtocol.domain.service.user.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;



@Controller
@RequestMapping("registerForm")
public class UserController {



	@Autowired
	UserService userService;


	@Autowired
	private SecurityService securityService;


	@Autowired
	private UserValidator userValidator;



	@GetMapping
	String register(Model model) {
		model.addAttribute("userForm", new User());
		return "users/registerForm";
	}



	@PostMapping
	String register(
		@ModelAttribute("userForm") User userForm,
		BindingResult result,
		Model model
	) {


		userValidator.validate(userForm, result);

		if(result.hasErrors()) {
			return "users/registerForm";
		}


		userForm.setRoleName("USER");

		userService.save(userForm);


		securityService.autologin(
			userForm.getUsername(),
			userForm.getPasswordConfirm()
		);


		return "redirect:/houses";


	}



}
