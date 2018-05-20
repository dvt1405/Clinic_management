package repository;

import entity.Patient;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public PatientRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public PatientRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        Patient instance = (Patient) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblPatient ("
                    + "fullName,"
                    + "dob,"
                    + "gender,"
                    + "address,"
                    + "healthInsuranceCardNumber,"
                    + "identityCardNumber"
                    + ") VALUES (?,?,?,?,?,?);";
            lsParams.add(instance.getFullName());
            lsParams.add(instance.getDob());
            lsParams.add(instance.getGender());
            lsParams.add(instance.getAddress());
            lsParams.add(instance.getHealthInsuranceCardNumber());
            lsParams.add(instance.getIndentityCardNumber());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<Patient> instances = (List<Patient>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblPatient ("
                    + "fullName,"
                    + "dob,"
                    + "gender,"
                    + "address,"
                    + "healthInsuranceCardNumber,"
                    + "identityCardNumber"
                    + ") VALUES ";
            for(Patient instance : instances){
                sql = sql.concat("(?,?,?,?,?,?),");
                lsParams.add(instance.getFullName());
                lsParams.add(instance.getDob());
                lsParams.add(instance.getGender());
                lsParams.add(instance.getAddress());
                lsParams.add(instance.getHealthInsuranceCardNumber());
                lsParams.add(instance.getIndentityCardNumber());
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
        Patient instance = (Patient) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblPatient SET "
                + "fullName = ?,"
                + "dob = ?,"
                + "gender = ?,"
                + "address = ?,"
                + "healthInsuranceCardNumber = ?,"
                + "identityCardNumber = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getFullName());
            lsParams.add(instance.getDob());
            lsParams.add(instance.getGender());
            lsParams.add(instance.getAddress());
            lsParams.add(instance.getHealthInsuranceCardNumber());
            lsParams.add(instance.getIndentityCardNumber());
            
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
        List<Patient> instances = (List<Patient>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblPatient ("
                    + "id,"
                    + "fullName,"
                    + "dob,"
                    + "gender,"
                    + "address,"
                    + "healthInsuranceCardNumber,"
                    + "identityCardNumber"
                    + ") VALUES ";
            for(Patient instance : instances){
                sql = sql.concat("(?,?,?,?,?,?,?),");
                lsParams.add(instance.getId());
                
                lsParams.add(instance.getFullName());
                lsParams.add(instance.getDob());
                lsParams.add(instance.getGender());
                lsParams.add(instance.getAddress());
                lsParams.add(instance.getHealthInsuranceCardNumber());
                lsParams.add(instance.getIndentityCardNumber());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "fullName = values(fullName),"
                    + "dob = values(dob),"
                    + "gender = values(gender),"
                    + "address = values(address),"
                    + "healthInsuranceCardNumber = values(healthInsuranceCardNumber),"
                    + "identityCardNumber = values(identityCardNumber);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        Patient instance = (Patient) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblPatient WHERE id = ?;";
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
        List<Patient> instances = (List<Patient>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblPatient WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(Patient instance : instances){
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
            String sql = "SELECT * FROM tblPatient WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    Patient instance = new Patient();
                    instance.setId(result.getInt("id"));
                    instance.setFullName(result.getString("fullName"));
                    instance.setDob(result.getDate("dob"));
                    instance.setGender(result.getString("gender"));
                    instance.setAddress(result.getString("address"));
                    instance.setHealthInsuranceCardNumber(result.getString("healthInsuranceCardNumber"));
                    instance.setIndentityCardNumber(result.getString("identityCardNumber"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblPatient;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblPatient auto_increment = "+ id +";";
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
