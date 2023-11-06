import java.util.*;

public class Solution {
    
    private static int maxSubscribe = 0;
    private static int maxSale = 0;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] discountArr = new int[emoticons.length];
        generateDiscounts(users, emoticons, discountArr, 0);
        return new int[]{maxSubscribe, maxSale};
    }

    private static void generateDiscounts(int[][] users, int[] emoticons, int[] discountArr, int idx) {
        if (idx == emoticons.length) {
            calculatedPrice(users, emoticons, discountArr);
            return;
        }

        for (int discount : new int[]{10, 20, 30, 40}) {
            discountArr[idx] = discount;
            generateDiscounts(users, emoticons, discountArr, idx + 1);
        }
    }

    private static void calculatedPrice(int[][] users, int[] emoticons, int[] discountArr) {
        int subscribe = 0;
        int sale = 0;

        for (int[] user : users) {
            int expectedPrice = 0;
            for (int i = 0; i < emoticons.length; i++) {
                int discountedPrice = emoticons[i] * (100 - discountArr[i]) / 100;
                if (discountArr[i] >= user[0]) {
                    expectedPrice += discountedPrice;
                }
            }
            if (expectedPrice >= user[1]) {
                subscribe++;
            } else {
                sale += expectedPrice;
            }
        }

        if (subscribe > maxSubscribe || (subscribe == maxSubscribe && sale > maxSale)) {
            maxSubscribe = subscribe;
            maxSale = sale;
        }
    }
    
}
