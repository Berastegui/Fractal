package com.draw.fractal;

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.ArrayList;
import java.awt.Color;

public class Fractal
{
    private ArrayList<Fractal> fractals = new ArrayList<Fractal>();
    
    private final double xStart;
    private final double yStart;
    private final double xCenter;
    private final double yCenter;
    private final double length;
    private final double alpha;
    private final double thickness;
    private final int nbIte;
    private final Color color;
    private final int r;
    private final int g;
    private final int b;
    
    
    public Fractal(double xStart, double yStart, double xCenter, double yCenter, int nbIte, ArrayList<Double> xs, ArrayList<Double>ys, double thickness, int r, int g, int b) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.nbIte = nbIte;
        this.thickness=thickness;
        this.color=new Color(r,g,b);
        this.r = r;
        this.g = g;
        this.b = b;
        this.length = Math.sqrt(Math.pow(xCenter-xStart, 2)+Math.pow(yCenter-yStart, 2));
        this.alpha = calculateAlpha(xStart,yStart,xCenter,yCenter);
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
        return calculateAlpha(xCenter,yCenter ,x,y);
    }
    
    private double calculateAlpha(double x0, double y0,double x1, double y1) {
        if(x1==x0) {
            if(y1>y0) {
                return Math.PI/2;
            }
            return -Math.PI/2;
        }
        if(x1>x0) {
            return Math.atan((y1-y0)/(x1-x0));
        }
        return -Math.atan(-(y1-y0)/(x1-x0))+Math.PI;
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
        double r = length0/this.length;
        ArrayList<Double> xsn = new ArrayList<Double>(), ysn = new ArrayList<Double>();
        for(int i =0;i<n;i++) {
            x = xs.get(i);
            y = ys.get(i);
            alpha = calculateAlpha(x, y) + alpha0-this.alpha;
            length = calculateLength(x, y)*r;
            xn = x0 + length*Math.cos(alpha);
            yn = y0 + length*Math.sin(alpha);
            xsn.add(xn);
            ysn.add(yn);
        }
        double thickness = this.thickness*r;
        double l = Math.log(r)*35;
        int rr = this.r+(int)l;
        if(rr<0) {
            rr=0;
        }
        if(rr==0 && this.r>0) {
            rr=1;
        }
        int g = this.g+(int)l;
        if(g<0) {
            g=0;
        }
        if(g==0 && this.g>0) {
            g=1;
        }
        int b = this.b+(int)l;
        if(b<0) {
            b=0;
        }
        if(b==0 && this.b>0) {
            b=1;
        }
        return new Fractal(this.xCenter, this.yCenter,    x0, y0, nbIte-1, xsn, ysn, thickness, rr, g, b);
    }
    
    public void print() {
        System.out.println(this.xStart + ":"+this.yStart + "; "+this.xCenter + ":"+this.yCenter);
        for(Fractal f : fractals) {
            f.print();
        }
    }
    
    public void paintComponent(Graphics2D g){
        for(Fractal f : fractals) {
            f.paintComponent(g);
        }
        int stroke = (int)thickness;
        if(stroke==0) {
            stroke = 1;
        }
        g.setStroke(new BasicStroke (stroke));
        g.setColor(this.color);
        g.drawLine((int)(this.xStart*100), (int)(this.yStart*100), (int)(this.xCenter*100), (int)(this.yCenter*100));
    }
    
    public ArrayList<Double> getPoints() {
        ArrayList<Double> points = new ArrayList<Double>();
        
        points.add(xStart);
        points.add(yStart);
        points.add(xCenter);
        points.add(yCenter);
        
        for(Fractal f : fractals) {
            points.addAll(f.getPoints());
        }
        return points;
    }
    
    
}
