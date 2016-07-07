package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 7/7/2016.
 */
public class EntityUtils {

    private EntityUtils() {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity){

       Table tabAnn = (Table) entity.getAnnotation(Table.class);
        if (tabAnn != null){
            return tabAnn.name();
        } else {
            return entity.getSimpleName();
        }
    }

    public static List<ColumnInfo> getColumns(Class entity){

        Field[] declaredFields = entity.getDeclaredFields();

        List<ColumnInfo> columnInfos = new LinkedList<ColumnInfo>();

        for (Field field : declaredFields) {

            ColumnInfo columnInfo = new ColumnInfo();

            columnInfo.setColumnName(field.getName());
            columnInfo.setDbName(field.getName());
            columnInfo.setColumnType(field.getType());

            if(field.getAnnotation(Id.class) != null){
                columnInfo.setId(true);
            } else if(field.getAnnotation(Column.class) != null){

                columnInfo.setId(false);
                columnInfo.setValue(field.getName());
                columnInfo.setColumnType(field.getType());
                columnInfo.setDbName(field.getName());
                columnInfo.setColumnName(field.getName());

                columnInfos.add(columnInfo);
            }
        }

        return columnInfos;
    }


    public static Object castFromSqlType(Object value, Class wantedType){

        if (value.getClass().equals(BigDecimal.class) && wantedType.equals(Integer.class)){
            return (Integer) value;
        }

        if (value.getClass().equals(BigDecimal.class) && wantedType.equals(Long.class)){
            return (Long) value;
        }

        if (value.getClass().equals(BigDecimal.class) && wantedType.equals(Float.class)){
            return (Float) value;
        }

        if (value.getClass().equals(BigDecimal.class) && wantedType.equals(Double.class)){
            return (Double) value;
        }

        if (!value.getClass().equals(BigDecimal.class)){
            return value;
        }

        return value;
    }

    public static List<Field> getFieldsByAnnotation(Class clazz, Class annotation){

        Field[] declaredFields = clazz.getDeclaredFields();

        List<Field> fieldsList = new LinkedList<Field>();

        for (Field field : declaredFields) {

            if(field.getAnnotation(annotation) != null){
                fieldsList.add(field);
            }
        }

        return fieldsList;

    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {

        if(object.getClass().getAnnotation(Table.class) != null){

            List<Field> fieldsList = getFieldsByAnnotation(object.getClass(), Id.class);
            Field id = fieldsList.get(0);
            id.setAccessible(true);

            return  id.get(object);
        } else {
            return object;
        }
    }

}
