package de.gsohs.bme5;
import de.gsohs.bme5.dao.MyEmFactory;
import de.gsohs.bme5.model.Podcast;
import io.javalin.Javalin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class MyServer {

    public static void main(String[] args) {
        MyEmFactory emf = MyEmFactory.getInstance();
        EntityManager em = emf.getEntityManager();
        em.getTransaction().begin();
        Podcast pd = new Podcast();
        //pd.setPodcast_id((long) 1);
        pd.setTitle("uno");
        pd.setDescription("podcast");
        em.merge(pd);
        em.getTransaction().commit();
        em.close();
        Javalin javalin = Javalin.create().start(8080);
        javalin.get("/", ctx -> {
            /*Query q = em.createQuery("select p from Podcast p order by p.podcast_id asc");
            return (List<Podcast>) q.getResultList();*/
            //return em.createQuery("SELECT a FROM Podcast a", Podcast.class).getResultList();
            //ctx.render("landingpage.html",Map.of("podcasts",new String[] {"apples","bananas","peaches"}));
        });
        javalin.get("/podcast", ctx -> ctx.render("podcast.html"));
        javalin.get("/signin", ctx -> ctx.render("signin.html"));
        javalin.get("/signup", ctx -> ctx.render("signup.html"));
    }
}
