package control;

import presentation.FrameIMSAT;

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
}
