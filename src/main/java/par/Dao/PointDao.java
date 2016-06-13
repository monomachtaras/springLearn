package par.Dao;

import org.springframework.data.jpa.repository.JpaRepository;


import par.entity.Point;

public interface PointDao   extends JpaRepository<Point, Integer>{
	
	
}
