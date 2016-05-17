package par.service;

import java.util.List;

import par.entity.Point;

public interface PointService {
	void addPoint(double p1, double p2);
	Point getPointById(int id);
	List<Point> getAllPoints();
}
