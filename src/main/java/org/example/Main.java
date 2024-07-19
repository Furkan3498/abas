package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Given data
        int[][] data = {
                {1000, 2000, 12, 10051},
                {1000, 2001, 31, 20000},
                {1000, 2002, 22, 15086},
                {1000, 2003, 41, 25000},
                {1000, 2004, 55, 24400},
                {1001, 2001, 88, 44531},
                {1001, 2002, 121, 8811},
                {1001, 2004, 74, 21100},
                {1001, 2002, 14, 8811},
                {1002, 2003, 2, 1210},
                {1002, 2004, 3, 2230},
                {1002, 2003, 8, 1210},
                {1002, 2002, 7, 8811},
                {1002, 2005, 9, 4410},
                {1002, 2006, 19, 9000}
        };

        int totalAmount = 0;
        for (int[] order : data) {
            int quantity = order[2];
            int unitPrice = order[3];
            totalAmount += quantity * unitPrice;
        }
        System.out.println("Toplam Tutar: " + totalAmount / 100.0 + " TL");

        double totalUnitPrice = 0;
        int itemCount = 0;
        for (int[] order : data) {
            int unitPrice = order[3];
            totalUnitPrice += unitPrice;
            itemCount++;
        }
        double averageUnitPrice = totalUnitPrice / itemCount;
        System.out.println("Ortalama Fiyatlaar: " + averageUnitPrice / 100.0 + " TL");

        Map<Integer, Double> itemTotalPrice = new HashMap<>();
        Map<Integer, Integer> itemCountt = new HashMap<>();

        for (int[] order : data) {
            int itemNumber = order[1];
            int unitPrice = order[3];

            itemTotalPrice.put(itemNumber, itemTotalPrice.getOrDefault(itemNumber, 0.0) + unitPrice);
            itemCountt.put(itemNumber, itemCountt.getOrDefault(itemNumber, 0) + 1);
        }

        for (Map.Entry<Integer, Double> entry : itemTotalPrice.entrySet()) {
            int itemNumber = entry.getKey();
            double averagePrice = entry.getValue() / itemCountt.get(itemNumber);
            System.out.println("Ürün " + itemNumber + " ortalama ürün fiyatı: " + averagePrice / 100.0 + " TL");
        }
        Map<Integer, Integer> itemOrderCount = new HashMap<>();

        for (int[] order : data) {
            int itemNumber = order[1];
            itemOrderCount.put(itemNumber, itemOrderCount.getOrDefault(itemNumber, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : itemOrderCount.entrySet()) {
            System.out.println("Ürün " + entry.getKey() + " sipariş fiyatı: " + entry.getValue());
        }
    }
}