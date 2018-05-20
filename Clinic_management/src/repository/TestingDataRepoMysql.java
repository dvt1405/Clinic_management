package repository;

import entity.TestingData;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestingDataRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public TestingDataRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public TestingDataRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        TestingData instance = (TestingData) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblTestingData ("
                    + "name,"
                    + "price,"
                    + "testingRoomId,"
                    + "description"
                    + ") VALUES (?,?,?,?);";
            lsParams.add(instance.getName());
            lsParams.add(instance.getPrice());
            lsParams.add(instance.getTestingRoomId());
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
        List<TestingData> instances = (List<TestingData>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblTestingData ("
                    + "name,"
                    + "price,"
                    + "testingRoomId,"
                    + "description"
                    + ") VALUES ";
            for(TestingData instance : instances){
                sql = sql.concat("(?,?,?,?),");
                lsParams.add(instance.getName());
                lsParams.add(instance.getPrice());
                lsParams.add(instance.getTestingRoomId());
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
        TestingData instance = (TestingData) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblTestingData SET "
                    + "name = ?,"
                    + "price = ?,"
                    + "testingRoomId = ?,"
                    + "description = ?,"
                + " WHERE id = ?;";
            lsParams.add(instance.getName());
            lsParams.add(instance.getPrice());
            lsParams.add(instance.getTestingRoomId());
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
        List<TestingData> instances = (List<TestingData>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblTestingData ("
                    + "id,"
                    + "name,"
                    + "price,"
                    + "testingRoomId,"
                    + "description"
                    + ") VALUES ";
            for(TestingData instance : instances){
                sql = sql.concat("(?,?,?,?,?),");
                lsParams.add(instance.getId());
                
                lsParams.add(instance.getName());
                lsParams.add(instance.getPrice());
                lsParams.add(instance.getTestingRoomId());
                lsParams.add(instance.getDescription());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "name = values(name),"
                    + "price = values(price),"
                    + "testingRoomId = values(testingRoomId),"
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
        TestingData instance = (TestingData) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblTestingData WHERE id = ?;";
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
        List<TestingData> instances = (List<TestingData>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblTestingData WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(TestingData instance : instances){
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
            String sql = "SELECT * FROM tblTestingData WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    TestingData instance = new TestingData();
                    instance.setId(result.getInt("id"));
                    instance.setName(result.getString("name"));
                    instance.setPrice(result.getFloat("price"));
                    instance.setTestingRoomId(result.getInt("testingRoomId"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblTestingData;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblTestingData auto_increment = "+ id +";";
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
