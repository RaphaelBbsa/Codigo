package com.projetopbrenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class HttpClientFactory {
    private static Map<String, List<Cookie>> cookieStore = new HashMap<>(); //

    public static OkHttpClient createClient() { //
        return new OkHttpClient().newBuilder()
        .cookieJar(new CookieJar() {

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) { //implemento inline. esse métodso
                List<Cookie> cookies = cookieStore.get(url.host());
                return cookies != null ? cookies : new ArrayList<>();
            }

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookieStore.put(url.host(), cookies);
            }
            
        })
        .build();
    }
    

}
