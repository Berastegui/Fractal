package com.draw.fractal;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class FractalPanel extends JPanel
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    //private final ArrayList<Double> points;
    //private final int nb;
    private final Fractal fractal;
    
   /* public FractalPanel(ArrayList<Double> points) {
        super();
        this.points = points;
        nb = points.size()/4;
    }*/
    
    public FractalPanel(Fractal fractal) {
        super();
        this.fractal = fractal;
        this.setOpaque(true);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        this.fractal.paintComponent(g2);
    }
}
