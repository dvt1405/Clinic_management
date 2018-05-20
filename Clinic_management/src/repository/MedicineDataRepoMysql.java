package repository;

import entity.MedicineData;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicineDataRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public MedicineDataRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public MedicineDataRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        MedicineData instance = (MedicineData) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblMedicineData ("
                    + "name,"
                    + "price,"
                    + "description"
                    + ") VALUES (?,?,?);";
            lsParams.add(instance.getName());
            lsParams.add(instance.getPrice());
            lsParams.add(instance.getDescription());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<MedicineData> instances = (List<MedicineData>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblMedicineData ("
                    + "name,"
                    + "price,"
                    + "description"
                    + ") VALUES ";
            for(MedicineData instance : instances){
                sql = sql.concat("(?,?,?),");
                lsParams.add(instance.getName());
                lsParams.add(instance.getPrice());
                lsParams.add(instance.getDescription());
            }
            sql = sql.substring(0, sql.length() - 1).concat(";");
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean update(iEntity entity) {
        MedicineData instance = (MedicineData) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblMedicineData SET "
                + "name = ?,"
                + "price = ?,"
                + "description = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getName());
            lsParams.add(instance.getPrice());
            lsParams.add(instance.getDescription());
            
            lsParams.add(instance.getId());
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean update(List listEntities) {
        List<MedicineData> instances = (List<MedicineData>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblMedicineData ("
                    + "id,"
                    + "name,"
                    + "price,"
                    + "description"
                    + ") VALUES ";
            for(MedicineData instance : instances){
                sql = sql.concat("(?,?,?,?),");
                lsParams.add(instance.getId());
                
                lsParams.add(instance.getName());
                lsParams.add(instance.getPrice());
                lsParams.add(instance.getDescription());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "name = values(name),"
                    + "price = values(price),"
                    + "description = values(description);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        MedicineData instance = (MedicineData) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblMedicineData WHERE id = ?;";
            List<Object> lsParams = new ArrayList<>();
                lsParams.add(instance.getId());
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
            resetAutoIncrement();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(List listEntities) {
        List<MedicineData> instances = (List<MedicineData>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblMedicineData WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(MedicineData instance : instances){
                sql = sql.concat("?,");
                lsParams.add(instance.getId());
            }
            sql = sql.substring(0, sql.length() - 1).concat(");");
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
            resetAutoIncrement();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public List<iEntity> select(String condt) {
        List<iEntity> res = null;
        try {
            this.db.openConnection();
            String sql = "SELECT * FROM tblMedicineData WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    MedicineData instance = new MedicineData();
                    instance.setId(result.getInt("id"));
                    instance.setName(result.getString("name"));
                    instance.setPrice(result.getFloat("price"));
                    instance.setDescription(result.getString("description"));
                    res.add(instance);
                }
            }
            this.db.close(result);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public void resetAutoIncrement() {
        int res = 0;
        try {
            this.db.openConnection();
            String sql = "SELECT (max(id) + 1) as id FROM tblMedicineData;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblMedicineData auto_increment = "+ id +";";
            this.db.execUpdate(sql, new ArrayList());
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public IDB getDB() {
        return (IDB) this.db;
    }
}
