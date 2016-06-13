package par.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String p1sets;
	private String p2sets;
	
	private String p1s1g;
	private String p2s1g;
	private String p1s2g;
	private String p2s2g;
	private String p1s3g;
	private String p2s3g;
	
	private String p1;
	private String p2;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Player> listOfPlayers = new ArrayList<Player>();
	
	
	@OneToMany(mappedBy= "game", fetch= FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Point> points = new ArrayList<Point>();
	
	
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
	public String getP1s1g() {
		return p1s1g;
	}
	public void setP1s1g(String p1s1g) {
		this.p1s1g = p1s1g;
	}
	public String getP2s1g() {
		return p2s1g;
	}
	public void setP2s1g(String p2s1g) {
		this.p2s1g = p2s1g;
	}
	public String getP1s2g() {
		return p1s2g;
	}
	public void setP1s2g(String p1s2g) {
		this.p1s2g = p1s2g;
	}
	public String getP2s2g() {
		return p2s2g;
	}
	public void setP2s2g(String p2s2g) {
		this.p2s2g = p2s2g;
	}
	public String getP1s3g() {
		return p1s3g;
	}
	public void setP1s3g(String p1s3g) {
		this.p1s3g = p1s3g;
	}
	public String getP2s3g() {
		return p2s3g;
	}
	public void setP2s3g(String p2s3g) {
		this.p2s3g = p2s3g;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", p1sets=" + p1sets + ", p2sets=" + p2sets + ", listOfPlayers=" + listOfPlayers
				+ "]";
	}

	

	public Game(String p1sets, String p2sets, String p1s1g, String p2s1g, String p1s2g, String p2s2g, String p1s3g,
			String p2s3g, String p1, String p2) {
		super();
		this.p1sets = p1sets;
		this.p2sets = p2sets;
		this.p1s1g = p1s1g;
		this.p2s1g = p2s1g;
		this.p1s2g = p1s2g;
		this.p2s2g = p2s2g;
		this.p1s3g = p1s3g;
		this.p2s3g = p2s3g;
		this.p1=p1;
		this.p2=p2;
	}

	public Game() {
		super();
	}

	
	

}
