package par.service.imp;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import par.Dao.PointDao;
import par.entity.Point;
import par.service.PointService;

@Service
public class PointServiceImp implements PointService {
	
	@Autowired
	PointDao pointDao;

	@Transactional
	public void addPoint(double p1, double p2) {
		pointDao.addPoint(new Point(p1, p2));		
	}

	public Point getPointById(int id) {
		return pointDao.getPointById(id);
	}

	public List<Point> getAllPoints() {
		return pointDao.getAllPoints();
	}

}
