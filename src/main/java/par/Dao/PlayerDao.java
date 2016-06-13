package par.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import par.entity.Player;


public interface PlayerDao extends JpaRepository<Player, Integer> {
	
	

}
