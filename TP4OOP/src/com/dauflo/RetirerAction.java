package com.dauflo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetirerAction implements ActionListener {

	private ZoneDessin currentZone;

	public RetirerAction(ZoneDessin dessin) {
		currentZone = dessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		currentZone.formes.remove(currentZone.formes.size() - 1);
	}

}
