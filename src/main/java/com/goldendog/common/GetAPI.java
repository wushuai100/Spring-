package com.goldendog.common;
import com.goldengod.apibase.BaseApi;
import com.goldengod.response.Response;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;

import java.io.IOException;

public abstract class GetAPI extends BaseApi {

	public Response SendRequest(Cookie cookie)
			throws ClientProtocolException, IOException {
		this.CreateHttpClientInstance(cookie);

		HttpGet httpGet = new HttpGet(this.host);
		httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch");


		CloseableHttpResponse httpResponse = this.httpClient.execute(httpGet);


		this.VerifyResponseStatus(httpResponse);

		this.entitystr = BaseApi.GetResponseEntityStr(this.logger,
				httpResponse);

		Response responseObject = this.GetResponseObject(entitystr);

		this.CloseConnection(httpResponse);

		return responseObject;
	}
}
