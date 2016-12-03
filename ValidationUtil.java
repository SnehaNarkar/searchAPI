package com.service.core;

import org.apache.http.HttpResponse;
import org.testng.Assert;

public class ValidationUtil {

	public static void performStandardValiadationsOnResponse(HttpResponse response)
	{
		//Assert status code
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
		//Assert status message
	}

	public static void performDataContainsChecks(String responseMsg, String checkData)
	{
		Assert.assertTrue(responseMsg.toString().contains(checkData));
	}
}


