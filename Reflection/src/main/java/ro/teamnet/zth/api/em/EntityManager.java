package ro.teamnet.zth.api.em;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 7/8/2016.
 */
public interface EntityManager {

    <T> Object insert(T entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException;
    Long getNextIdVal(String tableName, String columnIdName) throws SQLException, ClassNotFoundException;
    <T> T findById(Class<T> entityClass, Long id);
    <T> List<T> findAll(Class<T> entityClass);
}
