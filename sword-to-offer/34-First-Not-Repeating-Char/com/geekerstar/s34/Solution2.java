package com.geekerstar.s34;

import java.util.BitSet;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 17:49
 * @Description: 考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
 */
public class Solution2 {
    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                // 0 0 -> 0 1
                bs1.set(c);
            }
            else if (bs1.get(c) && !bs2.get(c)) {
                // 0 1 -> 1 1
                bs2.set(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 0 1
            if (bs1.get(c) && !bs2.get(c)) {
                return i;
            }

        }
        return -1;
    }
}
