package min.bs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String index() {
	
		
		return "index";
	}
	
	@GetMapping("/index.html")
	public String index2() {
		return "index";
	}
	
	@GetMapping("about.html")
	public String about() {
		return "about";
	}
	
	
	@GetMapping("blog.html")
	public String blog() {
		return "blog";
	}
	
	@GetMapping("codes.html")
	public String codes() {
		return "codes";
	}
	
	
	@GetMapping("contact.html")
	public String contact() {
		return "contact";
	}
	
	
	@GetMapping("menu.html")
	public String menu() {
		return "menu";
	}
	
	
	@GetMapping("single.html")
	public String single() {
		return "single";
	}
}
