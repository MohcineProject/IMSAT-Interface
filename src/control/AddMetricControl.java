package control;

import java.io.IOException;

import org.jfree.chart.ChartPanel;

import abstraction.HandleData; 

import presentation.FrameIMSAT;

public class AddMetricControl {
	FrameIMSAT fr ; 
	HandleData handleData ; 
	public AddMetricControl(FrameIMSAT fr) {
		this.fr = fr ; 
		handleData = new HandleData() ; 
	}
	public void addMetricButton( String dimensionName, String dimension , String path) {
		fr.addMetricToNtemplate( dimensionName, dimension, path);
		
		
	}
	
	public void showContent(String path,String chartTitle, String xLabel, String yLabel ) throws NumberFormatException, IOException {
		ChartPanel chartPanel = handleData.createChart(path, chartTitle, xLabel, yLabel) ;
		fr.setGraphContent(chartPanel);
		
	}
	
	
	
}
