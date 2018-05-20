package repository;

import entity.User;
import entity.iEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepoMysql implements IRepo {
    private MysqlDBDeploy db;
    
    public UserRepoMysql(){
        this.db = new MysqlDBDeploy();
    }
    public UserRepoMysql(MysqlDBDeploy _db){
        this.db = _db;
    }

    @Override
    public boolean insert(iEntity entity) {
        User instance = (User) entity;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUser ("
                    + "fullName,"
                    + "dob,"
                    + "gender,"
                    + "address,"
                    + "position,"
                    + "username,"
                    + "password"
                    + ") VALUES (?,?,?,?,?,?,?);";
            lsParams.add(instance.getFullName());
            lsParams.add(instance.getDob());
            lsParams.add(instance.getGender());
            lsParams.add(instance.getAddress());
            lsParams.add(instance.getPosition());
            lsParams.add(instance.getUsername());
            lsParams.add(instance.getPassword());
                
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean insert(List listEntities) {
        List<User> instances = (List<User>) listEntities;
        resetAutoIncrement();
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUser ("
                    + "fullName,"
                    + "dob,"
                    + "gender,"
                    + "address,"
                    + "position,"
                    + "username,"
                    + "password"
                    + ") VALUES ";
            for(User instance : instances){
                sql = sql.concat("(?,?,?,?,?,?,?),");
                lsParams.add(instance.getFullName());
                lsParams.add(instance.getDob());
                lsParams.add(instance.getGender());
                lsParams.add(instance.getAddress());
                lsParams.add(instance.getPosition());
                lsParams.add(instance.getUsername());
                lsParams.add(instance.getPassword());
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
        User instance = (User) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "UPDATE tblUser SET "
                    + "fullName = ?,"
                    + "dob = ?,"
                    + "gender = ?,"
                    + "address = ?,"
                    + "position = ?,"
                    + "username = ?,"
                    + "password = ?"
                + " WHERE id = ?;";
            lsParams.add(instance.getFullName());
            lsParams.add(instance.getDob());
            lsParams.add(instance.getGender());
            lsParams.add(instance.getAddress());
            lsParams.add(instance.getPosition());
            lsParams.add(instance.getUsername());
            lsParams.add(instance.getPassword());
            
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
        List<User> instances = (List<User>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = null;
            List<Object> lsParams = new ArrayList<>();
            
            sql = "INSERT INTO tblUser ("
                    + "id,"
                    + "fullName,"
                    + "dob,"
                    + "gender,"
                    + "address,"
                    + "position,"
                    + "username,"
                    + "password"
                    + ") VALUES ";
            for(User instance : instances){
                sql = sql.concat("(?,?,?,?,?,?,?,?),");
                lsParams.add(instance.getId());
                
                lsParams.add(instance.getFullName());
                lsParams.add(instance.getDob());
                lsParams.add(instance.getGender());
                lsParams.add(instance.getAddress());
                lsParams.add(instance.getPosition());
                lsParams.add(instance.getUsername());
                lsParams.add(instance.getPassword());
            }
            sql = sql.substring(0, sql.length() - 1).concat("ON DUPLICATE KEY UPDATE "
                    + "fullName = values(fullName),"
                    + "dob = values(dob),"
                    + "gender = values(gender),"
                    + "address = values(address),"
                    + "position = values(position),"
                    + "username = values(username),"
                    + "password = values(password);");
            
            res = this.db.execUpdate(sql, lsParams);
            this.db.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return res;
    }

    @Override
    public boolean delete(iEntity entity) {
        User instance = (User) entity;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblUser WHERE id = ?;";
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
        List<User> instances = (List<User>) listEntities;
        boolean res = false;
        try {
            this.db.openConnection();
            String sql = "DELETE FROM tblUser WHERE id IN (";
            List<Object> lsParams = new ArrayList<>();
            for(User instance : instances){
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
            String sql = "SELECT * FROM tblUser WHERE "+ condt;    // điều kiện truy vấn
            
            ResultSet result = this.db.execQuery(sql);
            if(result != null){
                res = new ArrayList<>();
                while(result.next()){
                    User instance = new User();
                    instance.setId(result.getInt("id"));
                    instance.setFullName(result.getString("fullName"));
                    instance.setDob(result.getDate("dob"));
                    instance.setGender(result.getString("gender"));
                    instance.setAddress(result.getString("address"));
                    instance.setPosition(result.getString("position"));
                    instance.setUsername(result.getString("username"));
                    instance.setPassword(result.getString("password"));
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
            String sql = "SELECT (max(id) + 1) as id FROM tblUser;";
            ResultSet r = this.db.execQuery(sql);
            int id = 0;
            if(r.next()) id = r.getInt("id");
            sql = "ALTER TABLE tblUser auto_increment = "+ id +";";
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
