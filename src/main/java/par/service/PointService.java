package par.service;

import java.util.List;
import par.entity.Game;
import par.entity.Point;

public interface PointService {
	void addPoint(Point point);
	Point getPointById(int id);
	List<Point> getAllPoints();
	void update (Point point);
}
