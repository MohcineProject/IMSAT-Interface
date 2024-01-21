package presentation;

import java.awt.MenuComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;


import control.MenuControl;

public class saveListner implements ActionListener {
	MenuControl mc ; 
	saveListner( MenuControl mc){
		
		this.mc = mc ; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	JFileChooser f = new JFileChooser();
	f.showDialog(f, "save" ) ;
	String path = f.getSelectedFile().getAbsolutePath() ; 
	mc.save(path);
	
		
		
	}
	
	

}
