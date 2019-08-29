package algorithm;

/**
 *   查找盛最多水的容器
 *
 * @author xiangtch
 * @date 2019/8/29 14:22
 * <p> Email: xiangtiancheng@deepexi.com </p>
 */
public class MaxArea {

    /*
    *   给定 n 个非负整数 a1, a2, ... , an，每个数代表坐标中的一个点(i, ai)。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为（i, ai）
    *和 (i,0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    *
    *   说明：你不能倾斜容器，且 n 的值至少为 2
    *
    *   示例：
    *       输入：[1, 8, 6, 2, 5, 4, 8, 3, 7]
    *       输出：49
    * */

    public static void main(String[] args) {
        System.out.println(findMaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     *   查找盛最多水的容器
     *
     * @param height 容器高度数组
     * @return 容器最大容量
     */
    private static int findMaxArea(int[] height) {
        // 暴力破解
        // 定义最大面积
        int maxArea = 0;
        // 遍历数组
        for (int i = 1; i < height.length; i++){
            // 计算遍历到该位置的面积最大值
            for (int j = 0; j < i; j++){
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (i - j));
            }
        }
        return maxArea;
    }
}