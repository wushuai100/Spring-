package com.goldendog.common;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wushuai3 on 2017/1/11.
 */
public class Main {
    public static void main(String args[]) {
        String a = String.format("wushuai%s","dfdfd");
        System.out.print(a);
        Class<?> responsetype=String.class;
        System.out.print(responsetype);
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpGet httpget = new HttpGet(HostStrings.BaseMIAOSHAURI);

            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            System.out.println("--------------------------------------");
            System.out.println(response.getStatusLine());
            if(entity!=null){
                System.out.println(entity.getContentLength());
                String entityStr = EntityUtils.toString(entity);
                System.out.println(entityStr);
                JSONObject obj = new JSONObject(entityStr);
                System.out.println("++++++++++++++++++++");


                System.out.println(obj);
                System.out.println(obj.getJSONArray("floorList"));
                Pattern pattern= Pattern.compile("http?:\\/\\/[a-z0-9A-Z\\.\\/\\!\\-]+");
                Matcher matcher= pattern.matcher(entityStr);
                boolean re = matcher.find();
                System.out.println(re);
                while(matcher.find())
                {
                    System.out.println(matcher.group(0).length());


                }




            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
