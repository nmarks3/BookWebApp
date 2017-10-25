package edu.wctc.distjava.jgl.bookwebapp.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jlombardo
 */
public interface DataAccess {
    
    public abstract int createRecord(String tableName, List<String> colNames, 
            List<Object> colValues) throws ClassNotFoundException, SQLException ;

public int updateRecord(String tableName, List<String> colNames, List<Object> colValues, String pkColName, Object pkValue) throws SQLException;    
    void closeConnection() throws SQLException;

    
    public int deleteRecordById(String tableName, String pkColName, 
            Object pkValue) throws ClassNotFoundException, 
            SQLException;
    
    List<Map<String, Object>> getAllRecords(String tableName, int maxRecords) throws SQLException, ClassNotFoundException;

    public abstract void openConnection(String driverClass, String url, String userName, String password) 
            throws ClassNotFoundException, SQLException;

    
}
