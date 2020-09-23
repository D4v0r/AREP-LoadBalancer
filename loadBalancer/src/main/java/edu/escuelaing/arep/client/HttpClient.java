package edu.escuelaing.arep.client;

import okhttp3.*;

import java.io.IOException;

public class HttpClient {

    private OkHttpClient httpClient;
    private final String host = "http://172.17.0.1";
    //private final String host = "http://127.0.0.1";
    private final String[] ports = {":8085", ":8086", ":8087"};
    private int serverNumber;

    public HttpClient(){
        httpClient = new OkHttpClient();
        serverNumber = 0;
    }

    public String getMessages(String path) throws IOException {
        Request request = new Request.Builder().url(host + ports[serverNumber] + path).get().build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public String postMessages(String message, String path) throws IOException {
        System.out.println(message);
        RequestBody body = RequestBody.create(message, MediaType.parse("application/json; charset=utf-8fhv"));
        Request request = new Request.Builder().url(host + ports[serverNumber] + path).post(body).build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();

    }

    public void roundRobin(){
        serverNumber = (serverNumber + 1) % ports.length;
    }


}
