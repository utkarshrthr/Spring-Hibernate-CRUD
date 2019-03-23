package app.utk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {


	@RequestMapping(path="/")
	public String app() {
		return "Let's get started";
	}
	
}
