package repository;

import entity.Room;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public RoomRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public RoomRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        Room instance = (Room) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblRoom ("
                    + "name,"
                    + "type,"
                    + "clinicType"
                    + ") VALUES (?,?,?);";
            lsParams.add(instance.getName());
            lsParams.add(instance.getType());
            lsParams.add(instance.getClinicType());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<Room> instances = (List<Room>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblRoom ("
                    + "name,"
                    + "type,"
                    + "clinicType"
                    + ") VALUES ";
            for(Room instance : instances){
                sql = sql.concat("(?,?,?),");
                lsParams.add(instance.getName());
                lsParams.add(instance.getType());
                lsParams.add(instance.getClinicType());
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
        Room instance = (Room) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblRoom SET "
                    + "name = ?,"
                    + "type = ?,"
                    + "clinicType = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getName());
            lsParams.add(instance.getType());
            lsParams.add(instance.getClinicType());
            
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
        List<Room> instances = (List<Room>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblRoom ("
                    + "id,"
                    + "name,"
                    + "type,"
                    + "clinicType"
                    + ") VALUES ";
            for(Room instance : instances){
                sql = sql.concat("(?,?,?,?),");
                lsParams.add(instance.getId());
                lsParams.add(instance.getName());
                lsParams.add(instance.getType());
                lsParams.add(instance.getClinicType());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "name = values(name),"
                    + "type = values(type),"
                    + "clinicType = values(clinicType);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        Room instance = (Room) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblRoom WHERE id = ?;";
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
        List<Room> instances = (List<Room>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblRoom WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(Room instance : instances){
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
            String sql = "SELECT * FROM tblRoom WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    Room instance = new Room();
                    instance.setId(result.getInt("id"));
                    instance.setName(result.getString("name"));
                    instance.setType(result.getString("type"));
                    instance.setClinicType(result.getString("clinicType"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblRoom;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblRoom auto_increment = "+ id +";";
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
