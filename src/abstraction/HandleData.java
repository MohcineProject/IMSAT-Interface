package abstraction;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import exceptions.InvalidDataException;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HandleData {


	
	public ChartPanel createChart(String path, String chartTitle, String xLabel, String yLabel) throws NumberFormatException, IOException {
        //Get data 
		ArrayList<int[]> points = this.returnData(path);
		// Create a data Set
        XYSeries series = new XYSeries("XY Series");
        //Populate data set : 
        for (int i = 0 ; i< points.size() ; i++) {
        	series.add(points.get(i)[0],points.get(i)[1]) ; 
        }
        //Create the collection
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        // Create a chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                chartTitle,  // Chart title
                xLabel ,     // X-axis label
                yLabel ,     // Y-axis label
                dataset      //Data Set
        );

        // Create and set up the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel ;
        
	}
	
	
	
	

	public ArrayList<int[]> returnData(String filePath) throws NumberFormatException, IOException {
		ArrayList<int[]> points = new ArrayList<int[]>() ; 
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {

				try{
					int x ; 
					int y ; 
					String[] values = line.replaceAll("[()]", "").split(";");
					x = Integer.parseInt(values[0]) ; 
					y = Integer.parseInt(values[1]) ; 
					int[] point = {x,y} ;
					points.add(point) ; 
				}
				catch(InvalidDataException e ) {
					throw e ; 
				}
			}
		} catch (IOException e) {
			throw e ;

		}
		
		return points ;
	}
	
	public void screenShot(String filePath, Component component) {
	      try {
	          
	    	  	System.out.println("Starting .....");
	            BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_ARGB);
	            Graphics graphics = image.getGraphics();
	            component.paint(graphics);
	            graphics.dispose();
	            System.out.println("Ending .....");
	            File output = new File(filePath);
	            ImageIO.write(image, "png", output);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	      
	      
	} 
		
		
		
	public void writeIntoFile(String fileName, String text ) {
		fileName = fileName + ".IMSAT" ; 
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
	            writer.write(text);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public ArrayList<String[]>  captureData (String fileName) {
		ArrayList<String[]> list = new ArrayList<String[]>() ; 
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String line ; 
			while((line = reader.readLine()) != null) {
				String[] data = line.split(";") ;
				list.add(data) ; 
				
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return list ; 
		
	}

}
