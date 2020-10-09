package com.draw.fractal;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class FractalPanel extends JPanel
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private final ArrayList<Double> points;
    private final int nb;
    
    public FractalPanel(ArrayList<Double> points) {
        super();
        this.points = points;
        nb = points.size()/4;
    }

    public void paintComponent(Graphics g){
        for(int i =0;i<nb; i++) {
            g.drawLine((int)(points.get(4*i)*100), (int)(points.get(4*i+1)*100), (int)(points.get(4*i+2)*100), (int)(points.get(4*i+3)*100));
        }
    }
}
