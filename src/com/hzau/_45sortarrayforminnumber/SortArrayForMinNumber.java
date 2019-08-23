package com.hzau._45sortarrayforminnumber;

import java.util.*;

/**
 * @description:    面试题45：把数组排成最小的数
 * @author: Dafengsu
 * @date: 2019/8/18
 */
public class SortArrayForMinNumber {
    public String printMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : numbers) {
            list.add(value);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str1.compareTo(str2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Integer value : list) {
            sb.append(value);
        }
        return String.valueOf(sb);
    }
    public String printMinNumber2(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int temp;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (compare(numbers[i], numbers[j])) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for (int value : numbers) {
            res.append(value);
        }
      /*  res.append(Arrays.toString(numbers));*/

        return String.valueOf(res);
    }

    private boolean compare(int first, int second) {
        String s1 = String.valueOf(first);
        String s2 = String.valueOf(second);
        String str1 = s1 + s2;
        String str2 = s2 + s1;
        return Integer.parseInt(str1) > Integer.parseInt(str2);
    }
}
