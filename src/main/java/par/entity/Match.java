package par.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MATCHH")
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int p1set;
	private int p2set;
	
	@OneToMany(mappedBy="match")
	private List <Point> points;
	
	

	public int getP1set() {
		return p1set;
	}

	public void setP1set(int p1set) {
		this.p1set = p1set;
	}

	public int getP2set() {
		return p2set;
	}

	public void setP2set(int p2set) {
		this.p2set = p2set;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + "]";
	}

	public Match(int p1set, int p2set) {
		super();
		this.p1set = p1set;
		this.p2set = p2set;
	}

	
	
	
	
	

}
