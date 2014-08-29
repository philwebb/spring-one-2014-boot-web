package springone;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping("/hello/{name}")
	public ModelAndView hello(@PathVariable String name) {
		return new ModelAndView("hello").addObject("name", name).addObject("items",
				Arrays.asList("groovy", "templates", "rock"));
	}

}
