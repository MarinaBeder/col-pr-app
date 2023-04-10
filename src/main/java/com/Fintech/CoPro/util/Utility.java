package com.Fintech.CoPro.util;

import javax.servlet.http.HttpServletRequest;

public class Utility {
public static String getSiteUrl(HttpServletRequest request) {
	String siteURL = request.getRequestURI().toString();
	System.out.println("**********************"+siteURL);
	return siteURL.replace(request.getServletPath(),"");
}
}
