package edu.escuelaing.arep.persistence.impl.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.escuelaing.arep.entitis.Message;
import org.bson.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class DBConnection  {
    MongoClient mongoClient;
    MongoClientURI uri;


    public DBConnection(){
        uri = new MongoClientURI("mongodb://d4v0r:12345@127.0.0.1:27017/?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=logdb&authMechanism=SCRAM-SHA-256&3t.uriVersion=3");
        mongoClient = new MongoClient(uri);
    }

    public MongoCollection<Document> getCollection(String name){
         MongoDatabase db = mongoClient.getDatabase("logdb");
        return db.getCollection(name);
    }


    public ArrayList<Message> loadMessages() {
        MongoDatabase db = mongoClient.getDatabase("logdb");
        MongoCollection<Document> collection = db.getCollection("log");
        System.out.println(collection.find().first().toString());
        ArrayList<Document> documents = new ArrayList<>();
        collection.find().into(documents);
        System.out.println("HOLA");
        return documents.stream().map( doc -> new Message(doc.get("content").toString(), doc.get("date").toString())).collect(Collectors.toCollection(ArrayList::new));
    }


    public void addMessage(Message message) {
        Document document =new Document();
        document.put("content", message.getContent());
        document.put("date", LocalDate.now().toString());
        getCollection("log").insertOne(document);
    }


}
