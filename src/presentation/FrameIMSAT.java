package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import control.MenuControl;


public class FrameIMSAT extends JFrame {
	JPanel Ntemplate ;
	public FrameIMSAT() {
		super("TMSAT") ; 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Configuring the Menu Items 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu HelpNewMenu = new JMenu("Help");
		menuBar.add(HelpNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New Template");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open Template");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		//Creating the Welcome Panel 
		JPanel welcome = new JPanel() ;
		JLabel hello = new JLabel(" Welcome in the cube satellite \n Interface ") ;
		Font helloWriting = new Font("Algerian", Font.PLAIN ,16  );
		welcome.setLayout(new GridBagLayout());
		hello.setFont(helloWriting);
		hello.setHorizontalAlignment(JLabel.CENTER) ;
		hello.setVerticalAlignment(JLabel.CENTER) ;
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH ; 
		c.gridx= 0 ; 
		c.gridy = 0 ; 
		c.anchor = GridBagConstraints.CENTER ; 
		c.gridwidth = 1 ;
		c.gridheight = 1 ; 
		welcome.add(hello,c ) ; 
		setContentPane(welcome);
		
		//Creating the second page of the templates 
		Ntemplate = new JPanel();
		GridBagLayout gbl_Ntemplate = new GridBagLayout();
		gbl_Ntemplate.rowWeights = new double[]{1.0};
		gbl_Ntemplate.columnWeights = new double[]{1.0, 1.0, 1.0};
		Ntemplate.setLayout(gbl_Ntemplate);
		
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH ;
		c1.gridheight = 1 ; 
		JPanel metrics = new JPanel() ; 
		metrics.setLayout(new BorderLayout());
		JLabel metricsLabel = new JLabel("metrics");
		metricsLabel.setBackground(new Color(255));
		metricsLabel.setOpaque(true);
		metricsLabel.setHorizontalAlignment(JLabel.CENTER);
		//
		JPanel gNorth1 = new JPanel() ;
		gNorth1.setLayout(new BorderLayout());
		gNorth1.setPreferredSize(new Dimension(metrics.getWidth(),60));
		gNorth1.add(metricsLabel, BorderLayout.CENTER) ;
		//
		metrics.add(gNorth1,BorderLayout.NORTH);
		c1.gridx = 0 ; 
		c1.gridy = 0 ; 
		Ntemplate.add(metrics, c1) ; 
		
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.BOTH;
		c2.anchor = GridBagConstraints.CENTER;
		c2.gridheight = 1;
		JPanel graph = new JPanel() ; 
		graph.setLayout(new BorderLayout());
		JLabel graphLabel = new JLabel("graph");
		graphLabel.setBackground(new Color(255));
		graphLabel.setOpaque(true);
		graphLabel.setHorizontalAlignment(JLabel.CENTER);
		//
		JPanel gNorth2 = new JPanel() ;
		gNorth2.setLayout(new BorderLayout());
		gNorth2.setPreferredSize(new Dimension(graph.getWidth(),60));
		gNorth2.add(graphLabel, BorderLayout.CENTER) ; 
		//
		graph.add(gNorth2, BorderLayout.NORTH);
		c2.gridx = 1 ; 
		c2.gridy = 0 ; 
		Ntemplate.add(graph, c2) ;
		
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.fill = GridBagConstraints.BOTH;
		c3.anchor = GridBagConstraints.EAST;
		c3.gridwidth = 1;
		c3.gridheight = 1;
		JPanel storage = new JPanel() ; 
		JLabel storageLabel = new JLabel("storage");
		storage.setLayout(new BorderLayout());
		storageLabel.setBackground(new Color(255));
		storageLabel.setOpaque(true);
		storageLabel.setHorizontalAlignment(JLabel.CENTER);
		//
		JPanel gNorth3 = new JPanel() ;
		gNorth3.setLayout(new BorderLayout());
		gNorth3.setPreferredSize(new Dimension(storage.getWidth(),60));
		gNorth3.add(storageLabel, BorderLayout.CENTER) ;
		//
		storage.add(gNorth3, BorderLayout.NORTH);
		c3.gridx = 2; 
		c3.gridy = 0 ; 
		Ntemplate.add(storage, c3) ; 
		
		
		//Assigning the listeners 
			//Listener of new Template
		MenuControl mc = new MenuControl(this);
		NewFileListener nfl = new NewFileListener(mc);
		mntmNewMenuItem.addActionListener(nfl);
		
	}
public void createNewTemplate() {
	setContentPane(Ntemplate);
	Ntemplate.revalidate() ;
}

}
