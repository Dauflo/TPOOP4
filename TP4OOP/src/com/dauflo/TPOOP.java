package com.dauflo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TPOOP extends JFrame {
	private static ArrayList<Forme2D> formes;
	private static ZoneDessin dessin;
	

	private static final JRadioButton carreRadio = new JRadioButton("Carre");

	public static void main(String[] args) {
		formes = new ArrayList<Forme2D>();
		JFrame myFrame = new JFrame("Frame Title");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(500, 500);
		myFrame.setResizable(false);

		Container myPanel = myFrame.getContentPane();
		JLabel tpLabel = new JLabel("TP4");
		myPanel.add(tpLabel, BorderLayout.NORTH);
		dessin = new ZoneDessin(formes);
		myPanel.add(dessin, BorderLayout.CENTER);
		//myPanel.add(createButton(), BorderLayout.SOUTH);
		myFrame.setContentPane(myPanel);
		myFrame.show();

	}

	private static JPanel createButton() {
		final JPanel pane = new JPanel();
		pane.setBackground(Color.BLUE);

		final JButton add = new JButton("+");
		ActionAjouter addAction = new ActionAjouter(dessin);
		add.addActionListener(addAction);
		pane.add(add);
		final JButton remove = new JButton("-");
		RetirerAction removeAction = new RetirerAction(dessin);
		remove.addActionListener(removeAction);
		pane.add(remove);
		final JButton tri = new JButton("Tri");
		TriBySize triAction = new TriBySize(dessin);
		tri.addActionListener(triAction);
		pane.add(tri);
		carreRadio.setActionCommand("carre");
		carreRadio.setSelected(true);
		JRadioButton cercleRadio = new JRadioButton("Cercle");
		cercleRadio.setActionCommand("cerlce");

		ButtonGroup groupB = new ButtonGroup();
		groupB.add(carreRadio);
		groupB.add(cercleRadio);

		pane.add(carreRadio);
		pane.add(cercleRadio);
		return pane;
	}

	public static boolean getCarreRadioSelected() {
		return carreRadio.isSelected();
	}
}
