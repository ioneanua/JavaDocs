package ro.teamnet.zth.api.database;

import org.junit.*;
import java.sql.*;

/**
 * Created by user on 7/8/2016.
 */
public class DBManagerTest {

    @Test
    public void testGetConnection() {
        try {
            Connection conn = DBManager.getConnection();
            Assert.assertNotEquals("Connection should not be null!", conn, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCheckConnection() {
        try {
            int value = DBManager.checkConnection(DBManager.getConnection());
            Assert.assertEquals("Value should be 1!", value, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}