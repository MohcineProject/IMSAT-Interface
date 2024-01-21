package presentation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

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
		JFileChooser f = new JFileChooser()  ; 
		f.showOpenDialog(f) ; 
		String path = f.getSelectedFile().getAbsolutePath() ;
		sc.screenShot(path, fr.graph.getComponent(1));
		String m = "C:\\Users\\HP\\Desktop\\HeyTherItsMe.png";
		
		
	}

}
