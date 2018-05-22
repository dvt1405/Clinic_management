package dao;

import entity.UsedTesting;
import entity.iEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.UsedTestingRepoMysql;
import repository.IRepo;

/**
 *
 * @author MrLELOI
 */
public class UsedTestingDAO implements IDAO {
    
    private IRepo repo;

    public UsedTestingDAO() {
        this.repo = new UsedTestingRepoMysql();
    }

    public UsedTestingDAO(IRepo _repo) {
        this.repo = _repo;
    }

    @Override
    public boolean add(iEntity entity) {
        return this.repo.insert(entity);
    }

    @Override
    public boolean add(List<iEntity> entities) {
        return this.repo.insert(entities);
    }

    @Override
    public boolean modify(iEntity entity) {
        return this.repo.update(entity);
    }

    @Override
    public boolean modify(List<iEntity> entities) {
        return this.repo.update(entities);
    }

    @Override
    public boolean delete(iEntity entity) {
        return this.repo.delete(entity);
    }

    @Override
    public boolean delete(List<iEntity> entities) {
        return this.repo.delete(entities);
    }

    @Override
    public iEntity findById(int gid) {
        try {
            List<iEntity> result = this.repo.select("id = " + Integer.valueOf(gid) + ";");
            if (!result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<iEntity> fetch(String condt) {
        return this.repo.select(condt);
    }

    @Override
    public List<iEntity> fetchAll() {
        return this.repo.select("id IS NOT NULL;");
    }

    @Override
    public ResultSet queryDB(String sql) {
        return this.repo.getDB().execQuery(sql);
    }
    
    public List<iEntity> findByPatientProfileIdAndRoomId(int patientProfileId, int roomId) {
        List<iEntity> res = null;
        try {
            this.repo.getDB().openConnection();
            String sql = String.format("SELECT * FROM tblUsedTesting ut JOIN tblTestingData td ON ut.tblTestingDataId = td.id WHERE td.testingRoomId = %d AND ut.tblPatientProfileId = %d",
                        roomId,
                        patientProfileId
                    );
            PreparedStatement pstn = this.repo.getDB().getConn().prepareStatement(sql);
            
            ResultSet result = pstn.executeQuery();
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
            //this.repo.getDB().close(result);
            this.repo.getDB().close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }
}
