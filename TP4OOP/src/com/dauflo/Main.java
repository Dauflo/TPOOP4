package com.dauflo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;

public class Main {
	static JTextField textFieldTaille,textFieldX,textFieldY,textFieldColor;
	static JTextArea infos;
	static ArrayList<Forme2D> formes;
	public static void main(String[] args) throws WrongSeizeException, NumberFormatException, IOException{
		 formes = new ArrayList<Forme2D>();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 createPanel();
		 
		 for (int i = 0; i < 10; i++) {	 
			 if(i < 5) {
				 System.out.print("Carré; entrez un nombre  = ");
				 int info = Integer.parseInt(br.readLine());
				 Carre forme = new Carre(info);
				 formes.add(forme);
			 }else {
				 System.out.print("Cercle; entrez un nombre  = ");
				 int info = Integer.parseInt(br.readLine());
				 Cercle forme = new Cercle(info);
				 formes.add(forme);
			 }			 
		 }
		 
		 getNumber();
		 
	}
	
	public static void getNumber() {
			//Acceder au nbCarre pour avoir le nombre de carré
			//Acceder au nbCercle pour le nombre de cercle
		
			int nbForme = Forme2D.NbForme;
			System.out.println(nbForme);
	}
	
	public static void addToInfos() {
		infos.setText(""); // on clean d'abord les infos 
		String infosText ="";
		for (Forme2D forme: formes) {
		    infosText += forme.toString()+"\n";
		}
		infos.setText(infosText);
	}
	
	public static void trieFormes() {
		for (Forme2D forme: formes) {
		    //modifier variable formes en utilisant forme.compareTo
			//ici la variable forme = chaque item de la liste
		}
		addToInfos();
	}
	
	public static void removeBigger() {
		trieFormes();
		formes.remove(0); //Supprime le premier éléments après un trie, donc le plus gros
		addToInfos();
	}
	
	public static void createPanel() {
		JFrame fenetre = new JFrame();
	    fenetre.setVisible(true);
	    fenetre.setTitle("FIP Java TP3");
	    fenetre.setSize(300, 500);
	    fenetre.setLocationRelativeTo(null);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel pan = new JPanel();
	    textFieldColor = new JTextField("Entrez une couleur");      
		pan.add(textFieldColor);
		
	    textFieldTaille = new JTextField("Entrez une taille");      
		pan.add(textFieldTaille);
		
		textFieldX = new JTextField("Coordonée d'origine x");      
		pan.add(textFieldX);
		textFieldY = new JTextField("Coordonée d'origine y");      
		pan.add(textFieldY);
		
		JButton createCircle = new JButton("Cercle"); //Bouton Cercle pour créer un Cercle
		createCircle.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				Cercle forme;
				try {
					forme = new Cercle(Integer.parseInt(textFieldTaille.getText()));
					forme.origine = new Point2D(Integer.parseInt(textFieldX.getText()),Integer.parseInt(textFieldY.getText()));
					forme.couleur = Color.getColor(textFieldColor.getText());
					formes.add(forme);
					addToInfos();
				} catch (NumberFormatException | WrongSeizeException e1) {
					e1.printStackTrace();
				}
				 
			  }
		});;
		pan.add(createCircle);
		
		JButton createCarre = new JButton("Carre"); //Bouton Carré
		createCarre.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				Carre forme;
				try {
					forme = new Carre(Integer.parseInt(textFieldTaille.getText()));
					forme.origine = new Point2D(Integer.parseInt(textFieldX.getText()),Integer.parseInt(textFieldY.getText()));
					forme.couleur = Color.getColor(textFieldColor.getText());
					formes.add(forme);
					addToInfos();
				} catch (NumberFormatException | WrongSeizeException e1) {
					e1.printStackTrace();
				}
				 
			  }
		});
		pan.add(createCarre);
		
		JButton supp = new JButton("Supprimer"); //Bouton Supprimer
		createCarre.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  removeBigger();
			  }
		});
		pan.add(supp);
		
		infos = new JTextArea("Infos");
		pan.add(infos);
		fenetre.add(pan);
		fenetre.setVisible(true);
	}
}
