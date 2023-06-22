package com.example.mockupexam;

import java.io.IOException;
import okhttp3.*;

import android.os.StrictMode;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class OkHttpHandler {

    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public ArrayList<Animal> getAllAnimals(String ip) throws IOException {
        ArrayList<Animal> list = new ArrayList<>();

        String data = getData(ip);

        try {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String animalName = keys.next();
                JSONObject animalObject = json.getJSONObject(animalName);

                String type = animalObject.getString("type");
                String voice = animalObject.getString("voice");
                String image = animalObject.getString("image");

                list.add(new Animal(animalName, type, voice, image));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getData(String ip) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url("http://" + ip + "/animals/getAnimals.php").method("POST", body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
