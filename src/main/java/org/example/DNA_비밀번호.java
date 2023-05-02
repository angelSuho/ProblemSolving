package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DNA_비밀번호 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Map<Character, Integer> cond;
    static LinkedList<Character> queue;

    public static void main(String[] args) throws IOException {

        List<Integer> list = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).toList();

        String[] pwd = bf.readLine().split("");

        List<Integer> cnt = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).toList();

        MapInitialize(cnt);

        for (int idx = 0; idx < pwd.length; idx++) {

        }


    }

    private static void MapInitialize(List<Integer> cnt) {
        cond.put('A', cnt.get(0));
        cond.put('C', cnt.get(1));
        cond.put('G', cnt.get(2));
        cond.put('T', cnt.get(3));
    }
}
