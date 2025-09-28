package daytwo.arrays;

public class TrappingRainWater {
    public static int trappedRainWater(int[] height) {
        int n = height.length;
        int width = 1;

        // calculate the left max boundary
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // calculate the right max boundary
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // loop
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            // waterLevel = min (leftMax bound, rightMax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            // trappedWater = waterLevel - height[i] * width  // in our case width = 1
            trappedWater = trappedWater + waterLevel - height[i] * width;
        }
        return trappedWater;

    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 6, 3, 2, 5};

        int result  = trappedRainWater(height);
        System.out.println("The trapped rain water is : " + result);
    }
}