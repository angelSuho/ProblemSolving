package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빗물 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[] arr = new int[w];

        for(int i = 0; i < w; i++) {
            arr[i] = sc.nextInt();
        }

//        List<Integer> hw = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).toList();
//        List<Integer> lst = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).toList();

        int rlt = 0;

        for(int i = 1; i < w - 1; i++) {

            int left = 0, right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(arr[j], left);
            }
            for(int j = i + 1; j < w; j++) {
                right = Math.max(arr[j], right);
            }
            if(arr[i] < left && arr[i] < right) {
                rlt += Math.min(left, right) - arr[i];
            }
        }
        System.out.println(rlt);
    }
}