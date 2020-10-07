package com.geekerstar.dp.greedy;

/**
 * @author geekerstar
 * @date 2020/10/7 14:19
 * @description
 */
public class Practice2 {

    private static int getMinCoinCountOfValue(int total, int[] values, int valueIndex) {
        int valueCount = values.length;
        if (valueIndex == valueCount) {
            return Integer.MAX_VALUE;
        }

        int minResult = Integer.MAX_VALUE;
        int currentValue = values[valueIndex];
        int maxCount = total / currentValue;

        for (int count = maxCount; count >= 0; count--) {
            int rest = total - count * currentValue;
            // 如果rest为0，表示余额已除尽，组合完成
            if (rest == 0) {
                minResult = Math.min(minResult, count);
                break;
            }
            // 否则尝试使用剩余面值求当前余额的银币总数
            int restCount = getMinCoinCountOfValue(rest, values, valueIndex + 1);

            // 如果后续没有可用组合
            if (restCount == Integer.MAX_VALUE) {
                // 如果当前面值已为0，返回-1表示尝试失败
                if (count == 0) {
                    break;
                }
                // 否则尝试把当前面值-1
                continue;
            }
            minResult = Math.min(minResult, count + restCount);
        }
        return minResult;
    }

    private static int getMinCoinCountLoop(int total, int[] values, int k) {
        int minCount = Integer.MAX_VALUE;
        int valueCount = values.length;

        if (k == valueCount) {
            return Math.min(minCount, getMinCoinCountOfValue(total, values, 0));
        }

        for (int i = k; i <= valueCount - 1; i++) {
            // k位置已排列好
            int t = values[k];
            values[k] = values[i];
            values[i] = t;
            // 考虑后一位
            minCount = Math.min(minCount, getMinCoinCountLoop(total, values, k + 1));
            // 回溯
            t = values[k];
            values[k] = values[i];
            values[i] = t;
        }
        return minCount;
    }

    public static void main(String[] args) {
        // 硬币面值
        int[] values = {1, 7, 10};
        // 总价
        int total = 14;
        int minCoin = getMinCoinCountLoop(total, values, 0);
        System.out.println((minCoin == Integer.MAX_VALUE) ? -1 : minCoin);
    }
}
