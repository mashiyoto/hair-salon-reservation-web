package offtocol.app.owner;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("owner")
public class OwnerController {

	@GetMapping
	String owner()	{
		return "owner/owner";
	}

}
