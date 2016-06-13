package par.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import par.entity.Game;
import par.entity.Player;
import par.entity.Point;
import par.service.GameService;
import par.service.PlayerService;
import par.service.PointService;
import par.statistic.SortByStatistic;
import par.statistic.SortBySurname;
import par.statistic.SortByYear;
import par.statistic.Tenis;


@Controller
public class MainControler {
	
	@Autowired
	private PlayerService playerService;
	@Autowired
	private GameService gameService;
	@Autowired
	private PointService pointService;
	
	

	@RequestMapping(value="/chooseMatch", method=RequestMethod.POST)
	public String chooseGame(
			@RequestParam String selGame, Model model
			){
		Game game = gameService.getGameByID(Integer.valueOf(selGame));
		String p1 = game.getP1();
		String p2 = game.getP2();
		System.out.println(p1);
		System.out.println(p1);
		model.addAttribute("game1",game);
		model.addAttribute("p1",p1);
		model.addAttribute("p2",p2);
		return "addPoints";
	}
	
	
	@RequestMapping("/mathStat")
	public String showStat(
			@RequestParam String total1, @RequestParam String ou1, @RequestParam String total2, @RequestParam String ou2,
			@RequestParam String total3, @RequestParam String ou3, @RequestParam String str, Model model
			){ 
		List<Game> list = gameService.getAllGames();		
		String y[] = Tenis.statistic(list, total1, ou1, total2, ou2, total3, ou3);
		model.addAttribute("totalGames", gameService.getQuantity());
		
		double d1 = Double.valueOf(y[0]); double d2 = Double.valueOf(y[1]);	double d3 = Double.valueOf(y[2]);
		
		double d4 = (d1/gameService.getQuantity())*100;	double d5 = (d2/d1)*100;double d6 = (d3/d2)*100;
		str="Condition: (1 set "+total1+" "+ou1+")   (2 set "+total2+" "+ou2+")   (3 set "+total3+" "+ou3+")";
		model.addAttribute("d1", d1);model.addAttribute("d2", d2); model.addAttribute("d3", d3);	
		model.addAttribute("d4", d4);model.addAttribute("d5", d5); model.addAttribute("d6", d6);	
		model.addAttribute("st", str);
		return "showStat";}
	
	
	
	
	
	@RequestMapping(value="addGame", method=RequestMethod.POST)
	public String addGame(
			@RequestParam String p1sets, @RequestParam String p2sets
			){		
		gameService.addGame(p1sets, p2sets);	
		return "redirect:/";
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
	
	@RequestMapping(value="/addPointsToMatch" , method=RequestMethod.POST)
	public String addPointsToMatch(
			@RequestParam String selGame, @RequestParam String point, @RequestParam String seet, Model model){
		Game game = gameService.getGameByID(Integer.valueOf(selGame));	
		Point point2 = new Point(point, seet);
		point2.setGame(game);
		pointService.addPoint(point2);
		
		String[] ab = new String[2];
		int a = Integer.valueOf(game.getP1());
		int b = Integer.valueOf(game.getP2());
		if(Integer.valueOf(point)==0){ ++a;} else{ ++b;}
		
				
		// dliya 1 seta
		if(Integer.valueOf(game.getP1sets())==0 && Integer.valueOf(game.getP2sets())==0 ){	
			//perevirka tay breiky
			if(!(Integer.valueOf(game.getP1s1g())==6 && Integer.valueOf(game.getP2s1g())==6)){
		if(a<=3 && b<=3) { game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
		                 ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if(a==4 && b<3) { game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP1s1g()); ++k; game.setP1s1g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if(a<3 && b==4) { game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP2s1g()); ++k; game.setP2s1g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if((a-b)==0){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
                         ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==1){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
		                 ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==-1){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
                         ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==2){ game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP1s1g()); ++k; game.setP1s1g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if((a-b)==-2){ game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP2s1g()); ++k; game.setP2s1g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
			
		// perevirka kinec seta	
		if(Integer.valueOf(game.getP1s1g())>5 || Integer.valueOf(game.getP2s1g())>5 ){
			if(Integer.valueOf(game.getP1s1g())- Integer.valueOf(game.getP2s1g())>=2){ game.setP1sets("1"); statisticOfPlayer(game,(Integer.valueOf(game.getP1s1g())+ Integer.valueOf(game.getP2s1g()))); }
			if(Integer.valueOf(game.getP1s1g())- Integer.valueOf(game.getP2s1g())<=-2){ game.setP2sets("1"); statisticOfPlayer(game,(Integer.valueOf(game.getP1s1g())+ Integer.valueOf(game.getP2s1g())));}
		}
		}
					
			else {//taybreik
				if(a<7 && b<7){game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b)); ab[0]=String.valueOf(a); ab[1]=String.valueOf(b); }
				else if(a-b>=2){game.setP1("0");int k = Integer.valueOf(game.getP1s1g()); ++k; game.setP1s1g(String.valueOf(k)); game.setP2("0"); ab[0]="0"; ab[1]="0"; game.setP1sets("1"); statisticOfPlayer(game,(Integer.valueOf(game.getP1s1g())+ Integer.valueOf(game.getP2s1g())));}
				else if(a-b<=-2){game.setP1("0"); int k = Integer.valueOf(game.getP2s1g()); ++k; game.setP2s1g(String.valueOf(k)); game.setP2("0"); ab[0]="0"; ab[1]="0"; game.setP2sets("1"); statisticOfPlayer(game,(Integer.valueOf(game.getP1s1g())+ Integer.valueOf(game.getP2s1g())));}
				else {game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b)); ab[0]=String.valueOf(a); ab[1]=String.valueOf(b);}
			}
		
				
		point2.setG1(game.getP1s1g());// zapus geymiv dliya class point
		point2.setG2(game.getP2s1g());
		
		} 
		
		
		//dliya 2 seta
		else if(Integer.valueOf(game.getP1sets())+Integer.valueOf(game.getP2sets())==1 ){
			//perevirka tay breiky
			if(!(Integer.valueOf(game.getP1s2g())==6 && Integer.valueOf(game.getP2s2g())==6)){
		if(a<=3 && b<=3) { game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
		                 ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if(a==4 && b<3) { game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP1s2g()); ++k; game.setP1s2g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if(a<3 && b==4) { game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP2s2g()); ++k; game.setP2s2g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if((a-b)==0){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
                         ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==1){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
		                 ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==-1){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
                         ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==2){ game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP1s2g()); ++k; game.setP1s2g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if((a-b)==-2){ game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP2s2g()); ++k; game.setP2s2g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		// chu kinec seta
		if(Integer.valueOf(game.getP1s2g())>5 || Integer.valueOf(game.getP2s2g())>5 ){
			if(Integer.valueOf(game.getP1s2g())- Integer.valueOf(game.getP2s2g())>=2){  int m= Integer.valueOf(game.getP1sets()); ++m; game.setP1sets(String.valueOf(m)); statisticOfPlayer(game,(Integer.valueOf(game.getP1s2g())+ Integer.valueOf(game.getP2s2g()))); }
			if(Integer.valueOf(game.getP1s2g())- Integer.valueOf(game.getP2s2g())<=-2){ int m= Integer.valueOf(game.getP2sets()); ++m; game.setP2sets(String.valueOf(m)); statisticOfPlayer(game,(Integer.valueOf(game.getP1s2g())+ Integer.valueOf(game.getP2s2g()))); }
		}
			}
			//taybreik
			else {
				if(a<7 && b<7){game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b)); ab[0]=String.valueOf(a); ab[1]=String.valueOf(b); }
				else if(a-b>=2){game.setP1("0"); game.setP2("0"); ab[0]="0"; ab[1]="0"; int k = Integer.valueOf(game.getP1s2g()); ++k; game.setP1s2g(String.valueOf(k));int m= Integer.valueOf(game.getP1sets()); ++m; game.setP1sets(String.valueOf(m));statisticOfPlayer(game,(Integer.valueOf(game.getP1s2g())+ Integer.valueOf(game.getP2s2g()))); }
				else if(a-b<=-2){game.setP1("0"); game.setP2("0"); ab[0]="0"; ab[1]="0"; int k = Integer.valueOf(game.getP2s2g()); ++k; game.setP2s2g(String.valueOf(k)); int m= Integer.valueOf(game.getP2sets()); ++m; game.setP2sets(String.valueOf(m)); statisticOfPlayer(game,(Integer.valueOf(game.getP1s2g())+ Integer.valueOf(game.getP2s2g()))); }
				else {game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b)); ab[0]=String.valueOf(a); ab[1]=String.valueOf(b);}
			}
				
		point2.setG1(game.getP1s2g());// zapus geymiv dliya class point
		point2.setG2(game.getP2s2g());
		}
		
		
		//dliya 3 seta
		else if(Integer.valueOf(game.getP1sets())==1 && Integer.valueOf(game.getP2sets())==1 ){
			//perevirka tay breiky
			if(!(Integer.valueOf(game.getP1s3g())==6 && Integer.valueOf(game.getP2s3g())==6)){
		if(a<=3 && b<=3) { game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
		                 ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if(a==4 && b<3) { game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP1s3g()); ++k; game.setP1s3g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if(a<3 && b==4) { game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP2s3g()); ++k; game.setP2s3g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if((a-b)==0){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
                         ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==1){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
		                 ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==-1){ game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b));
                         ab =par.statistic.Tenis.result(Integer.valueOf(game.getP1()),Integer.valueOf(game.getP2())); }
		else if((a-b)==2){ game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP1s3g()); ++k; game.setP1s3g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		else if((a-b)==-2){ game.setP1("0"); game.setP2("0"); int k = Integer.valueOf(game.getP2s3g()); ++k; game.setP2s3g(String.valueOf(k));
                         ab[0]="0"; ab[1]="0"; }
		if(Integer.valueOf(game.getP1s3g())>5 || Integer.valueOf(game.getP2s3g())>5 ){//chu kinec seta
			if(Integer.valueOf(game.getP1s3g())- Integer.valueOf(game.getP2s3g())>=2){  int m= Integer.valueOf(game.getP1sets()); ++m; game.setP1sets(String.valueOf(m)); statisticOfPlayer(game,(Integer.valueOf(game.getP1s3g())+ Integer.valueOf(game.getP2s3g())));}
			if(Integer.valueOf(game.getP1s3g())- Integer.valueOf(game.getP2s3g())<=-2){ int m= Integer.valueOf(game.getP2sets()); ++m; game.setP2sets(String.valueOf(m));statisticOfPlayer(game,(Integer.valueOf(game.getP1s3g())+ Integer.valueOf(game.getP2s3g())));}
		}
			}
			//taybreik 3 set
			else {
				if(a<7 && b<7){game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b)); ab[0]=String.valueOf(a); ab[1]=String.valueOf(b); }
				else if(a-b>=2){game.setP1("0"); game.setP2("0"); ab[0]="0"; ab[1]="0"; int k = Integer.valueOf(game.getP1s3g()); ++k; game.setP1s3g(String.valueOf(k));int m= Integer.valueOf(game.getP1sets()); ++m; game.setP1sets(String.valueOf(m));statisticOfPlayer(game,(Integer.valueOf(game.getP1s3g())+ Integer.valueOf(game.getP2s3g())));}
				else if(a-b<=-2){game.setP1("0"); game.setP2("0"); ab[0]="0"; ab[1]="0"; int k = Integer.valueOf(game.getP2s3g()); ++k; game.setP2s3g(String.valueOf(k)); int m= Integer.valueOf(game.getP2sets()); ++m; game.setP2sets(String.valueOf(m));statisticOfPlayer(game,(Integer.valueOf(game.getP1s3g())+ Integer.valueOf(game.getP2s3g())));}
				else {game.setP1(String.valueOf(a)); game.setP2(String.valueOf(b)); ab[0]=String.valueOf(a); ab[1]=String.valueOf(b);}
			}
		
		
		point2.setG1(game.getP1s3g());// zapus geymiv dliya class point
		point2.setG2(game.getP2s3g());
				}
		else { gameService.update(game);  return "redirect:/";}
		
		
		point2.setP1(ab[0]);
		point2.setP2(ab[1]);
		pointService.update(point2);
		gameService.update(game);						
		Game game1 = gameService.getGameByID(Integer.valueOf(selGame));	
		model.addAttribute("game1", game1);		
		model.addAttribute("p1", ab[0]);		
		model.addAttribute("p2", ab[1]);		
		return "addPoints";
		
		
	
	}
	
	
	public void statisticOfPlayer(Game game, int a){
		List<Player> list = game.getListOfPlayers();
		for (Player player : list) {
			if(a<=8){int k = Integer.valueOf(player.getStatisticOfPlayer()); k=k+4; player.setStatisticOfPlayer(String.valueOf(k));playerService.update(player);}
			else {int k = Integer.valueOf(player.getStatisticOfPlayer()); k=k-1; player.setStatisticOfPlayer(String.valueOf(k));playerService.update(player);}
		}
		
	}
	
	@RequestMapping("/toLoginPage")
	public String goToLogin(Model model){
		model = allModel(model);
		return "loginPage";
	}
	@RequestMapping("/")
	public String welcome(Model model){ 
		model = allModel(model);
		return "base";}
	@RequestMapping("/showAllGames")
	public String showAllGames(Model model){
		model=allModel(model);
		model.addAttribute("allGames", gameService.getAllGames());
		return "allgames";
	}
	@RequestMapping("/showAllPlayers")
	public String showAllPlayers(Model model){
		model=allModel(model);
		List<Player> listNotSort= playerService.getAllPlayers();
		List<Player> listSortByYear=playerService.getAllPlayers();
		List<Player> listSortBySurname=playerService.getAllPlayers();
		List<Player> listSortByStatistic=playerService.getAllPlayers();
		Collections.sort(listSortByYear, new SortByYear());
		Collections.sort(listSortBySurname, new SortBySurname());
		Collections.sort(listSortByStatistic, new SortByStatistic());
		model.addAttribute("allPlJust", listNotSort);
		model.addAttribute("allPlSortYear", listSortByYear);
		model.addAttribute("allPlSortSurname", listSortBySurname);
		model.addAttribute("allPlSortStatistic", listSortByStatistic);
		return "allPlayers";
	}
	
		
	@RequestMapping(value="addplayer", method=RequestMethod.POST)
	public String welcome2(
			Model model, @RequestParam String name, @RequestParam String surname, @RequestParam String yearOfBirth
			){ 
		if(!(name.equals("0"))){playerService.addPlayer(name, surname, yearOfBirth, "0");}
		return "addPl";}
	
	
	
	
	
	public  Model allModel(Model model){
		model.addAttribute("players", playerService.getAllPlayers());	
		model.addAttribute("games", gameService.getAllGames());
		model.addAttribute("totalGames", gameService.getQuantity());		
		return model;
	}

}
