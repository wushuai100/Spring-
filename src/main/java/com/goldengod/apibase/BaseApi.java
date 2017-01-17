package com.goldengod.apibase;

import com.goldendog.common.BaseClass;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;;
import com.goldengod.response.Response;
import org.testng.Assert;

/**
 * Created by wushuai3 on 2017/1/11.
 */
public class BaseApi extends BaseClass {
    private static boolean logEntityStr = false;
    private static boolean logRequestEntity = true;
    private static boolean logRequestHeaders = true;
    private static boolean logResponseHeader = false;
    private static boolean logResponseStatusLine = true;
    protected String entitystr;
    protected Response ResponseObject;


    protected static String GetResponseEntityStr(Logger logger,
                                                 CloseableHttpResponse httpResponse) throws IOException {
        HttpEntity entity = httpResponse.getEntity();
        GzipDecompressingEntity gzipentity = new GzipDecompressingEntity(entity);
        String entitystr = EntityUtils.toString(gzipentity);

        if (BaseApi.logEntityStr) {
            BaseApi.LogResponseEntity(logger, entitystr);
        }

        EntityUtils.consume(entity);
        return entitystr;
    }
    public static void LogResponseEntity(Logger logger, String entityStr) {
        logger.info("--------------------------------------------------------------------------");
        logger.info(entityStr);
    }
    protected String host;
    protected DefaultHttpClient httpClient;
    protected HashMap<String, String> headers =new  HashMap<String, String>();
    protected Class<?> responsetype;
    protected void CloseConnection(CloseableHttpResponse httpResponse)
            throws IOException {
        httpResponse.close();
        httpClient.getConnectionManager().shutdown();
    }
    protected void CreateHttpClientInstance(Cookie cookie) {
        httpClient = new DefaultHttpClient();

        CookieStore cookieStore = new BasicCookieStore();
        cookieStore.addCookie(cookie);
        httpClient.setCookieStore(cookieStore);
    }
    protected Response GetResponseObject(String entitystr)
            throws IOException {

        Gson gson = new Gson();
        Response responseObject = (Response) gson.fromJson(
                entitystr, this.responsetype);
        return responseObject;
    }
    protected void VerifyResponseStatus(CloseableHttpResponse httpResponse) {
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);

    }
}
