package offtocol.app.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("loginForm")
public class LoginController {

	@GetMapping
	String loginForm()	{
		return "login/loginForm";
	}

}
