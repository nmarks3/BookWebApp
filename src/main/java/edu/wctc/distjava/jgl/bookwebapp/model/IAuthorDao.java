package edu.wctc.distjava.jgl.bookwebapp.model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jlombardo
 */
public interface IAuthorDao {

     public int updateAuthor(List<Object> colValue, Object pkValue ) throws SQLException, ClassNotFoundException;
    
    public abstract int addAuthor(List<Object> colValues) throws ClassNotFoundException, SQLException;

    public abstract int removeAuthorById(Integer id) throws ClassNotFoundException, SQLException;

    public abstract List<Author> getListOfAuthors() throws SQLException, ClassNotFoundException;

}
