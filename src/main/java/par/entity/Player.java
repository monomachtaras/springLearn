package par.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Player {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String yearOfBirth;
	private String statisticOfPlayer;
	
	

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
	public String getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
    public String getStatisticOfPlayer() {
		return statisticOfPlayer;
	}
	public void setStatisticOfPlayer(String statisticOfPlayer) {
		this.statisticOfPlayer = statisticOfPlayer;
	}
	@Override
	public String toString() {
		return surname+" "+name+" "+yearOfBirth+" "+statisticOfPlayer;
	}

	

	public Player(String name, String surname, String yearOfBirth, String statisticOfPlayer) {
		super();
		this.name = name;
		this.surname = surname;
		this.yearOfBirth = yearOfBirth;
		this.statisticOfPlayer = statisticOfPlayer;
	}
	public Player() {
		super();
	}
	
	
	

}
