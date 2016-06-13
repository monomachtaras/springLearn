package par.service.imp;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import par.Dao.PointDao;
import par.entity.Game;
import par.entity.Point;
import par.service.PointService;

@Service
public class PointServiceImp implements PointService {
	
	@Autowired
	PointDao pointDao;

	@Transactional
	public void addPoint(Point point) {
		pointDao.save(point);		
	}

	@Transactional
	public void update(Point point) {
		pointDao.save(point);
	}
	
	public Point getPointById(int id) {
		return pointDao.findOne(id);
	}

	public List<Point> getAllPoints() {
		return pointDao.findAll();
	}

}
