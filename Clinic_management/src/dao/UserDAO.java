package dao;

import Utils.$;
import Utils.Helper;
import entity.User;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.List;
import repository.UserRepoMysql;
import repository.IRepo;

public class UserDAO implements IDAO {
    
    private IRepo repo;

    public UserDAO() {
        this.repo = new UserRepoMysql();
    }

    public UserDAO(IRepo _repo) {
        this.repo = _repo;
    }

    public boolean checkLogin(String account, String password){
        String cryptedPassword = Helper.cryptPassword(password);
        return (this.fetch("username = '"+ account +"' and password = '"+ cryptedPassword +"'").size() == 1);
    }
    
    public User findByAccount(String account){
        List<iEntity> result = this.fetch("username = '"+ account +"';");
        if(!result.isEmpty())
            return (User) result.get(0);
        return null;
    }
    
    public void logout() {
        Helper.openLoading();
        $.typeUser = "visitor";
        $.idUser = 0;
        $.main.initMain();
        Helper.closeLoading();
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
}
