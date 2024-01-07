package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.MenuControl;

public class HelpListner implements ActionListener {
	MenuControl mc ;
	public HelpListner (MenuControl mc) {
		this.mc = mc ; 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mc.createHelpPage();
		
	}

}
