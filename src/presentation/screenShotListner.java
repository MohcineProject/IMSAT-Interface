package presentation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartPanel;

import control.StorageControl;


public class screenShotListner implements ActionListener {
	
	StorageControl sc ;
	FrameIMSAT fr ; 
	screenShotListner ( StorageControl sc, FrameIMSAT fr  ) {
		this.sc = sc ; 
		this.fr = fr ; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		sc.screenShot("C:\\Users\\HP\\Desktop\\HeyTherItsMe.png", fr.graph.getComponent(1));
		
		
	}

}
