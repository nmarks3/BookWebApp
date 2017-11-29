/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.jgl.bookwebapp.model;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nolan
 */
@Stateless
public class AuthorFacade extends AbstractFacade<Author> {
Date date = new Date();

    @PersistenceContext(unitName = "book_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEm() {
        return em;
    }

    public AuthorFacade() {
        super(Author.class);
    }
    
    public void createAuthor(String name) {
        Query query = getEm().createNativeQuery("INSERT INTO Author (author_name, date_added) " + " VALUES(?,?)");
        query.setParameter(1, name);
        query.setParameter(2, date);
        query.executeUpdate();
    }
    
    public void updateAuthorById(String id, String name) {
        Author author = getEm().find(Author.class, new Integer(id));
                author.setAuthorName(name);
                author.setDateAdded(date);
                getEm().merge(author);
    }
        public int deleteAuthorById(String id) throws Exception {
        Integer value = Integer.parseInt(id);
        int recsDeleted = getEm().createQuery("delete from Author a where a.authorId=:id")
                .setParameter("id", value)
                .executeUpdate();
        return recsDeleted;
    }
    
}
