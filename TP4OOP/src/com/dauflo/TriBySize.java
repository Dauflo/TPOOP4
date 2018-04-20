package com.dauflo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TriBySize implements ActionListener {
	private ZoneDessin currentZone;
	
	public TriBySize(ZoneDessin dessin) {
		currentZone = dessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Begin sort");
		bubbleSort(currentZone.formes);
		System.out.println("End sort");
		
	}
	
	static ArrayList<Forme2D> bubbleSort(ArrayList<Forme2D> array) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 1; j < array.size() - i; j++) {
				int c1 = array.get(j).getSize();
				int c2 = array.get(j - 1).getSize();
				if (c1 > c2) {
					Forme2D grand = array.get(j - 1);
					array.set(j - 1, array.get(j));
					array.set(j, grand);
				}
			}
		}
		return array;
	}

}
