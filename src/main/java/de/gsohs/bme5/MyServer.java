package de.gsohs.bme5;
import de.gsohs.bme5.dao.MyEmFactory;
import io.javalin.Javalin;

public class MyServer {

    public static void main(String[] args) {
        MyEmFactory em = MyEmFactory.getInstance();
        /*em.getEntityManager().createNativeQuery("CREATE TABLE PODCAST (PODCAST_ID PRIMARY KEY NUMBER(3),TITLE VARCHAR2(10 CHAR),DESCRIPTION VARCHAR2(40 CHAR) )").executeUpdate();
        em.getEntityManager().createNativeQuery("INSERT INTO PODCAST VALUES(1,'Podcast uno','this is podcast numero uno')");*/

        Javalin javalin = Javalin.create().start(8080);
        javalin.get("/", ctx -> ctx.render("landingpage.html"));
        javalin.get("/podcast", ctx -> ctx.render("podcast.html"));
        javalin.get("/signin", ctx -> ctx.render("signin.html"));
        javalin.get("/signup", ctx -> ctx.render("signup.html"));

    }
}
