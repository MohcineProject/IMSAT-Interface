package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import control.AddMetricControl;

public class AddMetricListener implements ActionListener{
	AddMetricControl amc ;
	FrameIMSAT f ; 

	public AddMetricListener(AddMetricControl amc, FrameIMSAT f) {
		this.amc = amc ; 
		this.f = f ; 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		f.showDialog(f);
		
	}

}
