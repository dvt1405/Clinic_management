package repository;

import entity.UsedMedicine;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsedMedicineRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public UsedMedicineRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public UsedMedicineRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        UsedMedicine instance = (UsedMedicine) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUsedMedicine ("
                    + "quantity,"
                    + "amount,"
                    + "tblMedicineDataId,"
                    + "tblPatientProfileId,"
                    + "isPaid"
                    + ") VALUES (?,?,?,?,?);";
            lsParams.add(instance.getQuantity());
            lsParams.add(instance.getAmount());
            lsParams.add(instance.getTblMedicineDataId());
            lsParams.add(instance.getTblPatientProfileId());
            lsParams.add(instance.getIsPaid());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<UsedMedicine> instances = (List<UsedMedicine>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUsedMedicine ("
                    + "quantity,"
                    + "amount,"
                    + "tblMedicineDataId,"
                    + "tblPatientProfileId,"
                    + "isPaid"
                    + ") VALUES ";
            for(UsedMedicine instance : instances){
                sql = sql.concat("(?,?,?,?,?),");
                lsParams.add(instance.getQuantity());
                lsParams.add(instance.getAmount());
                lsParams.add(instance.getTblMedicineDataId());
                lsParams.add(instance.getTblPatientProfileId());
                lsParams.add(instance.getIsPaid());
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
        UsedMedicine instance = (UsedMedicine) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblUsedMedicine SET "
                    + "quantity = ?,"
                    + "amount = ?,"
                    + "tblMedicineDataId = ?,"
                    + "tblPatientProfileId = ?,"
                    + "isPaid = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getQuantity());
            lsParams.add(instance.getAmount());
            lsParams.add(instance.getTblMedicineDataId());
            lsParams.add(instance.getTblPatientProfileId());
            lsParams.add(instance.getIsPaid());
            
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
        List<UsedMedicine> instances = (List<UsedMedicine>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUsedMedicine ("
                    + "id,"
                    + "quantity,"
                    + "amount,"
                    + "tblMedicineDataId,"
                    + "tblPatientProfileId,"
                    + "isPaid"
                    + ") VALUES ";
            for(UsedMedicine instance : instances){
                sql = sql.concat("(?,?,?,?,?,?),");
                lsParams.add(instance.getId());
                
                lsParams.add(instance.getQuantity());
                lsParams.add(instance.getAmount());
                lsParams.add(instance.getTblMedicineDataId());
                lsParams.add(instance.getTblPatientProfileId());
                lsParams.add(instance.getIsPaid());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "quantity = values(quantity),"
                    + "amount = values(amount),"
                    + "tblMedicineDataId = values(tblMedicineDataId),"
                    + "tblPatientProfileId = values(tblPatientProfileId),"
                    + "isPaid = values(isPaid);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        UsedMedicine instance = (UsedMedicine) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblUsedMedicine WHERE id = ?;";
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
        List<UsedMedicine> instances = (List<UsedMedicine>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblUsedMedicine WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(UsedMedicine instance : instances){
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
            String sql = "SELECT * FROM tblUsedMedicine WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    UsedMedicine instance = new UsedMedicine();
                    instance.setId(result.getInt("id"));
                    instance.setQuantity(result.getInt("quantity"));
                    instance.setAmount(result.getFloat("amount"));
                    instance.setTblMedicineDataId(result.getInt("tblMedicineDataId"));
                    instance.setTblPatientProfileId(result.getInt("tblPatientProfileId"));
                    instance.setIsPaid(result.getInt("isPaid"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblUsedMedicine;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblUsedMedicine auto_increment = "+ id +";";
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
