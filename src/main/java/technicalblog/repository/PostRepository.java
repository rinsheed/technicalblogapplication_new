package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPost(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p", Post.class);
        //Query query = em.createNativeQuery("SELECT * FROM posts", Post.class);
        return query.getResultList();
    }

    public Post getLatestPost(){
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, 3);
    }

}
