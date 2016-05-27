package par.service;

import java.util.List;
import par.entity.Game;
import par.entity.Point;

public interface PointService {
	void addPoint(String point, String seet, Game game);
	Point getPointById(int id);
	List<Point> getAllPoints();
}
