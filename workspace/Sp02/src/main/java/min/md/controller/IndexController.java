package min.md.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index"; // String 형태의 view
	}
	

	@RequestMapping("index.do")
	public String m_index() {
		
		
		return "index"; 
	}
}
