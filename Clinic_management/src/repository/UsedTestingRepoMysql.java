package repository;

import entity.UsedTesting;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsedTestingRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public UsedTestingRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public UsedTestingRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        UsedTesting instance = (UsedTesting) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUsedTesting ("
                    + "quantity,"
                    + "amount,"
                    + "tblTestingDataId,"
                    + "tblPatientProfileId,"
                    + "isPaid,"
                    + "testResults"
                    + ") VALUES (?,?,?,?,?,?);";
            lsParams.add(instance.getQuantity());
            lsParams.add(instance.getAmount());
            lsParams.add(instance.getTblTestingDataId());
            lsParams.add(instance.getTblPatientProfileId());
            lsParams.add(instance.getIsPaid());
            lsParams.add(instance.getTestResults());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<UsedTesting> instances = (List<UsedTesting>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUsedTesting ("
                    + "quantity,"
                    + "amount,"
                    + "tblTestingDataId,"
                    + "tblPatientProfileId,"
                    + "isPaid,"
                    + "testResults"
                    + ") VALUES ";
            for(UsedTesting instance : instances){
                sql = sql.concat("(?,?,?,?,?,?),");
                lsParams.add(instance.getQuantity());
                lsParams.add(instance.getAmount());
                lsParams.add(instance.getTblTestingDataId());
                lsParams.add(instance.getTblPatientProfileId());
                lsParams.add(instance.getIsPaid());
                lsParams.add(instance.getTestResults());
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
        UsedTesting instance = (UsedTesting) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblUsedTesting SET "
                + "quantity = ?,"
                + "amount = ?,"
                + "tblTestingDataId = ?,"
                + "tblPatientProfileId = ?,"
                + "isPaid = ?,"
                + "testResults = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getQuantity());
            lsParams.add(instance.getAmount());
            lsParams.add(instance.getTblTestingDataId());
            lsParams.add(instance.getTblPatientProfileId());
            lsParams.add(instance.getIsPaid());
            lsParams.add(instance.getTestResults());
            
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
        List<UsedTesting> instances = (List<UsedTesting>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUsedTesting ("
                    + "id,"
                    + "quantity,"
                    + "amount,"
                    + "tblTestingDataId,"
                    + "tblPatientProfileId,"
                    + "isPaid,"
                    + "testResults"
                    + ") VALUES ";
            for(UsedTesting instance : instances){
                sql = sql.concat("(?,?,?,?,?,?,?),");
                lsParams.add(instance.getId());
                
                lsParams.add(instance.getQuantity());
                lsParams.add(instance.getAmount());
                lsParams.add(instance.getTblTestingDataId());
                lsParams.add(instance.getTblPatientProfileId());
                lsParams.add(instance.getIsPaid());
                lsParams.add(instance.getTestResults());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "quantity = values(quantity),"
                    + "amount = values(amount),"
                    + "tblTestingDataId = values(tblTestingDataId),"
                    + "tblPatientProfileId = values(tblPatientProfileId),"
                    + "isPaid = values(isPaid),"
                    + "testResults = values(testResults);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        UsedTesting instance = (UsedTesting) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblUsedTesting WHERE id = ?;";
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
        List<UsedTesting> instances = (List<UsedTesting>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblUsedTesting WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(UsedTesting instance : instances){
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
            String sql = "SELECT * FROM tblUsedTesting WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    UsedTesting instance = new UsedTesting();
                    instance.setId(result.getInt("id"));
                    instance.setQuantity(result.getInt("quantity"));
                    instance.setAmount(result.getFloat("amount"));
                    instance.setTblTestingDataId(result.getInt("tblTestingDataId"));
                    instance.setTblPatientProfileId(result.getInt("tblPatientProfileId"));
                    instance.setIsPaid(result.getInt("isPaid"));
                    instance.setTestResults(result.getString("testResults"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblUsedTesting;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblUsedTesting auto_increment = "+ id +";";
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
