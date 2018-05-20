package repository;

import entity.RoomSchedule;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomScheduleRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public RoomScheduleRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public RoomScheduleRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        RoomSchedule instance = (RoomSchedule) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblRoomSchedule ("
                    + "startTime,"
                    + "endTime,"
                    + "tblUserId,"
                    + "tblRoomId"
                    + ") VALUES (?,?,?,?);";
            lsParams.add(instance.getStartTime());
            lsParams.add(instance.getEndTime());
            lsParams.add(instance.getTblUserId());
            lsParams.add(instance.getTblRoomId());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<RoomSchedule> instances = (List<RoomSchedule>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblRoomSchedule ("
                    + "startTime,"
                    + "endTime,"
                    + "tblUserId,"
                    + "tblRoomId"
                    + ") VALUES ";
            for(RoomSchedule instance : instances){
                sql = sql.concat("(?,?,?,?),");
                lsParams.add(instance.getStartTime());
                lsParams.add(instance.getEndTime());
                lsParams.add(instance.getTblUserId());
                lsParams.add(instance.getTblRoomId());
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
        RoomSchedule instance = (RoomSchedule) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblRoomSchedule SET "
                    + "startTime = ?,"
                    + "endTime = ?,"
                    + "tblUserId = ?,"
                    + "tblRoomId = ?,"
                + " WHERE id = ?;";
            lsParams.add(instance.getStartTime());
            lsParams.add(instance.getEndTime());
            lsParams.add(instance.getTblUserId());
            lsParams.add(instance.getTblRoomId());
            
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
        List<RoomSchedule> instances = (List<RoomSchedule>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblRoomSchedule ("
                    + "id,"
                    + "startTime,"
                    + "endTime,"
                    + "tblUserId,"
                    + "tblRoomId"
                    + ") VALUES ";
            for(RoomSchedule instance : instances){
                sql = sql.concat("(?,?,?,?,?),");
                lsParams.add(instance.getId());
                lsParams.add(instance.getStartTime());
                lsParams.add(instance.getEndTime());
                lsParams.add(instance.getTblUserId());
                lsParams.add(instance.getTblRoomId());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "startTime = values(startTime),"
                    + "endTime = values(endTime),"
                    + "tblUserId = values(tblUserId),"
                    + "tblRoomId = values(tblRoomId);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        RoomSchedule instance = (RoomSchedule) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblRoomSchedule WHERE id = ?;";
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
        List<RoomSchedule> instances = (List<RoomSchedule>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblRoomSchedule WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(RoomSchedule instance : instances){
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
            String sql = "SELECT * FROM tblRoomSchedule WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    RoomSchedule instance = new RoomSchedule();
                    instance.setId(result.getInt("id"));
                    instance.setStartTime(result.getTimestamp("startTime"));
                    instance.setEndTime(result.getTimestamp("endTime"));
                    instance.setTblUserId(result.getInt("tblUserId"));
                    instance.setTblRoomId(result.getInt("tblRoomId"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblRoomSchedule;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblRoomSchedule auto_increment = "+ id +";";
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
