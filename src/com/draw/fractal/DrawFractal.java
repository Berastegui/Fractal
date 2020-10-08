package com.draw.fractal;

import java.util.ArrayList;

public class DrawFractal
{

    public static void main(String[] args)
    {
        ArrayList<Double> xs = new ArrayList<Double>(), ys = new ArrayList<Double>();
        
        xs.add((double)3);
        xs.add((double)3);
        
        ys.add((double)0);
        ys.add((double)1);
        
        Fractal f0 = new Fractal(0, 0, 2, 0, 2, xs, ys);
        
        f0.print();

    }

}
