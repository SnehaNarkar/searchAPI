package com.service.customer;

import org.testng.Assert;
import org.testng.annotations.*;
import com.service.core.HTTPClientUtil;
import com.service.core.JsonParserUtil;

public class ITuneSerachTest 
{
	//To search for all audio and video content for term=jackson
	@Test
	public void test_status() throws Exception
	{
		String URL = "https://itunes.apple.com/search?term=jackson";
		HTTPClientUtil hcu = new HTTPClientUtil(URL);
		Assert.assertEquals(hcu.getStatus(),200);	
		hcu.close();
	}

	//To search for all Jack Johnson audio and video content
	@Test
	public void test_resultcount() throws Exception
	{
		String URL = "https://itunes.apple.com/search?term=jack+jackson";
		HTTPClientUtil hcu = new HTTPClientUtil(URL);
		String response = hcu.getResponse();
		JsonParserUtil parser = new JsonParserUtil(response);
		Assert.assertEquals(parser.getResultCount(),50);	
		hcu.close();
	}

	//To search for all Jack Jackson audio and video content and return only the results from the Canada 
	@Test
	public void test_term_country() throws Exception
	{
		String URL = "https://itunes.apple.com/search?term=jack+jackson&country=ca";
		HTTPClientUtil hcu = new HTTPClientUtil(URL);
		Assert.assertEquals(hcu.getStatus(),200);	
		hcu.close();
	}

	//To search for all Jack Jackson audio and video content and return only the results from the ABC country, which will be invalid
	@Test
	public void test_term_country_invalid() throws Exception
	{
		String URL = "https://itunes.apple.com/search?term=jackson&country=abc";
		HTTPClientUtil hcu = new HTTPClientUtil(URL);
		Assert.assertEquals(hcu.getStatus(),400);	
		hcu.close();
	}

	//To search for all Jack Johnson movie content, which will be invalid
	@Test
	public void test_term_media() throws Exception
	{
		String URL = "https://itunes.apple.com/search?term=jack+jackson&media=movie";
		HTTPClientUtil hcu = new HTTPClientUtil(URL);
		Assert.assertEquals(hcu.getStatus(),400);	
		hcu.close();
	}

	//To search for only Jack Johnson music videos
	@Test
	public void test_term_media_invalid() throws Exception
	{
		String URL = "https://itunes.apple.com/search?term=jack+jackson&media=musicVideo";
		HTTPClientUtil hcu = new HTTPClientUtil(URL);
		Assert.assertEquals(hcu.getStatus(),200);	
		hcu.close();
	}

	//To search for all Jack Johnson audio and video content and return only the first 25 items
	@Test
	public void test_term_limit_resultcount() throws Exception
	{
		String URL = "https://itunes.apple.com/search?term=jack+jackson&limit=25";
		HTTPClientUtil hcu = new HTTPClientUtil(URL);
		String response = hcu.getResponse();
		JsonParserUtil parser = new JsonParserUtil(response);
		Assert.assertEquals(parser.getResultCount(),25);	
		hcu.close();
	}

	//To search for all Jack Johnson audio and video content and return only the first 225 items, which will be invalid since max limit=200
	@Test
	public void test_term_limit_max_resultcount() throws Exception
	{
		String URL = "https://itunes.apple.com/search?term=jack+jackson&limit=225";
		HTTPClientUtil hcu = new HTTPClientUtil(URL);
		String response = hcu.getResponse();
		JsonParserUtil parser = new JsonParserUtil(response);
		Assert.assertEquals(parser.getResultCount(),200);	
		hcu.close();
	}
}
