package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import control.MenuControl;

public class OpenListner implements ActionListener{

	
	
	MenuControl mc ; 
	public OpenListner(MenuControl mc  ) {
		// TODO Auto-generated constructor stub

	this.mc = mc ; 
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser f = new JFileChooser() ; 
		f.showDialog(f, "save") ; 
		String path = f.getSelectedFile().getAbsolutePath() ; 
		mc.open(path);
		
		
		
		
	}

}
