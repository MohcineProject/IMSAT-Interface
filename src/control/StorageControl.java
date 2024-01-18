package control;

import java.awt.Component;



import abstraction.HandleData;



public class StorageControl {
	
	HandleData hd  ; 
	public StorageControl( ){
		  
		 this.hd = new HandleData() ; 
	}
	
	
	public void screenShot(String filePath, Component component) {
		hd.screenShot(filePath, component);
		
	}
	
	
	
}
