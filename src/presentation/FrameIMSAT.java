package presentation;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartPanel;


import control.AddMetricControl;
import control.MenuControl;
import control.StorageControl;
import ui_elements.BackgroundPanel;
import ui_elements.MyButton;
import ui_elements.TransparentPanel;


public class FrameIMSAT extends JFrame {
	BackgroundPanel Ntemplate ;
	BackgroundPanel helpPage ;
	TransparentPanel metrics ; 
	TransparentPanel centerButt ; 
	TransparentPanel graph ;
	AddMetricControl amc ; 
	JMenuItem newTemplate ;
	JMenuItem HelpNewMenu ;
	JMenuItem openTemplate ;
	JMenuItem save ; 
	
	
	public ArrayList<String> getButtonNames() {
		return buttonNames;
	}
	public void setButtonNames(ArrayList<String> buttonNames) {
		this.buttonNames = buttonNames;
	}
	public ArrayList<String> getDimensions() {
		return dimensions;
	}
	public void setDimensions(ArrayList<String> dimensions) {
		this.dimensions = dimensions;
	}
	public ArrayList<String> getPaths() {
		return paths;
	}
	public void setPaths(ArrayList<String> paths) {
		this.paths = paths;
	}

	ArrayList<String> buttonNames = new ArrayList<String>() ;
	ArrayList<String> dimensions = new ArrayList<String>() ;
	ArrayList<String> paths = new ArrayList<String>() ;
	
	
	public FrameIMSAT() {
		super("IMSAT") ; 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Configuring the Menu Items 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		HelpNewMenu = new JMenuItem("Help");
		menuBar.add(HelpNewMenu);

		newTemplate = new JMenuItem("New Template");
		mnNewMenu.add(newTemplate);

		openTemplate = new JMenuItem("Open Template");
		mnNewMenu.add(openTemplate);

		openTemplate.addActionListener(null);
		
		 save = new JMenuItem("Save");
		mnNewMenu.add(save);
		

		//Creating the Welcome Panel 
		BackgroundPanel welcome = new BackgroundPanel() ;
		JLabel hello = new JLabel("<html> Welcome to the cube satellite <br> Interface <html> ") ;
		Font helloWriting = new Font("Algerian", Font.PLAIN ,16  );
		hello.setForeground(Color.WHITE);
		welcome.setLayout(new GridBagLayout());
		hello.setFont(helloWriting);
		hello.setHorizontalAlignment(SwingConstants.CENTER) ;
		hello.setVerticalAlignment(SwingConstants.CENTER) ;
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH ; 
		c.gridx= 0 ; 
		c.gridy = 0 ; 
		c.anchor = GridBagConstraints.CENTER ; 
		c.gridwidth = 1 ;
		c.gridheight = 1 ; 
		welcome.add(hello,c ) ;
		add(welcome);
		//Assigning the listeners 
		MenuControl mc = new MenuControl(this);
		//Listener of new Template
		NewFileListener nfl = new NewFileListener(mc);
		newTemplate.addActionListener(nfl);
		//Listener of HelpPage
		HelpListner helpPageListner = new HelpListner(mc);
		HelpNewMenu.addActionListener(helpPageListner);
		//Listener of the save file 
		saveListner s = new saveListner (mc) ;
		save.addActionListener(s);
		//Listner of the open file 
		OpenListner o = new OpenListner( mc) ; 
		openTemplate.addActionListener(o);

	}
	public void createNewTemplate() {
		Ntemplate = new BackgroundPanel();
		GridBagLayout gbl_Ntemplate = new GridBagLayout();
		gbl_Ntemplate.rowWeights = new double[]{1.0};
		gbl_Ntemplate.columnWeights = new double[]{1.0, 1.0, 1.0};
		Ntemplate.setLayout(gbl_Ntemplate);


		//Creating the metrics side
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH ;
		c1.gridheight = 1 ; 
		metrics = new TransparentPanel() ; 
		metrics.setLayout(new BorderLayout());
		metrics.setMaximumSize(metrics.getSize());
		JLabel metricsLabel = new JLabel("metrics");
		metricsLabel.setBackground(new Color(255));
		metricsLabel.setOpaque(true);
		metricsLabel.setHorizontalAlignment(JLabel.CENTER);
		//
		TransparentPanel gNorth1 = new TransparentPanel() ;
		gNorth1.setLayout(new BorderLayout());
		gNorth1.setPreferredSize(new Dimension(metrics.getWidth(),60));
		gNorth1.add(metricsLabel, BorderLayout.CENTER) ;
		//
		metrics.add(gNorth1,BorderLayout.NORTH);
		MyButton addMetric = new MyButton("Add a metric") ;
		amc = new AddMetricControl(this) ; 
		AddMetricListener aml = new AddMetricListener(amc, this) ; 
		addMetric.addActionListener(aml);

		centerButt = new TransparentPanel();
		centerButt.setLayout(new BoxLayout(centerButt , BoxLayout.PAGE_AXIS));
		TransparentPanel addPanel = new TransparentPanel();
		addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.LINE_AXIS));
		addPanel.add(Box.createHorizontalGlue()) ; 
		addPanel.add(addMetric);
		addPanel.add(Box.createHorizontalGlue()) ;
		centerButt.add(Box.createRigidArea(new Dimension(0,50))) ;
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
		graph = new TransparentPanel() ; 
		graph.setLayout(new BorderLayout());
		JLabel graphLabel = new JLabel("graph");
		graphLabel.setBackground(new Color(255));
		graphLabel.setOpaque(true);
		graphLabel.setHorizontalAlignment(JLabel.CENTER);
		//
		TransparentPanel gNorth2 = new TransparentPanel() ;
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
		TransparentPanel storage = new TransparentPanel() ; 
		JLabel storageLabel = new JLabel("storage");
		storage.setLayout(new BorderLayout());
		storageLabel.setBackground(new Color(255));
		storageLabel.setOpaque(true);
		storageLabel.setHorizontalAlignment(JLabel.CENTER);
		//
		TransparentPanel gNorth3 = new TransparentPanel() ;
		gNorth3.setLayout(new BorderLayout());
		gNorth3.setPreferredSize(new Dimension(storage.getWidth(),60));
		gNorth3.add(storageLabel, BorderLayout.CENTER) ;
		//
		MyButton screenShot = new MyButton("ScreenShot") ;
		StorageControl sc = new StorageControl() ; 
		screenShotListner sdl = new screenShotListner(sc, this );
		screenShot.addActionListener(sdl);
		TransparentPanel storageButtons = new TransparentPanel();
		storageButtons.setLayout(new BoxLayout(storageButtons, BoxLayout.Y_AXIS));
		storageButtons.add(Box.createRigidArea(new Dimension (storage.getWidth(), 50)));
		storageButtons.add(screenShot); 
		TransparentPanel buttonAdapter = new TransparentPanel() ; 
		buttonAdapter.setLayout(new FlowLayout());
		buttonAdapter.add(Box.createHorizontalGlue());
		buttonAdapter.add(screenShot);
		buttonAdapter.add(Box.createHorizontalGlue());
		storageButtons.add(buttonAdapter) ; 
		storage.add(gNorth3, BorderLayout.NORTH);
		storage.add(storageButtons, BorderLayout.CENTER) ; 
		c3.gridx = 2; 
		c3.gridy = 0 ; 
		Ntemplate.add(storage, c3) ; 



		setContentPane(Ntemplate);
		Ntemplate.revalidate() ;
	}
	public void createHelpPage() {
		helpPage = new BackgroundPanel() ; 
		helpPage.setLayout(new BorderLayout());
		String helpTitleText = "IMSAT project : " ; 
		JLabel helpTitle = new JLabel(helpTitleText) ;
		helpTitle.setForeground(Color.WHITE);
		TransparentPanel titlePanel = new TransparentPanel() ; 
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		titlePanel.add(helpTitle);
		JLabel helpDescription = new JLabel("<html> The IMSAT project is conducted by the IMSAT club at IMT atlantique. It aims at sending a cubesat to a high altitude in order to capture"+ "<br>" 
				+ " data and measurements of various physical attributes. This application is the designed to capture the data send by the satellite as well"+ "<br>"
				+ " as to display and store useful information for the user. This application under continuous developement for educational purposes. The "+ "<br>"
				+ "code is freely available on Github, in Java. We are relying on futur developements to further enhance the application and add more "+ "<br>"
				+ "features (specially from the TAF DCL students to gain a hand on experience in coding <html>)") ;
		helpDescription.setForeground(Color.WHITE);
		TransparentPanel helpDescriptionPanel = new TransparentPanel();
		helpDescriptionPanel.setLayout(new FlowLayout(FlowLayout.LEADING)) ; 
		helpDescriptionPanel.add(helpDescription);
		helpPage.add(titlePanel, BorderLayout.NORTH) ; 
		helpPage.add(helpDescriptionPanel, BorderLayout.CENTER); 
		setContentPane(helpPage);
		helpPage.revalidate() ;
		this.revalidate();
	}





	public  void showDialog(JFrame parentFrame) {
		JDialog dialog = new JDialog(parentFrame, "Metric options", true);


		// Create components for the dialog
		//Create the Naming part
		JLabel labelName = new JLabel("Name :");
		TransparentPanel namepane = new TransparentPanel();
		namepane.setLayout(new BoxLayout(namepane, BoxLayout.LINE_AXIS));
		namepane.add(labelName);
		namepane.add(Box.createHorizontalGlue()) ;
		JTextField inputName = new JTextField();

		//Create the dimension part
		JLabel labelDimension = new JLabel("Dimension :");
		TransparentPanel dimensionpane = new TransparentPanel();
		dimensionpane.setLayout(new BoxLayout(dimensionpane, BoxLayout.LINE_AXIS));
		dimensionpane.add(labelDimension);
		dimensionpane.add(Box.createHorizontalGlue()) ;
		JTextField inputDimension = new JTextField();

		//Create the path of the file 
		JLabel labelPath = new JLabel("Path :");
		TransparentPanel pathPane = new TransparentPanel();
		JFileChooser selectingPath = new JFileChooser();
		MyButton selectPath = new MyButton("browse");
		JTextField inputPath = new JTextField();
		selectPath.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectingPath.showDialog(selectingPath, "select") ; 
				String path = selectingPath.getSelectedFile().getAbsolutePath();
				inputPath.setText(path);
				
			}
		});
		pathPane.setLayout(new BoxLayout(pathPane, BoxLayout.LINE_AXIS));
		pathPane.add(labelPath);
		pathPane.add(Box.createHorizontalGlue()) ;
		


		//Create dialog buttons and layout
		MyButton closeButton = new MyButton("Close");
		MyButton addButton = new MyButton("Add");

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
		TransparentPanel buttonPane = new TransparentPanel() ;
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(addButton) ; 
		buttonPane.add(Box.createRigidArea(new Dimension(10,0)));
		buttonPane.add(closeButton) ; 


		// Add components to the dialog
		TransparentPanel jp = new TransparentPanel();
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
		TransparentPanel inputPathFull = new TransparentPanel() ; 
		inputPathFull.setLayout(new BoxLayout(inputPathFull, BoxLayout.X_AXIS));
		inputPathFull.add(inputPath);
		inputPathFull.add(Box.createRigidArea(new Dimension(5,0)));
		inputPathFull.add(selectPath);
		jp.add(inputPathFull);
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
		buttonNames.add(dimensionName) ; 
		dimensions.add(dimension) ; 
		paths.add(path) ; 
		
		MyButton newDimension = new MyButton(dimensionName) ;
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
		TransparentPanel newAddPanel = new TransparentPanel();
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
