package edu.wctc.distjava.jgl.bookwebapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless

// service class that talks to AuthorDao and MySqlDataAccess
public class AuthorService implements Serializable {

            Date date = new Date();

    
    @PersistenceContext(unitName = "book_PU")
    private EntityManager em;

    public AuthorService() {
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    // retrives a list of the author table
    public final List<Author> getAuthorList() throws Exception {

        List<Author> authorList = new ArrayList<>();
        String jpql = "select a from Author a";
        TypedQuery<Author> q = getEm().createQuery(jpql, Author.class);
        q.setMaxResults(500); // optional
        authorList = q.getResultList();
        return authorList;
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
