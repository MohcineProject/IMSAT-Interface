package control;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import abstraction.HandleData;



public class StorageControl {
	Component component ; 
	HandleData hd  ; 
	StorageControl(Component component ){
		 this.component = component ; 
		 this.hd = new HandleData() ; 
	}
	
	public void screenShot(String filePath, Component component) {
		hd.screenShot(filePath, component);
		
	}
	
	
	
}
