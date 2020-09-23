package edu.escuelaing.arep;
import com.google.gson.Gson;
import edu.escuelaing.arep.entitis.Message;
import edu.escuelaing.arep.services.LogServices;

import java.util.List;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class LogAPI
{
    static final LogServices log = new LogServices();

    public static void main( String... args )
    {
        port(getPort());
        get("hello", (req, res) -> "Hello Docker!");

        get("/messages", (req, res) -> {
            res.status(200);
            res.type("application/json");
            List<Message> messages = log.getLastTenMessages();
            if (messages == null) {
                res.status(400);
                return "Error consultando mensajes";
            }
            System.out.println(messages);
            return new Gson().toJson(messages);
        });

        post("/messages", (req, res)->{
            res.status(201);
           log.addMessage(new Gson().fromJson(req.body(), Message.class));
           return res;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
