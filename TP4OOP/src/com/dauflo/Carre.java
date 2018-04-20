package com.dauflo;

import java.awt.Color;
import java.awt.Graphics;

public class Carre extends Forme2D {

	private int Longeur;
	private static int NbCarre = 0;
	private Color color;

	public Carre() {
		NbCarre++;
		Longeur = 0;

	}

	public Carre(int Longeur) throws WrongSeizeException {
		if (Longeur > 0) {
			this.Longeur = Longeur;
		} else
			throw new WrongSeizeException();
	}

	public void Taille(int NouvLongeur) {
		Longeur = NouvLongeur;
	}

	public double Surface() {
		return Longeur * Longeur;
	}

	public String toString() {

		return "Carre :" + "(" + origine.getx() + "," + origine.gety() + ")" + Longeur + ":" + couleur + ":"
				+ Surface();
	}

	public void couleur(Color c) {
		color = c;
	}

	public int getX() {
		return origine.getx();
	}

	public int getY() {
		return origine.gety();
	}

	public int getLongeur() {
		return Longeur;
	}

	public void draw(Graphics g) {
		g.drawRect(getX(), getY(), Longeur, Longeur);
		if (color != null) {
			g.setColor(color);
		} else {
			g.setColor(Color.BLACK);
		}
		g.fillRect(getX() + 1, getY() + 1, Longeur - 1, Longeur - 1);
	}

	@Override
	int getSize() {
		return Longeur;
	}
}