package edu.eci.arep.ase.app.apiExternal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClient {

     private OkHttpClient httpClient;

    public HttpClient() {
        httpClient = new OkHttpClient();
    }

    public String call(String url){
        HttpUrl httpUrl = HttpUrl.parse(url).newBuilder().build();
        Request request = new Request.Builder().url(httpUrl).get().build();
        String dataAux = "";
        try(Response response = httpClient.newCall(request).execute()){
            dataAux = response.body().string();
        }catch(IOException e){
            e.printStackTrace();
        }

        return dataAux;

    }

    public String invoker(String host, int port, String route){
        return call(host + ":" + port + route);
    }

}
