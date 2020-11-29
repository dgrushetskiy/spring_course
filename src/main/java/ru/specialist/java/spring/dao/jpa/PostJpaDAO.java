package ru.specialist.java.spring.dao.jpa;

import org.springframework.stereotype.Repository;
import ru.specialist.java.spring.dao.AbstractDAO;
import ru.specialist.java.spring.entity.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostJpaDAO implements AbstractDAO<Post> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Post post) {
        em.persist(post);
    }

    @Override
    public List<Post> getAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    @Override
    public Post getById(long id) {
        return em.find(Post.class, id);
    }

    @Override
    public void update(long id, Post post) {
        post.setId(id);
        em.merge(post);
    }

    @Override
    public void delete(long id) {
        Post post = em.find(Post.class, id);
        em.remove(post);
    }
}
