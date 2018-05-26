package offtocol.app.finish;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("finish")
public class FinishController {

	@GetMapping
	String finish()	{
		return "order/finish";
	}

}
