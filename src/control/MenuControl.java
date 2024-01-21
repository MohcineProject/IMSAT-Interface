package control;


import presentation.FrameIMSAT;

import java.util.ArrayList;

import abstraction.HandleData;
public class MenuControl {
	FrameIMSAT fr ; 
	public MenuControl(FrameIMSAT fr) {
		this.fr = fr ; 
	}
	
public void createNewTemplate() {
	fr.createNewTemplate();
}
public void createHelpPage() {
	
	fr.createHelpPage();
	
}

public void save(String path) {
	HandleData hd = new HandleData(); 
	ArrayList<String> buttonNames = fr.getButtonNames() ;
	ArrayList<String> dimensions = fr.getDimensions();
	ArrayList<String> paths = fr.getPaths() ;
	int lenght = paths.size();
	for (int i = 0 ; i< lenght ; i++) {
		String line = buttonNames.get(i)+ ";" + dimensions.get(i) + ";" + paths.get(i) +"\n" ; 
		hd.writeIntoFile(path, line);
	}



}
public void open(String path) {
	HandleData hd = new HandleData() ; 
	ArrayList<String[]> list = hd.captureData(path) ;
	int lenght = list.size() ; 
	fr.createNewTemplate();
	for (int i = 0 ; i < lenght; i++) {
		String name = list.get(i)[0] ; 
		String dimension = list.get(i)[1] ; 
		String filePath = list.get(i)[2] ; 
		fr.addMetricToNtemplate(name, dimension, filePath);
	}
	
}




}
