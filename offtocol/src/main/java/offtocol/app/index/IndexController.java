package offtocol.app.index;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("")
public class IndexController {

	@GetMapping
	String index()	{
		return "public/index";
	}

}
