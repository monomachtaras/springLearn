package par.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="POINT")
public class Point {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private double p1;
	private double p2;
	
	@ManyToOne
	private Match match;

	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getP1() {
		return p1;
	}

	public void setP1(double p1) {
		this.p1 = p1;
	}

	public double getP2() {
		return p2;
	}

	public void setP2(double p2) {
		this.p2 = p2;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Point(double p1, double p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public String toString() {
		return "Point [id=" + id + ", p1=" + p1 + ", p2=" + p2 + "]";
	}
	
	

}
