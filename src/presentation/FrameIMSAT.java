package presentation;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;


import control.AddMetricControl;
import control.MenuControl;


public class FrameIMSAT extends JFrame {
	JPanel Ntemplate ;
	JPanel helpPage ;
	JPanel metrics ; 
	JPanel centerButt ; 
	JPanel graph ;
	AddMetricControl amc ; 
	public FrameIMSAT() {
		super("TMSAT") ; 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Configuring the Menu Items 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem HelpNewMenu = new JMenuItem("Help");
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
		//Creating the global Plane
		Ntemplate = new JPanel();
		GridBagLayout gbl_Ntemplate = new GridBagLayout();
		gbl_Ntemplate.rowWeights = new double[]{1.0};
		gbl_Ntemplate.columnWeights = new double[]{1.0, 1.0, 1.0};
		Ntemplate.setLayout(gbl_Ntemplate);

		
		
		
		
		
		//Creating the metrics side
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH ;
		c1.gridheight = 1 ; 
		metrics = new JPanel() ; 
		metrics.setLayout(new BorderLayout());
		metrics.setMaximumSize(metrics.getSize());
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
		JButton addMetric = new JButton("Add a metric") ;
		amc = new AddMetricControl(this) ; 
		AddMetricListener aml = new AddMetricListener(amc, this) ; 
		addMetric.addActionListener(aml);

		centerButt = new JPanel();
		centerButt.setLayout(new BoxLayout(centerButt , BoxLayout.PAGE_AXIS));
		JPanel addPanel = new JPanel();
		addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.LINE_AXIS));
		addPanel.add(Box.createHorizontalGlue()) ; 
		addPanel.add(addMetric);
		addPanel.add(Box.createHorizontalGlue()) ;
		centerButt.add(Box.createRigidArea(new Dimension(0,30))) ;
		centerButt.add(addPanel) ; 
		centerButt.add(Box.createRigidArea(new Dimension(0,10)));
		metrics.add(centerButt, BorderLayout.CENTER);
		c1.gridx = 0 ; 
		c1.gridy = 0 ; 
		Ntemplate.add(metrics, c1) ; 







		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.BOTH;
		c2.anchor = GridBagConstraints.CENTER;
		c2.gridheight = 1;
		graph = new JPanel() ; 
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
		JButton screenShot = new JButton("ScreenShot") ;
		
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

		
		
		
		
		//Design the help Page:
		helpPage = new JPanel() ; 
		helpPage.setLayout(new BorderLayout());
		String helpTitleText = "IMSAT project : " ; 
		JLabel helpTitle = new JLabel(helpTitleText) ; 
		JPanel titlePanel = new JPanel() ; 
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		titlePanel.add(helpTitle);
		JTextArea helpDescription = new JTextArea("The IMSAT project is conducted by the IMSAT club at IMT atlantique. It aims at sending a cubesat to a high altitude in order to capture"+ "\n" 
				+ " data and measurements of various physical attributes. This application is the designed to capture the data send by the satellite as well"+ "\n"
				+ " as to display and store useful information for the user. This application under continuous developement for educational purposes. The "+ "\n"
				+ "code is freely available on Github, in Java. We are relying on futur developements to further enhance the application and add more "+ "\n"
				+ "features (specially from the TAF DCL students to gain a hand on experience in coding ") ; 
		JPanel helpDescriptionPanel = new JPanel();
		helpDescriptionPanel.setLayout(new FlowLayout(FlowLayout.LEADING)) ; 
		helpDescriptionPanel.add(helpDescription);
		helpPage.add(titlePanel, BorderLayout.NORTH) ; 
		helpPage.add(helpDescriptionPanel, BorderLayout.CENTER); 

		//Assigning the listeners 
		MenuControl mc = new MenuControl(this);
		//Listener of new Template
		NewFileListener nfl = new NewFileListener(mc);
		mntmNewMenuItem.addActionListener(nfl);
		//Listener of HelpPage
		HelpListner helpPageListner = new HelpListner(mc);
		HelpNewMenu.addActionListener(helpPageListner);


	}
	public void createNewTemplate() {
		setContentPane(Ntemplate);
		Ntemplate.revalidate() ;
	}
	public void createHelpPage() {
		setContentPane(helpPage);
		helpPage.revalidate() ;
		this.revalidate();
	}





	public  void showDialog(JFrame parentFrame) {
		JDialog dialog = new JDialog(parentFrame, "Metric options", true);


		// Create components for the dialog
		//Create the Naming part
		JLabel labelName = new JLabel("Name :");
		JPanel namepane = new JPanel();
		namepane.setLayout(new BoxLayout(namepane, BoxLayout.LINE_AXIS));
		namepane.add(labelName);
		namepane.add(Box.createHorizontalGlue()) ;
		JTextField inputName = new JTextField();

		//Create the dimension part
		JLabel labelDimension = new JLabel("Dimension :");
		JPanel dimensionpane = new JPanel();
		dimensionpane.setLayout(new BoxLayout(dimensionpane, BoxLayout.LINE_AXIS));
		dimensionpane.add(labelDimension);
		dimensionpane.add(Box.createHorizontalGlue()) ;
		JTextField inputDimension = new JTextField();

		//Create the path of the file 
		JLabel labelPath = new JLabel("Path :");
		JPanel pathPane = new JPanel();
		pathPane.setLayout(new BoxLayout(pathPane, BoxLayout.LINE_AXIS));
		pathPane.add(labelPath);
		pathPane.add(Box.createHorizontalGlue()) ;
		JTextField inputPath = new JTextField();


		//Create dialog buttons and layout
		JButton closeButton = new JButton("Close");
		JButton addButton = new JButton("Add");
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String dimensionName = inputName.getText();
				String dimension = inputDimension.getText();
				String path = inputPath.getText() ;
				amc.addMetricButton(dimensionName, dimension, path);
				dialog.dispose();

			}
		}) ;
		JPanel buttonPane = new JPanel() ;
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(addButton) ; 
		buttonPane.add(Box.createRigidArea(new Dimension(10,0)));
		buttonPane.add(closeButton) ; 


		// Add components to the dialog
		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp,BoxLayout.PAGE_AXIS));
		inputName.setPreferredSize(new Dimension(300, inputName.getHeight()+ 10));
		inputDimension.setPreferredSize(new Dimension(300, inputDimension.getHeight()+ 10));
		inputPath.setPreferredSize(new Dimension(300, inputPath.getHeight()+ 10));
		jp.add(namepane);
		jp.add(Box.createRigidArea(new Dimension(0,5)));
		jp.add(inputName);
		jp.add(dimensionpane);
		jp.add(Box.createRigidArea(new Dimension(0,5)));
		jp.add(inputDimension);
		jp.add(pathPane) ; 
		jp.add(Box.createRigidArea(new Dimension(0,5)));
		jp.add(inputPath);
		jp.add(buttonPane);
		dialog.add(jp);

		// Set up action for the close button
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Close the dialog when the button is clicked
				dialog.dispose();
			}
		});

		// Set dialog properties
		dialog.setSize(400, 200);
		dialog.setLocationRelativeTo(parentFrame);
		dialog.setVisible(true);
	}
	public void addMetricToNtemplate(String dimensionName, String dimension, String path) {
		JButton newDimension = new JButton(dimensionName) ;
		newDimension.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					amc.showContent(path, dimensionName, "time","value");
					
					
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		newDimension.setToolTipText( dimension);
		JPanel newAddPanel = new JPanel();
		newAddPanel.setLayout(new BoxLayout(newAddPanel, BoxLayout.LINE_AXIS));
		newAddPanel.add(Box.createHorizontalGlue()) ; 
		newAddPanel.add(newDimension);
		newAddPanel.add(Box.createHorizontalGlue()) ; 
		centerButt.add(newAddPanel) ;
		centerButt.add(Box.createRigidArea(new Dimension(0,10)));
		Ntemplate.revalidate();


	}

	public void setGraphContent(ChartPanel frame) {
		graph.add(frame, BorderLayout.CENTER) ;
		Ntemplate.revalidate();
	}




}
