package edu.escuelaing.arep.persistence;

import edu.escuelaing.arep.entitis.Message;

import java.util.ArrayList;
import java.util.List;

public interface LogPersistence {

    List<Message> readMessages();
    void insertMessage(Message message);

}
