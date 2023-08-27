package com.example.fitssionbackend.util;

public class CosineSimilarity {

    public static void main(String[] args) {
        CosineSimilarity cm = new CosineSimilarity();
        double[] a = {1, 1, 1, 1, 0, 0, 0};
        double[] b = {1, 1, 0, 0, 1, 1, 0};
        double[] c = {0, 1, 1, 1, 0, 1, 1};
        System.out.println(cm.cosineSimilarity(a, b));
        System.out.println(cm.cosineSimilarity(a, c));
        System.out.println(cm.cosineSimilarity(b, c));
    }

    public Double cosineSimilarity(double[] a, double[] b) {
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
