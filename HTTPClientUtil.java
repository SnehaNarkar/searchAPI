package com.service.core;

import java.io.BufferedReader;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HTTPClientUtil
{
	String Url;
	CloseableHttpResponse response;
	
	public HTTPClientUtil(String Url) throws Exception
	{
		this.Url = Url;
	}
	
	public static HttpResponse sendAndReceiveGETRequest(String url) throws Exception
	{
		HttpClient client = HttpClientBuilder.create ().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		return response;
	}
	
	
	public String getResponse() throws Exception {
		HttpEntity entity1 = this.response.getEntity();
		String response = EntityUtils.toString(entity1);
		return response;
	}
		
	public static String getMessageHttpResponse(HttpResponse response) throws Exception
	{
		StringBuffer result = new StringBuffer();
		String line = "";
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		while ((line = rd.readLine()) != null)
		{
			result.append("\n"+line);
		}
		return result.toString();

	}
	
	public int getStatus()
	{
		int status_code = response.getStatusLine().getStatusCode();
		return status_code;
		
	}
	public void close() throws Exception
	{
		this.close();
	}
}
