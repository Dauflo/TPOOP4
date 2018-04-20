package com.dauflo;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Forme2D implements Comparable<Forme2D>{

	protected static int NbForme;
	
	protected Point2D origine;
	protected Color couleur;
	
	
	
	public Forme2D(){
		origine=new Point2D();
		couleur=Color.BLUE;
		NbForme++;
	}
	
	public Forme2D (Color couleur,int x, int y) throws WrongOriginException{
		if (x>=0 && y>=0){
		origine=new Point2D(x,y);}
		else{
			throw new WrongOriginException();
		}
		
		this.couleur=couleur;
		NbForme++;
		
	}
	public Color getcolor(){return couleur;}
	public void setcolor(Color couleur){ this.couleur = couleur;}
	
	
	abstract double Surface();
		 
	
	public void Deplacer(int dx, int dy) {
		origine.x +=dx;
		origine.y +=dy;
	}
	
	abstract void Taille(int Taille);
	
	//Ajout de la methode pour le tri des formes
	abstract int getSize();
	
		
	public Point2D Centre() {
		return origine;
	}	
	
	public String toString(){
			
	
		return "(" + origine.getx() + "," + origine.gety() + ")" + ":" + couleur;
	}
	
	public int compareTo(Forme2D n){
		if (Surface()< n.Surface())
			return 1;
		if (Surface()> n.Surface())
			return -1;
		else 
			return 0;
				
	}
	abstract void draw(Graphics g);
}
