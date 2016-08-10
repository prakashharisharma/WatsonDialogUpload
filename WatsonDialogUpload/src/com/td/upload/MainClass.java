package com.td.upload;

import com.td.proxy.ProxySetting;
import com.td.watson.DialogClient;
import com.td.watson.DialogUpload;

public class MainClass {

	public static void main(String args[]){
		
		ProxySetting proxy = new ProxySetting("<HTTP_PROXY_HOST>","<HTTP_PROXY_PORT>","<HTTPS_PROXY_HOST>","<HTTPS_PROXY_PORT>");
		
		DialogClient dialogClient = new DialogUpload(proxy);
		
		dialogClient.setDialogServiceCredentials("<WATSON_DIALOG_SERVICE_USERNAME>", "<WATSON_DIALOG_SERVICE_PASSWORD>");
		
		dialogClient.uploadDialogFile("<DIALOG_XML_FILE_PATH>", "<UNIQUE_DIALOG_NAME>");
		
		dialogClient.getDialogIdInfo();
		
		//uploadClient.deleteDialogFile("<DIALOG_ID>");
		
	}
}
