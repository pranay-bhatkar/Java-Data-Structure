package greedy.practice;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer[] costVert = {2, 1, 3, 1, 4};
        Integer[] costHor = {4, 1, 2};

        Arrays.sort(costVert, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVert.length) {
            // vertical cost < hor cost
            if (costVert[v] <= costHor[h]) { // horizontal cuts
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else { // vertical cuts
                cost += (costVert[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVert.length) {
            cost += (costVert[v] * hp);
            vp++;
            v++;
        }
        System.out.println("min cost of cuts = " + cost);
    }

}