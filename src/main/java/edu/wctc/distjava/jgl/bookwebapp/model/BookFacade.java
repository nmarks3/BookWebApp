/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.jgl.bookwebapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nolan
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> {

    @PersistenceContext(unitName = "book_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEm() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }
    
    // student example not important
    public void updateBookIsbn(String bookId, String isbn) {
        Book book = this.find(new Integer(bookId));
        book.setIsbn(isbn);
        this.edit(book);
    }
    
    // NOT NOT NOT NOT NOT NOT WORKING
    // NOT NOT NOT NOT NOT NOT WORKING
    // //////////////////////////////////////////////////////////////
    // ATTN CONTROLLER - if its a new record bookId must be NULL
    public void addOrUpdateNewBook(String bookId, String title, String isbn, String authorId) {
        Book book = null;        
        if (bookId == null || bookId.isEmpty()) {
            // must be new record
            book = new Book();
        } else {
            // must be updated record
            book = new Book(new Integer(bookId));
        }      
        book.setTitle(title);
        book.setIsbn(isbn);
        Author author = getEm().find(Author.class, new Integer(authorId));
        book.setAuthorId(author);
       // getEm().persist(book);
        getEm().merge(book);
    }
    ////////////////////////////////////////////////////////////////////
    
        public void createBook(String title, String isbn, String authorId) {
        Query query = getEm().createNativeQuery("INSERT INTO Book (title, isbn, author_id) " + " VALUES(?,?,?)");
        query.setParameter(1, title);
        query.setParameter(2, isbn);
        query.setParameter(3, authorId);
        query.executeUpdate();
    }
        
        public void deleteBook(String id) {
            Integer value = Integer.parseInt(id);
            getEm().createQuery("delete from Book b where b.bookId=:id")
                .setParameter("id", value)
                .executeUpdate();
        }
        
        public void updateBookById(String id, String title, String isbn, String authorId) {
        Book book = getEm().find(Book.class, new Integer(id));
            book.setTitle(title);
            book.setIsbn(isbn);
            book.setAuthorId(getEm().find(Author.class, new Integer(authorId)));
                getEm().merge(book);
    }
        
        public void deleteBookById(String id) {
            Book book = new Book(new Integer(id));
            this.remove(book);
        }

}
