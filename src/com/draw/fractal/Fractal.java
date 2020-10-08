package com.draw.fractal;

import java.util.ArrayList;

public class Fractal
{
    private ArrayList<Fractal> fractals = new ArrayList<Fractal>();
    
    private final double xStart;
    private final double yStart;
    private final double xCenter;
    private final double yCenter;
    private final double length;
    private final double alpha;
    private final int nbIte;
    
    public Fractal(double xStart, double yStart, double xCenter, double yCenter, int nbIte, ArrayList<Double> xs, ArrayList<Double>ys) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.nbIte = nbIte;
        this.length = Math.sqrt(Math.pow(xCenter-xStart, 2)+Math.pow(yCenter-yStart, 2));
        this.alpha = xCenter==xStart?0:Math.atan((yCenter-yStart)/(xCenter-xStart));
        if(nbIte>0) {
            int n = xs.size();
            for(int i =0; i<n; i++) {
                fractals.add(getSubFractal(xs, ys, i));
            }
        }
    }
    
    private double calculateLength(double x, double y) {
        return Math.sqrt(Math.pow(x-xCenter, 2)+Math.pow(y-yCenter, 2));
    }
    
    private double calculateAlpha(double x, double y) {
        return x==xCenter?0:Math.atan((y-yCenter)/(x-xCenter));
    }
    
    private Fractal getSubFractal(ArrayList<Double> xs, ArrayList<Double>ys, int rank) {
        int n = xs.size();
        if(n<=rank) {
            return null;
        }
        final double x0 = xs.get(rank), y0 = ys.get(rank);
        final double alpha0 = calculateAlpha(x0, y0);
        final double length0 = calculateLength(x0, y0);
        double x = 0,y =0, alpha = 0, length = 0;
        double xn = 0,yn =0;
        ArrayList<Double> xsn = new ArrayList<Double>(), ysn = new ArrayList<Double>();
        for(int i =0;i<n;i++) {
            x = xs.get(i);
            y = ys.get(i);
            alpha = calculateAlpha(x, y) + alpha0-this.alpha;
            length = calculateLength(x, y)*length0/this.length;
            xn = x0 + length*Math.cos(alpha);
            yn = y0 + length*Math.sin(alpha);
            xsn.add(xn);
            ysn.add(yn);
        }
        return new Fractal(this.xCenter, this.yCenter, x0, y0, nbIte-1, xsn, ysn);
    }
    
    public void print() {
        System.out.println(this.xStart + ":"+this.yStart + "; "+this.xCenter + ":"+this.yCenter);
        for(Fractal f : fractals) {
            f.print();
        }
    }
    
    
}
