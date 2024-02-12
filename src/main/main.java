package main;

import java.awt.Dimension;
import java.awt.Toolkit;



import presentation.FrameIMSAT;

public class main {

	public static void main(String[] args)  {
		FrameIMSAT fi = new FrameIMSAT();
        int width = 800;
        int height = 600;
        fi.setSize(width, height);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height)/2;
        // Set the JFrame's location to the center of the screen
        fi.setLocation(x, y);

		fi.setVisible(true);

	}
	

}
