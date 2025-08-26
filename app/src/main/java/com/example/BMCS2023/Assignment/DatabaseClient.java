/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BMCS2023.Assignment;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
/**
 *
 * @author zhenyu
 */
public class DatabaseClient {
    private static final String SUPABASE_URL = "https://audqlatgynfemoecamjp.supabase.co";
    private static final String SUPABASE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImF1ZHFsYXRneW5mZW1vZWNhbWpwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTQzNzg2OTIsImV4cCI6MjA2OTk1NDY5Mn0.MIFHs8mPf_SplH5qGI8aSua1EHuOtjP0QfQb1TTO0bs";

    private static final HttpClient client = HttpClient.newHttpClient();

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

    public static <T> List<T> getRecords(String tableName, Class<T> clazz) throws Exception {
        String readResult = readRecords(tableName);
        Type listType = TypeToken.getParameterized(List.class, clazz).getType();
        return new Gson().fromJson(readResult, listType);
    }
   
}

