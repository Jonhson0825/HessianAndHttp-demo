package com.xinchen.http;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author
 * @create 2021-04-29 16:27
 */
public class MyClient {
    public static void main(String[] args) throws Exception {
        get();
        System.out.println("=========");
        Post2();

    }

    private static void Post2() throws UnsupportedEncodingException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("http://localhost:8080/web_demo/post");

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("name","aoteman"));
        nameValuePairs.add(new BasicNameValuePair("age","300"));

        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairs);

        httpPost.setEntity(formEntity);

        try {
            HttpResponse execute = httpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
                System.out.println(EntityUtils.toString(execute.getEntity()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void post() throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();



        HttpPost httpPost = new HttpPost("http://www.oschina.net/");

//        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36");

        httpPost.setHeader("User-Agent","");

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode()==200) {
                System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response!=null){
                response.close();
            }
            httpClient.close();
        }
    }

        private static void get() throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        URI uri = new URIBuilder("http://localhost:8080/web_demo/do").setParameter("name","fangfang").build();

//        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
             response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200) {
                System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response!=null){
                response.close();
            }
            httpClient.close();
        }
    }
}
