package com.td.watson;

import java.io.File;

import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.td.proxy.ProxySetting;
import com.td.util.PropertyReader;

public class DialogUpload implements DialogClient{

	private String userName;
	
	private String passWord;

	public DialogUpload(){
		
	}
	
	public DialogUpload(ProxySetting proxy){
		
	}
	
	public String uploadDialogFile(String dialogFileLocation, String uniqueDialogName){
		
		String output=null;
		
		ClientConfig config = new DefaultClientConfig();
		
		config.getClasses().add(MultiPartWriter.class);
		
		Client client = createClient(config);
		
		final WebResource resource = client.resource(getResourceURI());

	    final File fileToUpload = new File(dialogFileLocation);

	    final FormDataMultiPart multiPart = new FormDataMultiPart();
	    
	    multiPart.field("name", uniqueDialogName);
	    
	    if (fileToUpload != null) {
	        multiPart.bodyPart(new FileDataBodyPart("file", fileToUpload,MediaType.APPLICATION_OCTET_STREAM_TYPE));
	        
	    }
	    
	    final ClientResponse clientResp = resource.type(MediaType.MULTIPART_FORM_DATA_TYPE).accept("application/json").post(ClientResponse.class,multiPart);
	    
	    System.out.println("Response: " + clientResp.getStatus());
	    output = clientResp.getEntity(String.class);
		System.out.println(output);

	    client.destroy();
	    
	    return output;
	}
	
	
	public String getDialogIdInfo(){
		
		String output=null;
		Client client = createClient();
		
		WebResource webResource = client.resource(getResourceURI());
		
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		try{
			
			if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			}
			
			output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);
			
			System.out.println("NetClientGet.main()");
		}catch (Exception e) {

			e.printStackTrace();

		  }
		
		client.destroy();
		return output;
	}
	
	
	public String deleteDialogFile(String dialogId){
		String output=null;
		Client client = createClient();
		WebResource webResource = client.resource(getResourceURI()+"/"+dialogId);

		ClientResponse response = webResource.accept("application/json").accept("application/json").delete(ClientResponse.class);
		try{
			if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}

				output = response.getEntity(String.class);

				System.out.println("Output from Server .... \n");
				System.out.println(output);
				
				System.out.println("NetClientGet.main()");
		}catch (Exception e) {

			e.printStackTrace();

		  }
		client.destroy();
		return output;
	}
	


	public void setDialogServiceCredentials(String userName, String passWord){
		this.userName = userName;
		this.passWord = passWord;
	}
	
	private Client createClient(){
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter(this.userName, this.passWord));
		
		return client;
	}
	
	private Client createClient(final ClientConfig config){
		
		Client client = Client.create(config);
		client.addFilter(new HTTPBasicAuthFilter(this.userName, this.passWord));
		
		return client;
	}
	
	private String getResourceURI(){
		return PropertyReader.getInstance().getProperty("watson.uri");
	}
}
