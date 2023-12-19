public class JumpIndex {
    public static int canJump(int[] nums) {
        int reachable = nums[0];
        if (reachable == nums.length - 1) return 0;
        int step = 1;
        while (reachable < nums.length) {
            if (reachable == nums.length - 1) return step;

            reachable = reachable + nums[reachable > 0 ? reachable - 1 : 0];
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 0, 1, 4};
        System.out.println(canJump(array));
    }

}
