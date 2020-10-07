package com.geekerstar.dp.greedy;

/**
 * @author geekerstar
 * @date 2020/10/7 15:09
 * @description 使用递归求解
 */
public class Practice5 {

    private static int getMinCountsHelper(int total, int[] values) {
        // 如果余额为0，说明当前组合成立，将组合加入到待选数组中
        if (0 == total) {
            return 0;
        }

        int minCount = Integer.MAX_VALUE;
        for (int currentValue : values) {
            // 遍历所有面值
            // 如果当前面值大于硬币总额，那么跳过
            if (currentValue > total) {
                continue;
            }
            // 使用当前面值，得到剩余银币总额
            int rest = total - currentValue;
            int restCount = getMinCountsHelper(rest, values);
            // 如果返回-1，说明组合不可信，跳过
            if (restCount == -1) {
                continue;
            }
            // 保留最小总额
            int totalCount = 1 + restCount;
            if (totalCount < minCount) {
                minCount = totalCount;
            }
        }
        // 如果没有可用组合，返回-1
        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }
        return minCount;
    }

    public static void main(String[] args) {
        int[] values = {3, 5};
        int total = 11;
        System.out.println(getMinCountsHelper(total, values));
    }
}
