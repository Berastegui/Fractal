package com.draw.fractal;

import java.util.ArrayList;

import javax.swing.JFrame;

public class DrawFractal
{

    public static void main(String[] args)
    {
        JFrame fenetre = new JFrame();//Définit un titre pour notre fenêtre
        fenetre.setTitle("Ma première fenêtre Java");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(800, 800);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        ArrayList<Double> xs = new ArrayList<Double>(), ys = new ArrayList<Double>();
        
        xs.add((double)3);
        xs.add((double)3);
        
        ys.add((double)1);
        ys.add((double)2);
        
        Fractal f0 = new Fractal(-0.25, 1, 2, 1, 6, xs, ys);
        
        //f0.print();
        
        FractalPanel pan = new FractalPanel(f0.getPoints());
        //Définition de sa couleur de fond    
        //On prévient notre JFrame que notre JPanel sera son content pane
        fenetre.setContentPane(pan);

        fenetre.setContentPane(pan); 
        fenetre.setVisible(true);

    }

}
