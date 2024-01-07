package control;

import javax.swing.JPanel;

import presentation.FrameIMSAT;

public class AddMetricControl {
	FrameIMSAT fr ; 
	public AddMetricControl(FrameIMSAT fr) {
		this.fr = fr ; 
	}
	public void addMetricButton( String dimensionName, String dimension ) {
		fr.addMetricToNtemplate( dimensionName, dimension);
		
		
	}
	
	
}
