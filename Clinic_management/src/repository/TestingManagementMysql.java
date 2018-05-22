/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.TestingManagement;
import entity.iEntity;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dezeross
 */
public class TestingManagementMysql {
    private MysqlDBDeploy db;
    public TestingManagementMysql(){
        this.db = new MysqlDBDeploy();
    }
//    private MysqlDBDeploy conn;
    public List<iEntity> executeSql(Date timeStart,Date timeEnd ){
        List<iEntity> rs = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String tStart = format.format(timeStart);
        String tEnd = format.format(timeEnd);
        System.out.println(tStart);
        System.out.println(tEnd);
        try {
                this.db.openConnection();
//             String sql = "SELECT tbltestingdata.id," +
//                "tbltestingdata.name," +
//                "sum(tblusedtesting.amount) as price," +
//                "sum(tblusedtesting.quantity) as times " +
//                " from tbltestingdata,tblusedtesting,tblpatientprofile " +
//                "WHERE " +
//                "tbltestingdata.id=tblusedtesting.tblTestingDataId and " +
//                "tblusedtesting.tblPatientProfileId=tblpatientprofile.id and " +
//                "tblpatientprofile.examinationDate>='"+tStart+"' and " +
//                "tblpatientprofile.examinationDate<='"+tEnd+"' and " +
//                "tblusedtesting.isPaid=1 " +
//                "GROUP BY tbltestingdata.name";
            String sql = "Select*from tblTesting";
            ResultSet result = this.db.execQuery(sql);
            if (result!=null) {
                rs = new ArrayList<>();
                while (result.next()) {
                    TestingManagement instance = new TestingManagement();
                    instance.setId(result.getInt("id"));
                    instance.setName(result.getString("name"));
                    instance.setAmount(result.getFloat("price"));
                    instance.setTimes(result.getInt("times"));
                    rs.add(instance);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
//            System.out.println("Loi SQl");
        }
        return rs;
    }
    
}
