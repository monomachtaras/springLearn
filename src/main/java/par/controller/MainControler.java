package par.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import par.entity.Game;
import par.entity.Player;
import par.service.GameService;
import par.service.PlayerService;
import par.service.PointService;


@Controller
public class MainControler {
	
	@Autowired
	private PlayerService playerService;
	@Autowired
	private GameService gameService;
	@Autowired
	private PointService pointService;
	
	
	
	@RequestMapping("/")
	public String welcome(Model model){ 
		model.addAttribute("players", playerService.getAllPlayers());	
		model.addAttribute("games", gameService.getAllGames());
		return "base";}
	
	
	@RequestMapping(value="addPlayer", method=RequestMethod.POST)
	public String addPlayer(
			@RequestParam String name, @RequestParam String surname, @RequestParam String yearOfBirth
			){		
		playerService.addPlayer(name, surname, yearOfBirth);	
		return "redirect:/";
	}
	
	@RequestMapping(value="addGame", method=RequestMethod.POST)
	public String addGame(
			@RequestParam String p1sets, @RequestParam String p2sets
			){		
		gameService.addGame(p1sets, p2sets);	
		return "redirect:/";
	}
	
	
	@RequestMapping(value="addplayer", method=RequestMethod.POST)
	public String welcome2(Model model){ 
		model.addAttribute("players", playerService.getAllPlayers());
		return "addPl";}
	
	
	
	
	
	@RequestMapping("/showAllGames")
	public String showAll(Model model){
		model.addAttribute("allGames", gameService.getAllGames());
		return "allgames";
	}
	
	@RequestMapping("/toLoginPage")
	public String goToLogin(){
		return "loginPage";
	}
	
	
	
	@RequestMapping(value="connect", method=RequestMethod.POST)
	public String connect(
			@RequestParam String bindGame,  @RequestParam String bindPlayer1,  @RequestParam String bindPlayer2
			){	
		Game game = gameService.getGameByID(Integer.valueOf(bindGame));
		Player player1 = playerService.getPlayerById(Integer.valueOf(bindPlayer1));
		Player player2 = playerService.getPlayerById(Integer.valueOf(bindPlayer2));
		List<Player> list = new ArrayList<Player>();
		list.add(player1);
		list.add(player2);
		game.setListOfPlayers(list);
		
	
		gameService.update(game);
		return "redirect:/";
	}
	
	@RequestMapping(value="/chooseMatch", method=RequestMethod.POST)
	public String chooseGame(
			@RequestParam String selGame, Model model
			){
		model.addAttribute("game",gameService.getGameByID(Integer.valueOf(selGame)));
		return "addPoints";
	}
	
	@RequestMapping(value="/addPointsToMatch" , method=RequestMethod.POST)
	public String addPointsToMatch(
			@RequestParam String selGame, @RequestParam String point, @RequestParam String seet,  Model model
			){
		Game game = gameService.getGameByID(Integer.valueOf(selGame));	
		pointService.addPoint(point, seet, game);
		model.addAttribute("game", game);		
		return "addPoints";
	}
	
	
	

}
