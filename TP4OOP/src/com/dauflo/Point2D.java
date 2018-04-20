package com.dauflo;
/*Alan GOBIN FIP 1A TIS*/

public class Point2D {

	int x,y;
	
	public Point2D(){
		x=0;
		y=0;
		
	}
	
	public Point2D (int x, int y){
		this.x=x;
		this.y=y;
				
	}
	public int getx(){return x;}
	public void setx(int x){ this.x = x;}
	public int gety(){return y;}
	public void sety(int y){this.y=y;}
	
	public String toString(){
		return "(" + x + "," + y + ")";
		
	}
	
}
