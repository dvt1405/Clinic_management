/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import entity.iEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repository.IDB;
import repository.IRepo;
import repository.MysqlDBDeploy;
import repository.UserRepoMysql;
import util.Helper;

/**
 *
 * @author MrLELOI
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkLogin method, of class UserDAO.
     */
    @Test
    public void testCheckLogin() throws SQLException {
        System.out.println("checkLogin");
        String account = "leloi";
        String password = "123456";
        
        User user = new User();
        user.setFullName("Lê Lợi 1");
        user.setGender("male");
        user.setUsername("male");
        user.setPosition("male");
        user.setPassword("male");
        
        MysqlDBDeploy db = (MysqlDBDeploy) Helper.getTransactionDB();
        IRepo repo = new UserRepoMysql(db);
        UserDAO userDAO = new UserDAO(repo);
        userDAO.add(user);
        db.getConn().rollback();
        Helper.closeTransactionDB(db);
    }
//
//    /**
//     * Test of findByAccount method, of class UserDAO.
//     */
//    @Test
//    public void testFindByAccount() {
//        System.out.println("findByAccount");
//        String account = "";
//        UserDAO instance = new UserDAO();
//        User expResult = null;
//        User result = instance.findByAccount(account);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of logout method, of class UserDAO.
//     */
//    @Test
//    public void testLogout() {
//        System.out.println("logout");
//        UserDAO instance = new UserDAO();
//        instance.logout();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of add method, of class UserDAO.
//     */
//    @Test
//    public void testAdd_iEntity() {
//        System.out.println("add");
//        iEntity entity = null;
//        UserDAO instance = new UserDAO();
//        boolean expResult = false;
//        boolean result = instance.add(entity);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of add method, of class UserDAO.
//     */
//    @Test
//    public void testAdd_List() {
//        System.out.println("add");
//        List<iEntity> entities = null;
//        UserDAO instance = new UserDAO();
//        boolean expResult = false;
//        boolean result = instance.add(entities);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modify method, of class UserDAO.
//     */
//    @Test
//    public void testModify_iEntity() {
//        System.out.println("modify");
//        iEntity entity = null;
//        UserDAO instance = new UserDAO();
//        boolean expResult = false;
//        boolean result = instance.modify(entity);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modify method, of class UserDAO.
//     */
//    @Test
//    public void testModify_List() {
//        System.out.println("modify");
//        List<iEntity> entities = null;
//        UserDAO instance = new UserDAO();
//        boolean expResult = false;
//        boolean result = instance.modify(entities);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class UserDAO.
//     */
//    @Test
//    public void testDelete_iEntity() {
//        System.out.println("delete");
//        iEntity entity = null;
//        UserDAO instance = new UserDAO();
//        boolean expResult = false;
//        boolean result = instance.delete(entity);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class UserDAO.
//     */
//    @Test
//    public void testDelete_List() {
//        System.out.println("delete");
//        List<iEntity> entities = null;
//        UserDAO instance = new UserDAO();
//        boolean expResult = false;
//        boolean result = instance.delete(entities);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findById method, of class UserDAO.
//     */
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//        int gid = 0;
//        UserDAO instance = new UserDAO();
//        iEntity expResult = null;
//        iEntity result = instance.findById(gid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of fetch method, of class UserDAO.
//     */
//    @Test
//    public void testFetch() {
//        System.out.println("fetch");
//        String condt = "";
//        UserDAO instance = new UserDAO();
//        List<iEntity> expResult = null;
//        List<iEntity> result = instance.fetch(condt);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of fetchAll method, of class UserDAO.
//     */
//    @Test
//    public void testFetchAll() {
//        System.out.println("fetchAll");
//        UserDAO instance = new UserDAO();
//        List<iEntity> expResult = null;
//        List<iEntity> result = instance.fetchAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of queryDB method, of class UserDAO.
//     */
//    @Test
//    public void testQueryDB() {
//        System.out.println("queryDB");
//        String sql = "";
//        UserDAO instance = new UserDAO();
//        ResultSet expResult = null;
//        ResultSet result = instance.queryDB(sql);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchDemo method, of class UserDAO.
//     */
//    @Test
//    public void testSearchDemo() {
//        System.out.println("searchDemo");
//        UserDAO instance = new UserDAO();
//        List<iEntity> expResult = null;
//        List<iEntity> result = instance.searchDemo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
