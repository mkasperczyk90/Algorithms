package LeetCode;

public class TrappingRainWater_42 {

    public static void main(String args[]) {
        TrappingRainWater_42 program = new TrappingRainWater_42();

        // params
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        // execute
        int result = program.trap(height);

        // display
        System.out.print(result);
    }

    // time: O(N)
    // space: O(N)
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length -1;
        int leftH = 0;
        int rightH = 0;
 
        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] >= leftH) {
                    leftH = height[left]; 
                } else {
                    result += leftH -  height[left];
                }
                left++;
            } else {
                if(height[right] >= rightH) {
                    rightH = height[right]; 
                } else {
                    result += rightH -  height[right];
                }
                right--;
            }
        }

        return result;
    }
}
