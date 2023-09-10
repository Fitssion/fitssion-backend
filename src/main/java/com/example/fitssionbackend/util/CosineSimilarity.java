package com.example.fitssionbackend.util;

import java.util.List;

public class CosineSimilarity {

    public static double[] integerListToDoubleArray(List<Integer> target) {
        double[] vector = new double[18];
        for (int i = 0; i < 18; i++) {
            if (target.contains(i)) {
                vector[i] = 1;
            }
        }
        return vector;
    }

    public static Double cosineSimilarity(double[] a, double[] b) {
        if (a == null || b == null || a.length < 1 || b.length < 1 || a.length != b.length)
            return Double.NaN;
        double sum = 0.0, sum_a = 0, sum_b = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
            sum_a += a[i] * a[i];
            sum_b += b[i] * b[i];
        }
        double val = Math.sqrt(sum_a) * Math.sqrt(sum_b);
        return sum / val;
    }
}
