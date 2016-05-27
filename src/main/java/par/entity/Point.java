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
	
	
	@ManyToOne
	private Game game;

	
	
	public Point(String point, String seet, Game game) {
		super();
		this.point = point;
		this.seet = seet;
		this.game = game;
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

	

	@Override
	public String toString() {
		return "Point [id=" + id + ", point=" + point + ", seet=" + seet + "]";
	}

	

	

	
	

}
