package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@GetMapping("/hellopage")
	public ModelAndView openHelloPage() {
		System.out.println("OpenHelloPage() method executed");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		
		return mav;
	}
	
	@GetMapping("aboutUs")
	public String openAboutUs() {
		System.out.println("About us Opened");
		return "About-us";
	}
	 
 
}
