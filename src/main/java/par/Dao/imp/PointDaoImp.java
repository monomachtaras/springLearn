package par.Dao.imp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import par.Dao.PointDao;
import par.entity.Point;

@Repository
public class PointDaoImp implements PointDao {

	@PersistenceContext
	EntityManager manager;

	public void addPoint(Point point) {
		manager.persist(point);
	}

	public Point getPointById(int id) {
		return manager.find(Point.class, id);
	}

	public List<Point> getAllPoints() {
		return manager.createQuery("from POINT", Point.class).getResultList();
	}


}
