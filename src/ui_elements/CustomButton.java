package ui_elements;

import java.awt.Color;

import javax.swing.JButton;

public class CustomButton extends JButton{

	private Color color ; 
	private Color colorover ; 
	private Color borderColor ; 
	private Color colorClick ; 
	private int radius = 0  ; 
	private boolean over ; 
	
	public CustomButton(String text) {
		setContentAreaFilled(true);
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColorover() {
		return colorover;
	}
	public void setColorover(Color colorover) {
		this.colorover = colorover;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	public Color getColorClick() {
		return colorClick;
	}
	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public boolean isOver() {
		return over;
	}
	public void setOver(boolean over) {
		this.over = over;
	}

	
	
	
	
}
