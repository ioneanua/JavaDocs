package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 7/8/2016.
 */
public class EntityManagerImpl implements EntityManager{

    public <T> Object insert(T entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Connection connection = DBManager.getConnection();
        Statement statement = connection.createStatement();
        String tableName = null;
        tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> listColum = new LinkedList<ColumnInfo>();
        listColum = EntityUtils.getColumns(entity.getClass());

        for (ColumnInfo columnInfo : listColum) {
            if (columnInfo.isId() == true) {
                columnInfo.setValue(getNextIdVal(tableName, columnInfo.getColumnName()));
            } else {
                Field field = entity.getClass().getDeclaredField(columnInfo.getColumnName());
                field.setAccessible(true);
                columnInfo.setValue(field.get(entity));
            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setQueryType(QueryType.INSERT);
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(listColum);

        queryBuilder.createQuery();
        Statement stmtObj = connection.createStatement();
        stmtObj.executeQuery(queryBuilder.createQuery());

        //return findById(entity, );
        return null;
    }


    public Long getNextIdVal(String tableName, String columnIdName) throws SQLException, ClassNotFoundException {
        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();
        String SQL = "SELECT MAX(columnIdName) AS VALUE FROM tableName GROUP BY MAX(columnIdName)";
        ResultSet res = stmt.executeQuery(SQL);
        Long VALUE = null;
        while (res.next()) {
            VALUE = res.getLong("VALUE");
            System.out.println(VALUE + "\t");
        }

        return VALUE;
    }

    public <T> T findById(Class<T> entityClass, Long id){
        return null;
    }
    public <T> List<T> findAll(Class<T> entityClass){
        return null;
    }

}
