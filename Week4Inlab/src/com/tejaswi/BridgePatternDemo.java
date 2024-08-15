package com.tejaswi;

public class BridgePatternDemo {
	public static void main(String[] args)
	{
	DrawAPI redCircleAPI = new RedCircle();
	Shape redCircle = new Circle(5, 10, 15, redCircleAPI);
	redCircle.draw();
	DrawAPI greenCircleAPI = new GreenCircle();
	Shape greenCircle = new Circle(8, 25, 30, greenCircleAPI);
	greenCircle.draw();
	}


}
