package com.hzau._38stringpermutation;

import java.util.*;

/**
 * @description:    面试题38：字符串排列
 * @author: Dafengsu
 * @date: 2019/8/9
 */
public class StringPermutation {
    /**
     * 全排列：递归法
     * @param str   排列的数组
     * @return  结果链表
     */
    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        Set<Character> charSet = new HashSet<Character>();
        char[] chars = str.toCharArray();

        permutationCore(chars, 0, res);
        Collections.sort(res);
        return res;
    }

    /**
     * 字符全排列的核心代码
     * @param chars 排列的字符数组
     * @param index 被交换的字符下标
     * @param list  结果收集链表
     */
    private void permutationCore(char[] chars, int index, ArrayList<String> list) {
        //如果被交换的位置已经是字符数组的最后一位，直接输出结果
        if (index == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            //针对当前位置（index）,确定所有可能的数
            for (int i = index; i < chars.length; i++) {
                //判断当前被交换位置，是否需要和次交换位置交换
                if (isSwap(chars, index, i)) {
                    //交换位置
                    swap(chars, index, i);
                    //对下一个位置进行递归排列
                    permutationCore(chars, index + 1, list);
                    //恢复排列
                    swap(chars, i, index);
                }
            }
        }
    }

    /**
     * 判断字符串是否需要交换
     * 思路：如果被交换为位置和交换位置之间存在与交换位置想等的值，就无须再交换了
     * 如：abb,判断第一个位置a是否需要和第三个位置的b交换，由于第二个位置也是b,和第三个位置一直，所以无须交换
     * 同样aab,可以判断第一个a和第二个a也无须交换。
     * @param chars 字符数组
     * @param index 被交换位置
     * @param end   交换位置
     * @return
     */
    private boolean isSwap(char[] chars, int index, int end) {
        for (int i = index; i < end; i++) {
            if (chars[i] == chars[end]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 全排列：字典法
     * @param str
     * @return
     */
    public ArrayList<String> permutation2(String str) {
        ArrayList<String> resList = new ArrayList<>();
        if(str==null || str.length()==0){
            return resList;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        resList.add(String.valueOf(chars));
        int length = chars.length;
        while(true){
            int lIndex = length-1;
            int rIndex;
            //从尾部找，找到第一个前一个字符要小于后一个字符的字符
            while(lIndex>=1 && chars[lIndex-1]>=chars[lIndex]){
                lIndex--;
            }
            //如果前一个字符都大于后一个字符，遍历结束
            if(lIndex == 0) {
                break;
            }
            //记录当前字符位置（既前一个字符要小于当前字符的当前字符位置）
            rIndex = lIndex;
            //从当前位置往后找一个大于当前位置前一个值的最小值
            while (rIndex < length && chars[rIndex] > chars[lIndex - 1]) {
                rIndex++;
            }
            //交换两个值
            swap(chars, lIndex - 1, rIndex - 1);
            //反转当前值后面的值
            reverse(chars, lIndex);
            resList.add(String.valueOf(chars));
        }
        return resList;
    }
    /**
     * 字符交换
     * @param chars 字符数组
     * @param first  交换的第一个字符
     * @param second 交换的第二个字符
     */
    private void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }

    private void reverse(char[] chars,int k){
        if(chars==null || chars.length<=k) {
            return;
        }
        int len = chars.length;
        for(int i=0;i<(len-k)/2;i++){
            int m = k+i;
            int n = len-1-i;
            if(m<=n){
                swap(chars,m,n);
            }
        }

    }

    /**
     * 计算数组中所有和为目标值的可能组合
     *
     * @param numbers 数组
     * @param target  和
     * @return 组合
     */
    public ArrayList<ArrayList<Integer>> sumOfArrays(int[] numbers, int target) {
        //创建结果链表
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        //如果是空值，直接返回空值
        if (numbers == null || numbers.length == 0) {
            return resList;
        }
        sumOfArrays(numbers, target, 0, resList, new ArrayList<Integer>());
        return resList;
    }

    /**
     * 计算数组中所有和为目标值的可能组合
     *
     * @param numbers 数组
     * @param target  目标值
     * @param start   判断的数的下标
     * @param resList 结果链表
     * @param subList 路径记录链表
     */
    private void sumOfArrays(int[] numbers, int target, int start, ArrayList<ArrayList<Integer>> resList, ArrayList<Integer> subList) {
        //如果当前值等于目标值
        if (numbers[start] == target) {
            //把当前值加入到路径链表
            subList.add(numbers[start]);
            //把当前值复制到路径链表
            resList.add(new ArrayList<>(subList));
            //直接返回
            return;
        }
        //如果数组还未越界
        if (start < numbers.length - 1) {
            //创建一个新的路径链表
            ArrayList<Integer> newSubList = new ArrayList<>(subList);
            //把当前值加入都新的路径表中
            newSubList.add(numbers[start]);
            //路径包含当前值
            sumOfArrays(numbers, target - numbers[start], start + 1, resList, newSubList);
            //路径不包含当前值
            sumOfArrays(numbers, target, start + 1, resList, subList);
        }
    }
}
