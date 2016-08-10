package com.td.proxy;

public class ProxySetting {

	private final String HTTP_PROXY_HOST;
	
	private final String HTTP_PROXY_PORT;
	
	private final String HTTPS_PROXY_HOST;
	
	private final String HTTPS_PROXY_PORT;
	
	public ProxySetting(String httpProxyHost, String httpProxyPort, String httpsProxyHost, String httpsProxyPort){
		this.HTTP_PROXY_HOST = httpProxyHost;
		this.HTTP_PROXY_PORT = httpProxyPort;
		this.HTTPS_PROXY_HOST = httpsProxyHost;
		this.HTTPS_PROXY_PORT = httpsProxyPort;
		
		setSystemProxies();
	}
	
	private void setSystemProxies(){
		
		System.setProperty("https.proxyHost", HTTPS_PROXY_HOST);
	    System.setProperty("https.proxyPort", HTTPS_PROXY_PORT);
	    System.setProperty("http.proxyHost", HTTP_PROXY_HOST);
	    System.setProperty("http.proxyPort", HTTP_PROXY_PORT);
	    
	}
	
}
