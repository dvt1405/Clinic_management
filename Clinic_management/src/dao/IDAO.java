package dao;

import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface IDAO {
    public boolean add(iEntity entity);
    public boolean add(List<iEntity> entities);
    public boolean modify(iEntity entity);
    public boolean modify(List<iEntity> entities);
    public boolean delete(iEntity entity);
    public boolean delete(List<iEntity> entities);
    public iEntity findById(int id);
    public List<iEntity> fetch(String condt);
    public List<iEntity> fetchAll();
    public ResultSet queryDB(String sql);
    
    default public List<Object[]> toTableData(List<iEntity> entities){
        List<Object[]> res = null;
        if(!(entities == null) & !(entities.isEmpty())){
            res = new ArrayList<>();
            for(int i=0; i<entities.size(); i++)
                res.add(entities.get(i).toRowDataTable());
        }
        return res;
    }
}
