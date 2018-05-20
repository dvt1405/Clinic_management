package repository;

import entity.Bill;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public BillRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public BillRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        Bill instance = (Bill) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblBill ("
                    + "amount,"
                    + "payTime,"
                    + "amountPaid,"
                    + "nurseId,"
                    + "tblPatientProfileId"
                    + ") VALUES (?,?,?,?,?);";
            lsParams.add(instance.getAmount());
            lsParams.add(instance.getPayTime());
            lsParams.add(instance.getAmountPaid());
            lsParams.add(instance.getNurseId());
            lsParams.add(instance.getTblPatientProfileId());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<Bill> instances = (List<Bill>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblBill ("
                    + "amount,"
                    + "payTime,"
                    + "amountPaid,"
                    + "nurseId,"
                    + "tblPatientProfileId"
                    + ") VALUES ";
            for(Bill instance : instances){
                sql = sql.concat("(?,?,?,?,?),");
                lsParams.add(instance.getAmount());
                lsParams.add(instance.getPayTime());
                lsParams.add(instance.getAmountPaid());
                lsParams.add(instance.getNurseId());
                lsParams.add(instance.getTblPatientProfileId());
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
        Bill instance = (Bill) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblBill SET "
                    + "amount = ?,"
                    + "payTime = ?,"
                    + "amountPaid = ?,"
                    + "nurseId = ?,"
                    + "tblPatientProfileId = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getAmount());
            lsParams.add(instance.getPayTime());
            lsParams.add(instance.getAmountPaid());
            lsParams.add(instance.getNurseId());
            lsParams.add(instance.getTblPatientProfileId());
            
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
        List<Bill> instances = (List<Bill>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblBill ("
                    + "id,"
                    + "amount,"
                    + "payTime,"
                    + "amountPaid,"
                    + "nurseId,"
                    + "tblPatientProfileId"
                    + ") VALUES ";
            for(Bill instance : instances){
                sql = sql.concat("(?,?,?,?,?,?),");
                lsParams.add(instance.getId());
                
                lsParams.add(instance.getAmount());
                lsParams.add(instance.getPayTime());
                lsParams.add(instance.getAmountPaid());
                lsParams.add(instance.getNurseId());
                lsParams.add(instance.getTblPatientProfileId());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "amount = values(amount),"
                    + "payTime = values(payTime),"
                    + "amountPaid = values(amountPaid),"
                    + "nurseId = values(nurseId),"
                    + "tblPatientProfileId = values(tblPatientProfileId);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        Bill instance = (Bill) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblBill WHERE id = ?;";
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
        List<Bill> instances = (List<Bill>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblBill WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(Bill instance : instances){
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
            String sql = "SELECT * FROM tblBill WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    Bill instance = new Bill();
                    instance.setId(result.getInt("id"));
                    instance.setAmount(result.getFloat("amount"));
                    instance.setPayTime(result.getTimestamp("payTime"));
                    instance.setAmountPaid(result.getFloat("amountPaid"));
                    instance.setNurseId(result.getInt("nurseId"));
                    instance.setTblPatientProfileId(result.getInt("tblPatientProfileId"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblBill;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblBill auto_increment = "+ id +";";
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
