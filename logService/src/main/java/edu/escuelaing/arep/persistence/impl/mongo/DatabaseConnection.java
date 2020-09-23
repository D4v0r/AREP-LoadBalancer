package edu.escuelaing.arep.persistence.impl.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.escuelaing.arep.entitis.Message;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseConnection{

    MongoClient mongoClient;
    MongoClientURI uri;

    public DatabaseConnection() {

        uri = new MongoClientURI(
                "mongodb://d4v0r:12345@arep-logdb:27017/?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=logdb" +
                        "&authMechanism=SCRAM-SHA-1&3t.uriVersion=3");
        mongoClient = new MongoClient(uri);
    }

    public List<Message> loadMessages(){
        MongoDatabase db = mongoClient.getDatabase("logdb");
        MongoCollection<Document> logs = db.getCollection("logs");
        List<Document> documents = new ArrayList<>();
        logs.find().into(documents);
        return documents.stream().map( document -> new Message(document.get("content").toString(), document.get("date").toString())).collect(Collectors.toList());
    }

    public void addMessage(Message message){
        MongoDatabase db = mongoClient.getDatabase("logdb");
        MongoCollection<Document> logs = db.getCollection("logs");
        Document document = new Document();
        document.put("content", message.getContent());
        document.put("date", new Date());
        logs.insertOne(document);

    }
}
