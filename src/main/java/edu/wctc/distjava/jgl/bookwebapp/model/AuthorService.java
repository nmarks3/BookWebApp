package edu.wctc.distjava.jgl.bookwebapp.model;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

// service class that talks to AuthorDao and MySqlDataAccess
public final class AuthorService {
    private IAuthorDao authorDao;
    
    public AuthorService(IAuthorDao authorDao) {
        setAuthorDao(authorDao);
    }
    
    // removes the author by the authorID
    public final int removeAuthorById(String id)
            throws ClassNotFoundException, SQLException, NumberFormatException {     
        AuthorValidation.valID(id);      
        Integer value = Integer.parseInt(id);  
        return authorDao.removeAuthorById(value);
    }
    
    // adds an author based on the name value
    public final int addAuthor(List<Object> colValues) throws SQLException, ClassNotFoundException {
        AuthorValidation.valColValues(colValues);
        return authorDao.addAuthor(colValues);
    }
    
    // updates the author based on the ID and sets the name value
    public final int updateAuthorById(List<Object> colValues, int id) throws SQLException, ClassNotFoundException {        
        AuthorValidation.valColValues(colValues);
        AuthorValidation.valID(id);
        return authorDao.updateAuthor(colValues, id);
    }
    
    // retrives a list of the author table
    public final List<Author> getAuthorList() throws SQLException, ClassNotFoundException { 
        return authorDao.getListOfAuthors();
    }
   
    // retrives the AuthorDao object
    public final IAuthorDao getAuthorDao() {
        return authorDao;
    }
 
    // setst he AuthorDao object
    public final void setAuthorDao(IAuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    
    
    ///////////////////////////
    //// notes and misc
    ////////////////////////////
    
    
    
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        
        IAuthorDao dao = new AuthorDao(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/book",
                "root", "root",
                new MySqlDataAccess()
        );
        
        AuthorService authorService
                = new AuthorService(dao);

        //authorService.addAuthor(Arrays.asList("ralph the thrid", "2012-03-13"));
        authorService.updateAuthorById(Arrays.asList("jakob the great", "2013-12-12"), 9);
        //authorService.removeAuthorById("53");

        List<Author> list = authorService.getAuthorList();
        
        for (Author a : list) {
            System.out.println(a.getAuthorId() + ", "
                    + a.getAuthorName() + ", " + a.getDateAdded() + "\n");
        }
    }
}
