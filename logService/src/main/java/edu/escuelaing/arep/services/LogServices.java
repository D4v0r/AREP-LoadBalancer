package edu.escuelaing.arep.services;

import edu.escuelaing.arep.entitis.Message;
import edu.escuelaing.arep.persistence.LogPersistence;
import edu.escuelaing.arep.persistence.impl.LogPersistenceMongoImpl;

import java.util.ArrayList;
import java.util.List;

public class LogServices {
    LogPersistence persistence = new LogPersistenceMongoImpl();

    public LogServices(){

    }

    public List<Message> getLastTenMessages(){
        List<Message> messages = persistence.readMessages();
        //return new ArrayList<>(messages.subList(messages.size() - 11, messages.size()));
        return messages;
    }

    public void addMessage(Message message){
        persistence.insertMessage(message);
    }
}
