package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by user on 7/7/2016.
 */


public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumns() {
        List<ColumnInfo> columnList = EntityUtils.getColumns(Department.class);
        assertEquals("Size should be 11", columnList.size(), 11);
    }

    @Test
    public void testCastFromSqlTypeMethod(){
        Object obj = EntityUtils.castFromSqlType(2, Column.class);
        assert (obj instanceof Integer);
    }

    @Test
    public void testGetFieldByAnnotation(){
        List<Field> listNew = EntityUtils.getFieldsByAnnotation(Location.class, Column.class);
        assertEquals("Size should be 3", listNew.size(), 3);
    }

    @Test
    public void testSetSqlMethod() throws IllegalAccessException {
        Object obj = EntityUtils.getSqlValue(new ColumnInfo());
        assert (obj instanceof Field);
    }

}
