package edu.escuelaing.arep.entitis;

public class Message {

    private String content;
    private String date;

    public Message(String content, String date){
        this.content = content;
        this.date = date;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
