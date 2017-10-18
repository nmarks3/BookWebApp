/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.jgl.bookwebapp.model;

import java.util.List;

/**
 *
 * @author Nolan
 */
public class AuthorValidation {

    // validate the Database Connection
    public static final void valConnection(String driverClass,
            String url, String userName, String password) throws IllegalArgumentException {
        // validate Driver for null or empty
        if (driverClass == null || driverClass.length() < 1) {
            throw new IllegalArgumentException("Driver cannot be empty");
        } // validate URL for null or empty 
        else if (url == null || url.length() < 1) {
            throw new IllegalArgumentException("URL cannot be empty");
        } // validate userName for null or empty 
        else if (userName == null || userName.length() < 1) {
            throw new IllegalArgumentException("User Name cannot be empty");
        } // validate password for null or empty 
        else if (password == null || password.length() < 1) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }

    // validate tablename for NULL or empty values
    public static final void valTableName(String tableName) throws IllegalArgumentException {
        if (tableName == null || tableName.length() < 1) {
            throw new IllegalArgumentException("Table Name Invalid");
        }
    }

    // validate the Name of the Columns
    public static final void valColNames(List<String> colNames) throws IllegalArgumentException {
        if (colNames == null || colNames.size() < 1) {
            throw new IllegalArgumentException("Column Name Invalid");
        }
    }

    // validate colValues or NULL or empty values
    public static final void valColValues(List<Object> colValues) throws IllegalArgumentException {
        if (colValues == null || colValues.size() < 1) {
            throw new IllegalArgumentException("Column Value Data Invalid");
        }
    }

    // validate the amount of columns and values match
    public static final void valColMatch(List<String> colNames, List<Object> colValues) throws IllegalArgumentException{
        if (colNames.size() != colValues.size()) {
            throw new IllegalArgumentException("Invalid Data");
        }
    }

    // validate the PRIMARY KEY COLUMN for NULL or EMPTY VALUE
    public static final void valPkColName(String pkColName) throws IllegalArgumentException {
        if (pkColName == null || pkColName.length() < 1) {
            throw new IllegalArgumentException("PK Column Name Invalid");
        }
    }
    
    // validate the PRIMARY KEY VALUE for NULL
    public static final void valPkValue(Object pkValue) throws IllegalArgumentException {
        if (pkValue == null) {
            throw new IllegalArgumentException("PK Value Invalid");
        }
    }
    
    // validate the MaxRecords. Cannot be less than zero
    public static final void valMaxRecords(int maxRecords) throws IllegalArgumentException {
        if (maxRecords < 0) {
            throw new IllegalArgumentException("Invalid Max Records Value");
        }
    }
    
    // validate the ID for NULL or less than zero
    public static final void valID(Object id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("ID must be a Integer greater than 0");
        }
    }
}
