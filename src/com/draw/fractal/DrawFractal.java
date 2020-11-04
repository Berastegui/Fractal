package com.draw.fractal;

import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JFrame;

public class DrawFractal
{

    public static void main(String[] args)
    {
        JFrame fenetre = new JFrame();//Définit un titre pour notre fenêtre
        fenetre.setTitle("Ma première fenêtre Java");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(1000, 1000);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        ArrayList<Double> xs = new ArrayList<Double>(), ys = new ArrayList<Double>();
        
        xs.add((double)2.2);
        xs.add((double)3.5);
        
        ys.add((double)2.2);
        ys.add((double)3.5);
        
        Fractal f0 = new Fractal(0, 3, 2, 3, 20, xs, ys,40,100,100,255);
        
        //f0.print();
        
        FractalPanel pan = new FractalPanel(f0);
        //Définition de sa couleur de fond    
        //On prévient notre JFrame que notre JPanel sera son content pane
        fenetre.setContentPane(pan);
        fenetre.setBackground(Color.black);

        fenetre.setContentPane(pan); 
        fenetre.setVisible(true);

    }

}
