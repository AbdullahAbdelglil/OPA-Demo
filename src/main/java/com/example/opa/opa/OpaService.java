package com.example.opa.opa;

import com.example.opa.entity.User;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpaService {
    private static HttpClient client = HttpClient.newHttpClient();
    private static String url = "http://localhost:8080/v1/data/authz/allow";

    public static boolean isAllowed(User user) {
        HttpRequest request = buildRequest(user);
        HttpResponse<String> response = sendTheRequest(request);

        assert response != null;
        JSONObject result = new JSONObject(response.body());

        return result.getBoolean("result");
    }

    private static HttpRequest buildRequest(User user) {
        String jsonBody = buildRequestBody(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        return request;
    }

    private static String buildRequestBody(User user) {
        JSONObject userJson = new JSONObject(user.toString());
        StringBuilder jsonBody = new StringBuilder();
        jsonBody.append("{ \"input\":{\"user\":");
        jsonBody.append(userJson);
        jsonBody.append("}}");

        return jsonBody.toString();
    }

    private static HttpResponse<String> sendTheRequest(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("\n--------------------------\n");
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
            System.out.println("\n--------------------------\n");

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
