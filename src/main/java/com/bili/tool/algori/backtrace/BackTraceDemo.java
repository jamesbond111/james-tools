package com.bili.tool.algori.backtrace;

public class BackTraceDemo {
    int result = 0;

    /* 主函数 */
    int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        backtrack(nums, 0, target);
        return result;
    }

    /* 回溯算法模板 */
    void backtrack(int[] nums, int i, int rest) {
        // terminator
        if (i == nums.length) {
            if (rest == 0) {
                // 说明恰好凑出 target
                result++;
            }
            return;
        }
        // 给 nums[i] 选择 - 号
        rest -= nums[i];
        backtrack(nums, i + 1, rest);
        // 撤销选择
        rest += nums[i];

        // 给 nums[i] 选择 + 号
        rest += nums[i];
        // 穷举 nums[i + 1]
        backtrack(nums, i + 1, rest);
        // 撤销选择
        rest -= nums[i];
    }
}
