package dao;

import entity.iEntity;
import java.sql.ResultSet;
import java.util.List;
import repository.BillRepoMysql;
import repository.IRepo;

/**
 *
 * @author MrLELOI
 */
public class BillDAO implements IDAO {
    
    private IRepo repo;

    public BillDAO() {
        this.repo = new BillRepoMysql();
    }

    public BillDAO(IRepo _repo) {
        this.repo = _repo;
    }

    @Override
    public boolean add(iEntity entity) {
        return this.repo.insert(entity);
    }

    @Override
    public boolean add(List<iEntity> entities) {
        return this.repo.insert(entities);
    }

    @Override
    public boolean modify(iEntity entity) {
        return this.repo.update(entity);
    }

    @Override
    public boolean modify(List<iEntity> entities) {
        return this.repo.update(entities);
    }

    @Override
    public boolean delete(iEntity entity) {
        return this.repo.delete(entity);
    }

    @Override
    public boolean delete(List<iEntity> entities) {
        return this.repo.delete(entities);
    }

    @Override
    public iEntity findById(int gid) {
        try {
            List<iEntity> result = this.repo.select("id = " + Integer.valueOf(gid) + ";");
            if (!result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<iEntity> fetch(String condt) {
        return this.repo.select(condt);
    }

    @Override
    public List<iEntity> fetchAll() {
        return this.repo.select("id IS NOT NULL;");
    }

    @Override
    public ResultSet queryDB(String sql) {
        return this.repo.getDB().execQuery(sql);
    }
}
