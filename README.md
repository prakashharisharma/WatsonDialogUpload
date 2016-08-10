# WatsonDialogUpload
WatsonDialogUpload makes it easy to upload watson dialog service xml file to watson server. Istead of using CURL developers and system integrators can use this util to upload dialog xml file.

By using WatsonDialogUpload, You can also upload file to watson server even if you are behind a organization firewall by setting proxy http and https host and port

Primary goals to this project are:

* Provide a faster way to upload, get and delete dialog xml file to watson.
* Provide a developer friendly java library instead of complex CURL syntax.
* Provide a way to upload file even if there is a firewall in your organization.

# Getting Started

* Clone WatsonDialogUpload

Here is a quick example of WatsonDialogUpload application in Java:

```
  //Create instance
	DialogClient dialogClient = new DialogUpload();
	//Set Dialog Service username and password
	dialogClient.setDialogServiceCredentials("<WATSON_DIALOG_SERVICE_USERNAME>", "<WATSON_DIALOG_SERVICE_PASSWORD>");
	//To Upload Dialog file
	dialogClient.uploadDialogFile("<DIALOG_XML_FILE_PATH>", "<UNIQUE_DIALOG_NAME>");
	//Get Dialog Info
	dialogClient.getDialogIdInfo();
	//Delete existing Dialog 
	uploadClient.deleteDialogFile("<DIALOG_ID>");
```

If you are behind a firewall use proxy settings as :

```
	//Set http and https proxy host and port	
	ProxySetting proxy = new ProxySetting("<HTTP_PROXY_HOST>","<HTTP_PROXY_PORT>","<HTTPS_PROXY_HOST>","<HTTPS_PROXY_PORT>");
	//Create instance	
	DialogClient dialogClient = new DialogUpload(proxy);
	//Set Dialog Service username and password	
	dialogClient.setDialogServiceCredentials("<WATSON_DIALOG_SERVICE_USERNAME>", "<WATSON_DIALOG_SERVICE_PASSWORD>");
	//To Upload Dialog file	
	dialogClient.uploadDialogFile("<DIALOG_XML_FILE_PATH>", "<UNIQUE_DIALOG_NAME>");
	//Get Dialog Info	
	dialogClient.getDialogIdInfo();
	//Delete existing Dialog 	
	uploadClient.deleteDialogFile("<DIALOG_ID>");
```

<a rel="license" href="http://creativecommons.org/licenses/by/3.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 Unported License</a>.
