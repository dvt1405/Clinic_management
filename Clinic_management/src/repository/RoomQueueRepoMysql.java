package repository;

import entity.RoomQueue;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomQueueRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public RoomQueueRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public RoomQueueRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        RoomQueue instance = (RoomQueue) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
             
            sql = "INSERT INTO tblRoomQueue ("
                    + "registerTime,"
                    + "tblRoomId,"
                    + "tblPatientId"
                    + ") VALUES (?,?,?);";
            lsParams.add(instance.getRegisterTime());
            lsParams.add(instance.getTblRoomId());
            lsParams.add(instance.getTblPatientId());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<RoomQueue> instances = (List<RoomQueue>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblRoomQueue ("
                    + "registerTime,"
                    + "tblRoomId,"
                    + "tblPatientId"
                    + ") VALUES ";
            for(RoomQueue instance : instances){
                sql = sql.concat("(?,?,?),");
                lsParams.add(instance.getRegisterTime());
                lsParams.add(instance.getTblRoomId());
                lsParams.add(instance.getTblPatientId());
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
        RoomQueue instance = (RoomQueue) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblRoomQueue SET "
                    + "registerTime = ?,"
                    + "tblRoomId = ?,"
                    + "tblPatientId = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getRegisterTime());
            lsParams.add(instance.getTblRoomId());
            lsParams.add(instance.getTblPatientId());
            
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
        List<RoomQueue> instances = (List<RoomQueue>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblRoomQueue ("
                    + "id,"
                    + "registerTime,"
                    + "tblRoomId,"
                    + "tblPatientId,"
                    + ") VALUES ";
            for(RoomQueue instance : instances){
                sql = sql.concat("(?,?,?,?),");
                lsParams.add(instance.getId());
                lsParams.add(instance.getRegisterTime());
                lsParams.add(instance.getTblRoomId());
                lsParams.add(instance.getTblPatientId());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "registerTime = values(registerTime),"
                    + "tblRoomId = values(tblRoomId),"
                    + "tblPatientId = values(tblPatientId);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        RoomQueue instance = (RoomQueue) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblRoomQueue WHERE id = ?;";
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
        List<RoomQueue> instances = (List<RoomQueue>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblRoomQueue WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(RoomQueue instance : instances){
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
            String sql = "SELECT * FROM tblRoomQueue WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    RoomQueue instance = new RoomQueue();
                    instance.setId(result.getInt("id"));
                    instance.setRegisterTime(result.getTimestamp("registerTime"));
                    instance.setTblRoomId(result.getInt("tblRoomId"));
                    instance.setTblPatientId(result.getInt("tblPatientId"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblRoomQueue;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblRoomQueue auto_increment = "+ id +";";
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
