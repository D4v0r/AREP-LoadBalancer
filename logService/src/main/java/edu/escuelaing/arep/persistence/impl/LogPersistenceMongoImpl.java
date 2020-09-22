package edu.escuelaing.arep.persistence.impl;

import edu.escuelaing.arep.entitis.Message;
import edu.escuelaing.arep.persistence.LogPersistence;
import edu.escuelaing.arep.persistence.impl.mongo.DBConnection;

import java.util.ArrayList;

public class LogPersistenceMongoImpl implements LogPersistence {
    DBConnection dbConnection = new DBConnection();


    @Override
    public ArrayList<Message> readMessages() {
        return dbConnection.loadMessages();
    }

    @Override
    public void insertMessage(Message message) {
        dbConnection.addMessage(message);
    }
}
