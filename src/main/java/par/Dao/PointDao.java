package par.Dao;

import java.util.List;

import par.entity.Point;

public interface PointDao {
	
	void addPoint(Point point);
	Point getPointById(int id);
	List<Point> getAllPoints();
}
