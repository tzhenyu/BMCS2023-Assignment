/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author zhenyu
 */
public class DatabaseClient {
    private static final String SUPABASE_URL = "https://audqlatgynfemoecamjp.supabase.co";
    private static final String SUPABASE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImF1ZHFsYXRneW5mZW1vZWNhbWpwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTQzNzg2OTIsImV4cCI6MjA2OTk1NDY5Mn0.MIFHs8mPf_SplH5qGI8aSua1EHuOtjP0QfQb1TTO0bs";
    private static final HttpClient client = HttpClient.newHttpClient();
    
    // Custom Gson instance with LocalDateTime serializer
    private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            }
        })
        .create();

    public static String readRecords(String tableName) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(SUPABASE_URL + "/rest/v1/" + tableName + "?select=*"))
            .header("apikey", SUPABASE_API_KEY)
            .header("Authorization", "Bearer " + SUPABASE_API_KEY)
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] getRecords(String tableName, Class<T> clazz) throws Exception {
        String readResult = readRecords(tableName);
        Type listType = TypeToken.getParameterized(List.class, clazz).getType();
        List<T> list = gson.fromJson(readResult, listType);
        return list.toArray((T[]) java.lang.reflect.Array.newInstance(clazz, 0));
    }

    public static <T> String insertRecords(String tableName, T[] records) throws Exception {
        String json = gson.toJson(records);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(SUPABASE_URL + "/rest/v1/" + tableName))
            .header("apikey", SUPABASE_API_KEY)
            .header("Authorization", "Bearer " + SUPABASE_API_KEY)
            .header("Content-Type", "application/json")
            .header("Prefer", "return=representation")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 201) {
            return response.body();
        } else {
            throw new Exception("Failed to insert records: HTTP " + response.statusCode() + " - " + response.body());
        }
    }

    public static String deleteRecord(String tableName, int id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(SUPABASE_URL + "/rest/v1/" + tableName + "?id=eq." + id))
            .header("apikey", SUPABASE_API_KEY)
            .header("Authorization", "Bearer " + SUPABASE_API_KEY)
            .DELETE()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static int deleteById(String tableName, String id) throws Exception {
    String encoded = URLEncoder.encode(id, StandardCharsets.UTF_8);
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(SUPABASE_URL + "/rest/v1/" + tableName + "?id=eq." + encoded))
        .header("apikey", SUPABASE_API_KEY)
        .header("Authorization", "Bearer " + SUPABASE_API_KEY)
        .DELETE()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.statusCode(); // 204 expected on success
}

    
    public static <T> String updateRecord(String tableName, int id, T record) throws Exception {
        String json = gson.toJson(record);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(SUPABASE_URL + "/rest/v1/" + tableName + "?id=eq." + id))
            .header("apikey", SUPABASE_API_KEY)
            .header("Authorization", "Bearer " + SUPABASE_API_KEY)
            .header("Content-Type", "application/json")
            .header("Prefer", "return=representation")
            .method("PATCH", HttpRequest.BodyPublishers.ofString(json))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Failed to update record: HTTP " + response.statusCode() + " - " + response.body());
        }
    }

    public static <T> String updateUserRecord(String tableName, String userId, T record) throws Exception {
        String json = gson.toJson(record);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(SUPABASE_URL + "/rest/v1/" + tableName + "?userId=eq." + userId))
            .header("apikey", SUPABASE_API_KEY)
            .header("Authorization", "Bearer " + SUPABASE_API_KEY)
            .header("Content-Type", "application/json")
            .header("Prefer", "return=representation")
            .method("PATCH", HttpRequest.BodyPublishers.ofString(json))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Failed to update record: HTTP " + response.statusCode() + " - " + response.body());
        }
    }
    
    public static <T> String updateRecord(String tableName, String id, T record)throws Exception{
        String json = gson.toJson(record);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(SUPABASE_URL + "/rest/v1/" + tableName + "?id=eq." + id))
            .header("apikey", SUPABASE_API_KEY)
            .header("Authorization", "Bearer " + SUPABASE_API_KEY)
            .header("Content-Type", "application/json")
            .header("Prefer", "return=representation")
            .method("PATCH", HttpRequest.BodyPublishers.ofString(json))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Failed to update record: HTTP " + response.statusCode() + " - " + response.body());
        }
    }
    
// Gets a single record by id. Returns null if not found.
public static <T> T getRecordById(String tableName, String id, Class<T> clazz) throws Exception {
    // encode ID (handles UUIDs or special chars)
    String encoded = URLEncoder.encode(id, StandardCharsets.UTF_8);

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(SUPABASE_URL + "/rest/v1/" + tableName + "?id=eq." + encoded + "&select=*"))
        .header("apikey", SUPABASE_API_KEY)
        .header("Authorization", "Bearer " + SUPABASE_API_KEY)
        .GET()
        .build();

    // debug (optional) - uncomment if you want to see request/response
    // System.out.println("DB GET URI: " + request.uri());

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    // debug (optional)
    // System.out.println("DB GET STATUS: " + response.statusCode());
    // System.out.println("DB GET BODY: " + response.body());

    if (response.statusCode() >= 400) {
        throw new RuntimeException("Supabase error: " + response.statusCode() + " - " + response.body());
    }

    String body = response.body();
    Type arrayType = TypeToken.getArray(clazz).getType();
    T[] array = gson.fromJson(body, arrayType);

    if (array == null || array.length == 0) return null;
    return array[0];
}
    public static JsonObject getRecordByIdAsJson(String table, String id) throws Exception {
    String encoded = URLEncoder.encode(id, StandardCharsets.UTF_8);
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(SUPABASE_URL + "/rest/v1/" + table + "?id=eq." + encoded + "&select=*"))
        .header("apikey", SUPABASE_API_KEY)
        .header("Authorization", "Bearer " + SUPABASE_API_KEY)
        .GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    JsonArray arr = JsonParser.parseString(response.body()).getAsJsonArray();
    return arr.size() > 0 ? arr.get(0).getAsJsonObject() : null;
}

    // In DatabaseClient.java - Replace the existing updateRentalStatus method
/**
 * Updates the status of a rental record in the database by ID
 * @param rentalId The ID of the rental to update
 * @param newStatus The new status to set (e.g., "AVAILABLE", "PENDING", "CONFIRMED", "COMPLETED")
 * @return The response body from the update operation
 * @throws Exception If the update fails
 */
public static String updateRentalStatus(String rentalId, String newStatus) throws Exception {
    // Create a JSON object with just the status field
    JsonObject statusUpdate = new JsonObject();
    statusUpdate.addProperty("status", newStatus);
    
    // Use the existing updateRecord method to perform the update
    return updateRecord("rentals", rentalId, statusUpdate);
}
}
