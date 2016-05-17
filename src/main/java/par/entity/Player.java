package par.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER")
public class Player {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private int yearOfBirth;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Match> match;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public List<Match> getMatch() {
		return match;
	}

	public void setMatch(List<Match> match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", surname=" + surname + ", yearOfBirth=" + yearOfBirth + "]";
	}

	public Player(String name, String surname, int yearOfBirth) {
		super();
		this.name = name;
		this.surname = surname;
		this.yearOfBirth = yearOfBirth;
	}
	
	
	

}
