package edu.wctc.distjava.jgl.bookwebapp.model;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class AuthorDao implements IAuthorDao {
    Date date = new Date();
    
    private String driverClass;
    private String url;
    private String userName;
    private String password;
    private DataAccess db;
    private final String AUTHOR_TBL = "author";
    private final String AUTHOR_PK = "author_id";
    private final String AUTHOR_NAME = "author_name";
    private final String DATE_ADDED = "date_added";

    // database connection information
    public AuthorDao(String driverClass, String url, String userName, String password, DataAccess db) {
        AuthorValidation.valConnection(driverClass, url, userName, password);
        setDriverClass(driverClass);
        setUrl(url);
        setUserName(userName);
        setPassword(password);
        setDb(db);
    }
    
    // adds author to database
    @Override
    public final int addAuthor(List<Object> colValues) throws ClassNotFoundException, SQLException {
         db.openConnection(driverClass, url, userName, password);
         AuthorValidation.valColValues(colValues);
         int authorsAdded = db.createRecord(AUTHOR_TBL,Arrays.asList(AUTHOR_NAME, DATE_ADDED), colValues);
         db.closeConnection();
         
         return authorsAdded;
    }
    
    // retrives author by the author ID
    @Override
    public final int removeAuthorById(Integer id) throws ClassNotFoundException, SQLException {
        AuthorValidation.valID(id);
        
        db.openConnection(driverClass, url, userName, password);
        
        int recsDeleted = db.deleteRecordById(AUTHOR_TBL, AUTHOR_PK, id);
        
        db.closeConnection();
        
        return recsDeleted;
    }
    
    // updates an author by the value of the primary key (ID)
    @Override
    public final int updateAuthor(List<Object> colValue, Object pkValue ) throws SQLException, ClassNotFoundException{
        AuthorValidation.valColValues(colValue);
        AuthorValidation.valPkValue(pkValue);
        db.openConnection(driverClass, url, userName, password);
        int recsUpdated = db.updateRecord(AUTHOR_TBL, Arrays.asList(AUTHOR_NAME, DATE_ADDED), colValue, AUTHOR_PK, pkValue);
        db.closeConnection();
        return recsUpdated;
    }
    
    
    // retrieves a list of the authors
    @Override
    public final List<Author> getListOfAuthors() 
            throws SQLException, ClassNotFoundException {
        
        db.openConnection(driverClass, url, userName, password);
        
        List<Author> list = new Vector<>();
        List<Map<String,Object>> rawData = 
                db.getAllRecords(AUTHOR_TBL, 0);
        
        Author author = null;
        
        for(Map<String,Object> rec : rawData) {
              author = new Author(); 
              
              Object objRecId = rec.get(AUTHOR_PK);
              Integer recId = objRecId == null ? 
                      0 : Integer.parseInt(objRecId.toString());
              author.setAuthorId(recId);
             
              Object objName = rec.get("author_name");
              String authorName = objName == null ? "" : objName.toString();
              author.setAuthorName(authorName);
              
              Object objRecAdded = rec.get("date_added");
              Date recAdded = objRecAdded == null ? null : (Date)objRecAdded;
              author.setDateAdded(recAdded);
              
              list.add(author); 
        }
         
        db.closeConnection();
        
        return list;
    }
    
    // retrives the dataAccess variable
    public DataAccess getDb() {
        return db;
    }

    // sets the dataAccess variable
    public final void setDb(DataAccess db) {
        this.db = db;
    }
   
    // retrieves the DB Driver
    public final String getDriverClass() {
        return driverClass;
    }

    // sets the DB Driver
    public final void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    // retrieves the DB URL
    public final String getUrl() {
        return url;
    }

    // sets the DB URL
    public final void setUrl(String url) {
        this.url = url;
    }

    // retrieves the DB User Name
    public final String getUserName() {
        return userName;
    }

    // sets the DB User Name
    public final void setUserName(String userName) {
        this.userName = userName;
    }

    // retrieves the DB Password
    public final String getPassword() {
        return password;
    }

    // sets the DB Password
    public final void setPassword(String password) {
        this.password = password;
    }
    
    
    
    ////////////////////////////////
    ////////// notes and misc
    ////////////////////////////////
    
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        IAuthorDao dao = new AuthorDao(
            "com.mysql.jdbc.Driver",
            "jdbc:mysql://localhost:3306/book",
            "root", "root",
            new MySqlDataAccess()
        );
        
       // int recsDeleted = dao.removeAuthorById(20);
   dao.addAuthor(Arrays.asList("jes r j ", "2030-02-11"));
       // dao.updateAuthor(Arrays.asList("Brian Thomas", "2017-09-23"), 7);
        List<Author> list = dao.getListOfAuthors();
        
        for(Author a: list) {
            System.out.println(a.getAuthorId() + ", "
                + a.getAuthorName() + ", " + a.getDateAdded() + "\n");
        }
    }
    
}
