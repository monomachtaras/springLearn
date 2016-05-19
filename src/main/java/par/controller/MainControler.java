package par.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import par.service.PlayerService;


@Controller
public class MainControler {
	
	@Autowired
	private PlayerService playerService;
	
	
	@RequestMapping("/")
	public String welcome(Model model){ 		
		model.addAttribute("modAtr", "hello");		
		return "base";}
	
	
	@RequestMapping(value="addPlayer", method=RequestMethod.POST)
	public String add(
			@RequestParam String name, @RequestParam String surname, @RequestParam int yearOfBirth
			){		
		playerService.addPlayer(name, surname, yearOfBirth);	
		return "redirect:/";
	}
	

}
