/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.DetailTesting;
import entity.iEntity;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dezeross
 */
public class DetailTestingMysql {
    private MysqlDBDeploy db;
    public DetailTestingMysql(){
        this.db = new MysqlDBDeploy();
    }
    public List<iEntity> executeSql(Date timeStart,Date timeEnd,int id){
        List<iEntity> rs =null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String tStart = format.format(timeStart);
        String tEnd = format.format(timeEnd);
        System.out.println(tStart);
        System.out.println(tEnd);
        try {
            this.db.openConnection();
            String sql = "SELECT " +
                "    tblpatient.id," +
                "    tblpatient.fullName,tblpatient.dob," +
                "    tblpatientprofile.examinationDate," +
                "    SUM(tblusedtesting.quantity) as times," +
                "    SUM(tblusedtesting.amount) as price,"
                    + "tblpatient.healthInsuranceCardNumber" +
                " FROM tblusedtesting,tblpatientprofile,tblpatient " +
                " WHERE " +
                "    tblpatient.id=tblpatientprofile.tblPatientId AND " +
                "    tblpatientprofile.id = tblusedtesting.tblPatientProfileId AND " +
                "    tblusedtesting.tblTestingDataId="+id +
                " AND tblpatientprofile.examinationDate>='"+tStart+"' AND "+
                " tblpatientprofile.examinationDate<='"+tEnd+"' "+
                    " AND tblusedtesting.isPaid=1 "+
                "    GROUP BY tblpatient.fullName";
            ResultSet result = this.db.execQuery(sql);
            if (result!=null) {
                rs =new ArrayList<>();
                while(result.next()){
                    DetailTesting instance = new DetailTesting();
                    instance.setId(result.getInt("id"));
                    instance.setDob(result.getDate("dob"));
                    instance.setName(result.getString("fullname"));
                    instance.setExaminationDate(result.getDate("examinationDate"));
                    instance.setQuatity(result.getInt("times"));
                    instance.setHeathInsurenceCardNumber(result.getString("healthInsuranceCardNumber"));
                    instance.setAmount(result.getFloat("price"));
                    rs.add(instance);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
}
