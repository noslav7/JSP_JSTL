package com.example.dockertomcat.service;

import com.example.dockertomcat.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UserService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient client = HttpClient.newHttpClient();

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String USERS_URL = BASE_URL + "/users";
    public static final String POSTS_URL = BASE_URL + "/posts";

    public List<User> getUsers() throws IOException, InterruptedException {
        return getUsersFromResponse(client.send(HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString()));
    }

    private List<User> getUsersFromResponse(HttpResponse<String> response) throws IOException {
        return List.of(objectMapper.readValue(response.body(), User[].class));
    }
}
