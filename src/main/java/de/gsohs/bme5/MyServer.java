package de.gsohs.bme5;
import io.javalin.Javalin;

public class MyServer {
    public static void main(String[] args) {
        Javalin javalin = Javalin.create().start(8080);
        javalin.get("/", ctx -> ctx.render("landingpage.html"));
        javalin.get("/podcast", ctx -> ctx.render("podcast.html"));
        javalin.get("/signin", ctx -> ctx.render("signin.html"));
        javalin.get("/signup", ctx -> ctx.render("signup.html"));

    }
}
