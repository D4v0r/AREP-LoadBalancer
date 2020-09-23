package edu.escuelaing.arep;

import edu.escuelaing.arep.client.HttpClient;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class WebApp
{
    public static void main( String... args )
    {
        HttpClient httpClient = new HttpClient();
        port(getPort());
        staticFileLocation("/static");
        get("/", (req, res) -> {
            res.redirect("/index.tml");
            res.status(200);
            return "";
        });

        get("/messages", (req, res) ->{
            httpClient.roundRobin();
            return httpClient.getMessages("/messages");
        });
        post("/messages", (req, res) -> {
            httpClient.roundRobin();
            httpClient.postMessages(req.body(), "/messages");
            return "";
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
