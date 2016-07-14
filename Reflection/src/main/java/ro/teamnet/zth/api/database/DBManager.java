package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by user on 7/8/2016.
 */
public class DBManager {

    private DBManager() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT;

    private static void registerDriver() throws ClassNotFoundException {
        Class.forName(DBProperties.DRIVER_CLASS);
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        registerDriver();
        return DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
    }

    public static int checkConnection(Connection connection){
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = null;
            String SQL = "SELECT 1 FROM DUAL";
            if (resultSet.next()){
                stmt.executeQuery(SQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
