package com.geekerstar.dp.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author geekerstar
 * @date 2020/10/7 15:18
 * @description
 */
public class Practice4 {

    private static void getMinCountsHelper(int total, int[] values, ArrayList<Integer> currentCounts, ArrayList<ArrayList<Integer>> combinations) {
        if (0 == total) {
            // 如果余额为0，说明当前组合成立，将组合加入到待选数组中
            combinations.add(new ArrayList<>(currentCounts));
            return;
        }
        int valueLength = values.length;
        // 遍历所有面值
        for (int i = 0; i < valueLength; i++) {
            int currentValue = values[i];
            // 如果面值大于当前总额，直接跳过
            if (currentValue > total) {
                continue;
            }
            // 否则在当前面值数量组合上的对应位置加1
            ArrayList<Integer> newCounts = new ArrayList<>(currentCounts);
            newCounts.set(i, newCounts.get(i) + 1);
            int rest = total - currentValue;
            // 求解剩余额度所需硬币数量
            getMinCountsHelper(rest, values, newCounts, combinations);
        }
    }

    private static int getMinimumHelper(ArrayList<ArrayList<Integer>> combinations) {
        // 如果没有可用组合，返回-1
        if (0 == combinations.size()) {
            return -1;
        }
        int minCount = Integer.MAX_VALUE;
        for (ArrayList<Integer> counts : combinations) {
            int total = 0;
            // 求当前组合的硬币总数
            for (int count : counts) {
                total += count;
            }
            // 保留最小的
            if (total < minCount) {
                minCount = total;
            }
        }
        return minCount;
    }

    public static void main(String[] args) {
        // 硬币面值的数组
        int[] values = {5, 3};
        // 总值
        int total = 11;
        // 初始值(0,0)
        ArrayList<Integer> initialCounts = new ArrayList<>(Collections.nCopies(values.length, 0));
        // 存储所有组合
        ArrayList<ArrayList<Integer>> coinCombinations = new ArrayList<>();
        // 求解所有组合（不去重）
        getMinCountsHelper(total, values, initialCounts, coinCombinations);
        System.out.println(getMinimumHelper(coinCombinations));
    }
}
