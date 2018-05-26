package offtocol.app.info;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("userInfo")
public class UserInfoController {

	@GetMapping
	String userinfo()	{
		return "users/userInfo";
	}

}
