package com.dauflo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


public class ZoneDessin extends Component implements KeyListener, MouseListener {
	public ArrayList<Forme2D> formes;

	public ZoneDessin(ArrayList<Forme2D> formes) {
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		this.formes = formes;
	}

	@Override
	public void paint(Graphics g) {

		for (int i = 0; i < formes.size(); i++) {
			formes.get(i).draw(g);
			;
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int size = (int) (Math.random() * 100);
		Random rng = new Random();
		float r = rng.nextFloat();
		float g = rng.nextFloat();
		float b = rng.nextFloat();

		Color randomColor = new Color(r, g, b);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_D :
			if (formes.size() > 0) {
				formes.remove(formes.size() - 1);
			}
			break;
		case KeyEvent.VK_R : 
			
			Carre carre = new Carre();
			carre.origine = new Point2D(getWidth() / 2 - size / 2, getHeight() / 2 - size / 2);
			carre.couleur(randomColor);
			carre.Taille(size);
			formes.add(carre);
			break;
		case KeyEvent.VK_C :
			Cercle cercle = new Cercle();
			cercle.origine = new Point2D(getWidth() / 2 - size / 2, getHeight() / 2 - size / 2);
			cercle.couleur(randomColor);
			cercle.Taille(size);
			formes.add(cercle);
		case KeyEvent.VK_T :
			for (int i = 0; i < formes.size(); i++) {
				for (int j = 1; j < formes.size() - i; j++) {
					int c1 = formes.get(j).getSize();
					int c2 = formes.get(j - 1).getSize();
					if (c1 > c2) {
						Forme2D grand = formes.get(j - 1);
						formes.set(j - 1, formes.get(j));
						formes.set(j, grand);
					}
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			System.out.println("right clic");
		} else if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			Point p = MouseInfo.getPointerInfo().getLocation();
			
			System.out.println(p.getX());
			System.out.println(p.getY());
			
			for(int i = formes.size() - 1; i >= 0; i--) {
				Point2D formesPos = formes.get(i).origine;
				int longueur = formes.get(i).getSize();
				
				System.out.println(longueur);
				System.out.println(formesPos.getx());
				System.out.println(formesPos.gety());
				
				if ((p.getY() >= formesPos.gety() && p.getY() <= formesPos.gety() + longueur)){
					System.out.println("in");
				} else {
					System.out.println("out");
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
