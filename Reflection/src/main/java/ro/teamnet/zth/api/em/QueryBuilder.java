package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 7/7/2016.
 */
public class QueryBuilder {

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition>  conditions;

    public QueryBuilder addCondition(Condition condition){
        conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName){
        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns){
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType){
        this.queryType = queryType;
        return this;
    }

    private String createSelectQuery(){
        StringBuilder sb = new StringBuilder();
        return (sb.append("SELECT * FROM DEPARTMENTS").toString());
    }

    private String createDeleteQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM DEPARTMENTS");
    }

    private String createUpdateQuery(){

    }

    private String createInsertQuery(){

    }

    public String getValueForQuey(Object value){

       if (value.getClass().equals(String.class)){
           return "'" + value + "'";
       } else if(value.getClass().equals(Date.class)){
           DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
           return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";
       }

        return "value";
    }


}
