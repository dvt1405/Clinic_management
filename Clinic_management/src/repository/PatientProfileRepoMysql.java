package repository;

import entity.PatientProfile;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientProfileRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public PatientProfileRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public PatientProfileRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        PatientProfile instance = (PatientProfile) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblPatientProfile ("
                    + "examinationDate,"
                    + "examinationPrice,"
                    + "doctorId,"
                    + "tblPatientId,"
                    + "clinicResults"
                    + ") VALUES (?,?,?,?,?);";
            lsParams.add(instance.getExaminationDate());
            lsParams.add(instance.getExaminationPrice());
            lsParams.add(instance.getDoctorId());
            lsParams.add(instance.getTblPatientId());
            lsParams.add(instance.getClinicResults());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<PatientProfile> instances = (List<PatientProfile>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblPatientProfile ("
                    + "examinationDate,"
                    + "examinationPrice,"
                    + "doctorId,"
                    + "tblPatientId,"
                    + "clinicResults"
                    + ") VALUES ";
            for(PatientProfile instance : instances){
                sql = sql.concat("(?,?,?,?,?),");
                lsParams.add(instance.getExaminationDate());
                lsParams.add(instance.getExaminationPrice());
                lsParams.add(instance.getDoctorId());
                lsParams.add(instance.getTblPatientId());
                lsParams.add(instance.getClinicResults());
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
        PatientProfile instance = (PatientProfile) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblPatientProfile SET "
                + "examinationDate = ?,"
                + "examinationPrice = ?,"
                + "doctorId = ?,"
                + "tblPatientId = ?,"
                + "clinicResults = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getExaminationDate());
            lsParams.add(instance.getExaminationPrice());
            lsParams.add(instance.getDoctorId());
            lsParams.add(instance.getTblPatientId());
            lsParams.add(instance.getClinicResults());
            
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
        List<PatientProfile> instances = (List<PatientProfile>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblPatientProfile ("
                    + "id,"
                    + "examinationDate,"
                    + "examinationPrice,"
                    + "doctorId,"
                    + "tblPatientId,"
                    + "clinicResults"
                    + ") VALUES ";
            for(PatientProfile instance : instances){
                sql = sql.concat("(?,?,?,?,?,?,?),");
                lsParams.add(instance.getId());
                lsParams.add(instance.getExaminationDate());
                lsParams.add(instance.getExaminationPrice());
                lsParams.add(instance.getDoctorId());
                lsParams.add(instance.getTblPatientId());
                lsParams.add(instance.getClinicResults());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "examinationDate = values(examinationDate),"
                    + "examinationPrice = values(examinationPrice),"
                    + "doctorId = values(doctorId),"
                    + "tblPatientId = values(tblPatientId),"
                    + "clinicResults = values(clinicResults);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        PatientProfile instance = (PatientProfile) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblPatientProfile WHERE id = ?;";
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
        List<PatientProfile> instances = (List<PatientProfile>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblPatientProfile WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(PatientProfile instance : instances){
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
            String sql = "SELECT * FROM tblPatientProfile WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    PatientProfile instance = new PatientProfile();
                    instance.setId(result.getInt("id"));
                    instance.setExaminationDate(result.getDate("examinationDate"));
                    instance.setExaminationPrice(result.getFloat("examinationPrice"));
                    instance.setDoctorId(result.getInt("doctorId"));
                    instance.setTblPatientId(result.getInt("tblPatientId"));
                    instance.setClinicResults(result.getString("clinicResults"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblPatientProfile;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblPatientProfile auto_increment = "+ id +";";
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
