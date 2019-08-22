## 题目描述

小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

输出所有和为 S 的连续正数序列。

输出描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

例如和为 100 的连续序列有：
```
[9, 10, 11, 12, 13, 14, 15, 16]
[18, 19, 20, 21, 22]。
```

题目地址：https://www.nowcoder.com/questionTerminal/c451a3fd84b64cb19485dad758a55ebe

# 题目解析

完整解析：https://www.jikewenku.com/problem/5164.html

双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。

```java
import java.util.ArrayList;

public class Solution {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
}
```

1)由于我们要找的是和为S的连续正数序列，因此这个序列是个公差为1的等差数列，而这个序列的中间值代表了平均值的大小。假设序列长度为n，那么这个序列的中间值可以通过（S / n）得到，知道序列的中间值和长度，也就不难求出这段序列了。

2）满足条件的n分两种情况：
n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n &amp; 1) == 1 &amp;&amp; sum % n == 0；
n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n.

3）由题可知n &gt;= 2，那么n的最大值是多少呢？我们完全可以将n从2到S全部遍历一次，但是大部分遍历是不必要的。为了让n尽可能大，我们让序列从1开始，
根据等差数列的求和公式：S = (1 + n) * n / 2，得到![e91f66ba85f906c9a34f3ac7ad406cbc.svg](evernotecid://113C0B43-B030-456A-9E07-400447648BD8/appyinxiangcom/19492832/ENNote/p1402?hash=e91f66ba85f906c9a34f3ac7ad406cbc)
.
最后举一个例子，假设输入sum = 100，我们只需遍历n = 13~2的情况（按题意应从大到小遍历），n = 8时，得到序列[9, 10, 11, 12, 13, 14, 15, 16]；n  = 5时，得到序列[18, 19, 20, 21, 22]。

完整代码：时间复杂度为![c32e40c9d50580ce71b8f6ba5b066322.svg](evernotecid://113C0B43-B030-456A-9E07-400447648BD8/appyinxiangcom/19492832/ENNote/p1402?hash=c32e40c9d50580ce71b8f6ba5b066322)

```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
```


