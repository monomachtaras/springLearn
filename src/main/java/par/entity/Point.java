package par.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Point {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	private String point;
	private String seet;
	private String p1;
	private String p2;
	private String g1;
	private String g2;
	
	
	@ManyToOne()
	private Game game;

		

	public Point(String point, String seet) {
		super();
		this.point = point;
		this.seet = seet;
	}

	
	public Point(String point, String seet, String p1, String p2) {
		super();
		this.point = point;
		this.seet = seet;
		this.p1 = p1;
		this.p2 = p2;
	}


	public Point() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getSeet() {
		return seet;
	}

	public void setSeet(String seet) {
		this.seet = seet;
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

	public String getG1() {
		return g1;
	}


	public void setG1(String g1) {
		this.g1 = g1;
	}


	public String getG2() {
		return g2;
	}


	public void setG2(String g2) {
		this.g2 = g2;
	}


	@Override
	public String toString() {
		return "id=" + id + " " + seet + "(" + g1 + ":" + g2 +")"+ "(" + p1 + ":" + p2+")" ;
	}


	

	
	

	

	

	
	

}
