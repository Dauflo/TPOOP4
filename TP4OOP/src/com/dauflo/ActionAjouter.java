package com.dauflo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ActionAjouter implements ActionListener {

	private ZoneDessin currentZone;

	

	public ActionAjouter(ZoneDessin dessin) {
		this.currentZone = dessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int size = (int) (Math.random() * 100);
		Random rng = new Random();
		float r = rng.nextFloat();
		float g = rng.nextFloat();
		float b = rng.nextFloat();

		Color randomColor = new Color(r, g, b);
		
		boolean carreSelect = TPOOP.getCarreRadioSelected();
		if (carreSelect) {
			Carre carre = new Carre();
			carre.origine = new Point2D(currentZone.getWidth() / 2 - size / 2, currentZone.getHeight() / 2 - size / 2);
			carre.couleur(randomColor);
			carre.Taille(size);
			currentZone.formes.add(carre);
		} else {
			Cercle cerle = new Cercle();
			cerle.origine = new Point2D(currentZone.getWidth() / 2 - size / 2, currentZone.getHeight() / 2 - size / 2);
			cerle.couleur(randomColor);
			cerle.Taille(size);
			currentZone.formes.add(cerle);
		}
	}
}
