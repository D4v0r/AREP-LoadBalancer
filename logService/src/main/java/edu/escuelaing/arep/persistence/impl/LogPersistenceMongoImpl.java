package edu.escuelaing.arep.persistence.impl;

import edu.escuelaing.arep.entitis.Message;
import edu.escuelaing.arep.persistence.LogPersistence;
import edu.escuelaing.arep.persistence.impl.mongo.DatabaseConnection;

import java.util.List;

public class LogPersistenceMongoImpl implements LogPersistence {
    DatabaseConnection dbConnection = new DatabaseConnection();


    @Override
    public List<Message> readMessages() {
        return dbConnection.loadMessages();
    }

    @Override
    public void insertMessage(Message message) {
        dbConnection.addMessage(message);
    }
}
