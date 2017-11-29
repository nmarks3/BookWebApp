/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.jgl.bookwebapp.model;

import edu.wctc.distjava.jgl.bookwebapp.repository.AuthorRepository;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nolan
 */
@Service
public class AuthorFacade {

    @Autowired
    private AuthorRepository authorRepo;

    public AuthorFacade() {
    }
    
    // spring example
    public List<Author> findAll() {
        return authorRepo.findAll();
    }
    
    // another spring example
    public Author findById(String id){
        return authorRepo.findOne(Integer.parseInt(id));
    }
    
    // spring example - save a record
    public void addAuthor(String authorName){
        Date dateAdded = new Date();
        Author author = new Author();
        author.setAuthorName(authorName);
        author.setDateAdded(dateAdded);
        
        authorRepo.save(author);
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