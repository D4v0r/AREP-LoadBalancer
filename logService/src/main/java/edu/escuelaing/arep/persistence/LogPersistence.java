package edu.escuelaing.arep.persistence;

import edu.escuelaing.arep.entitis.Message;

import java.util.ArrayList;

public interface LogPersistence {

    ArrayList<Message> readMessages();
    void insertMessage(Message message);

}
