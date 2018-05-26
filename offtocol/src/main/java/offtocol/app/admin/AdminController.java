package offtocol.app.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("admin")
public class AdminController {

	@GetMapping
	String admin()	{
		return "admin/admin";
	}

}
