public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int rotation = Math.floorMod(k, nums.length);
        int[] rotated = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            rotated[(index + rotation) % nums.length] = nums[index];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] rotated = rotateArray(new int[] {1, 2, 3, 4, 5, 6, 7}, 3);
        for (int value : rotated) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}