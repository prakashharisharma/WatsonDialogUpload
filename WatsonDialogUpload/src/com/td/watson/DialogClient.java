package com.td.watson;

public interface DialogClient {

	public void setDialogServiceCredentials(String userName, String passWord);
	
	public String getDialogIdInfo();
	
	public String uploadDialogFile(String dialogFileLocation, String uniqueDialogName);
	
	public String deleteDialogFile(String dialogId);
	
}
