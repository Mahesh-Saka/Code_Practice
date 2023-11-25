public class JoinExample {
    public static void main(String[] args) {

        //  test("2-5g-3-J", 2);
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int pMerge = m + n - 1;
        System.out.println(pMerge);
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pMerge--] = nums1[p1--];
                System.out.println("num1[pMerge]" + nums1[pMerge]);
            } else {
                System.out.println(" else num1[pMerge]" + nums1[pMerge]);
                nums1[pMerge--] = nums2[p2--];
                System.out.println(" else num2[pMerge]" + nums1[pMerge]);
            }

            String result = "[";
            for (int i = 0; i < nums1.length; i++) {
                result = result + nums1[i] + ((i != nums1.length - 1) ? "," : "");
            }
            result = result + "]";
            System.out.println(result);
        }
        String result = "[";
        for (int i = 0; i < nums1.length; i++) {
            result = result + nums1[i] + ((i != nums1.length - 1) ? "," : "");
        }
        result = result + "]";
        System.out.println(result);
    }

    private static void test(String s, int k) {
        String[] splited = s.split("-");
        String test = "";
        for (String string : splited) {
            test = test + string;
        }
        System.out.println(test);
        char[] listChars = test.toCharArray();
        String finalStr = "";
        String temp = "";
        int index = 1;
        for (int i = listChars.length - 1; i >= 0; i--) {
            temp = temp + listChars[i];
            if (index > 0 && index % k == 0 && index != listChars.length) {
                finalStr = finalStr + (temp + "-");
                temp = "";
            }
            index++;
        }
        finalStr = finalStr + temp;
        finalStr = finalStr.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder(finalStr);
        stringBuilder.reverse().toString();
        System.out.println(stringBuilder);
    }
}