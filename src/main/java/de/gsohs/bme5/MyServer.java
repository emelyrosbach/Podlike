package de.gsohs.bme5;
import de.gsohs.bme5.dao.MyEmFactory;
import de.gsohs.bme5.model.Podcast;
import io.javalin.Javalin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class MyServer {

    public static void main(String[] args) {
        MyEmFactory emf = MyEmFactory.getInstance();
        EntityManager em = emf.getEntityManager();
        /*em.getTransaction().begin();
        Podcast pd = new Podcast();
        pd.setTitle("troi");
        pd.setDescription("podcast");
        em.merge(pd);
        em.getTransaction().commit();
        em.close();*/
        Javalin javalin = Javalin.create().start(8080);
        javalin.get("/", ctx -> {
            Query q = em.createQuery("select p from Podcast p order by p.podcast_id asc");
            List <Podcast> result = (List<Podcast>) q.getResultList();
            ctx.render("landingpage.html", Map.of("podcasts", result));
        });
        javalin.get("/podcast/:id", ctx -> {
            Long podcastId = Long.parseLong(ctx.pathParam("id"));
            Query q = em.createQuery("select p from Podcast p where p.podcast_id = :podcastId");
            Podcast result = (Podcast) q.setParameter("podcastId", podcastId).getSingleResult();
            ctx.render("podcast.html", Map.of("podcast", result));
        });
        javalin.get("/signin", ctx -> ctx.render("signin.html"));
        javalin.get("/signup", ctx -> ctx.render("signup.html"));
    }
}
