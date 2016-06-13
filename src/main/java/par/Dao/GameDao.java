package par.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import par.entity.Game;


public interface GameDao extends JpaRepository<Game, Integer>{
	
	@Query("from Game c join fetch c.points")
	List<Game> gamesWithPoints();
	
	
	

}
