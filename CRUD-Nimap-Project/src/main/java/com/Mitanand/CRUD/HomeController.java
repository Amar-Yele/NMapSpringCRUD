package com.Mitanand.CRUD;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		
		return "Hey this is just testing purpose";
	}

}
