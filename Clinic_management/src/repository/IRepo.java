package repository;

import entity.iEntity;
import java.util.List;

public interface IRepo {
    public boolean insert(iEntity entity);
    public boolean insert(List listEntities);
    public boolean update(iEntity entity);
    public boolean update(List listEntities);
    public boolean delete(iEntity entity);
    public boolean delete(List listEntities);
    public List<iEntity> select(String condt);
    public void resetAutoIncrement();
    public IDB getDB();
}
