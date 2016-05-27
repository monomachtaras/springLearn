package par.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String p1sets;
	private String p2sets;
	
	@ManyToMany()
	private List<Player> listOfPlayers = new ArrayList<Player>();
	
	
	@OneToMany()
	private List<Point> points;
	
	
	public String getP1sets() {
		return p1sets;
	}

	public void setP1sets(String p1sets) {
		this.p1sets = p1sets;
	}

	public String getP2sets() {
		return p2sets;
	}

	public void setP2sets(String p2sets) {
		this.p2sets = p2sets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public List<Player> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(List<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	

	@Override
	public String toString() {
		return "Game [id=" + id + ", p1sets=" + p1sets + ", p2sets=" + p2sets + ", listOfPlayers=" + listOfPlayers
				+ "]";
	}

	public Game(String p1sets, String p2sets) {
		this.p1sets = p1sets;
		this.p2sets = p2sets;
	}

	
	

	public Game() {
		super();
	}

	
	

}
