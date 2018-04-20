package com.dauflo;

import java.awt.Color;
import java.awt.Graphics;

/*Alan GOBIN FIP 1A TIS*/

public class Cercle extends Forme2D {
	private int Rayon;
	private static int NbCercle = 0;
	private Color color;
	
	
	public Cercle(){
		NbCercle++;
		Rayon=0;
	
	}
	
	public Cercle(int Rayon)throws WrongSeizeException{
			
		if(Rayon>0){
				this.Rayon=Rayon;
			}
			else 
				throw new WrongSeizeException();
		this.Rayon=Rayon;
		
	}
		
	public void Taille (int NouvRayon) {
		Rayon=NouvRayon;
	}
	
	public double Surface() {
		return Math.PI*Rayon*Rayon;
	}
	
	public String toString(){
		
		
		return "Cercle :" + "(" + origine.getx() + "," + origine.gety() + ")" + Rayon + ":" + couleur + ":" + Surface();
	}
	
	public void couleur(Color c) {
		color = c;
	}

	public int getX(){return origine.getx();}	
	public int getY(){return origine.gety();}
	
	public int getRayon(){return Rayon;}
	
	public void draw(Graphics g){
		g.drawOval(getX(),getY(),Rayon,Rayon);
		if (color != null) {
			g.setColor(color);
		} else {
			g.setColor(Color.BLACK);
		}
		g.fillOval(getX()+1,getY()+1,Rayon-1,Rayon-1);
	}

	@Override
	int getSize() {
		return Rayon * 2;
	}
}
