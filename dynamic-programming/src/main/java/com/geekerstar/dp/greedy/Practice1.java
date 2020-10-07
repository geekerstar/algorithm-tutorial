package com.geekerstar.dp.greedy;

/**
 * @author geekerstar
 * @date 2020/10/7 13:58
 * @description
 */
public class Practice1 {

    private static int getMinCoinCountHelper(int total, int[] values, int valueCount) {
        int rest = total;
        int count = 0;

        //  从大到小遍历所有面值
        for (int i = 0; i < valueCount; ++i) {
            // 计算当前面值最多能用多少个
            int currentCount = rest / values[i];
            // 计算使用完当期啊面值后的余额
            rest -= currentCount * values[i];
            // 增加当前面额用量
            count += currentCount;

            if (rest == 0) {
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 硬币面值
        int[] values = {5, 2, 1};
        // 总价
        int total = 12;
        System.out.println(getMinCoinCountHelper(total, values, 3));
    }
}
