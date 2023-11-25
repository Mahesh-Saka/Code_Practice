import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size(), maxSum = 0, size = 0, index = 0;
        List<Integer>[] map = new ArrayList[100001];
        for (int i = 0; i < m; i++) {
            size += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                if (map[sum] == null) map[sum] = new ArrayList<>();
                map[sum].add(nums.get(i).get(j));
                maxSum = Math.max(maxSum, sum);

            }
        }
        int[] res = new int[size];
        for (int i = 0; i <= maxSum; i++) {
            System.out.println("test" + map[i]);
            List<Integer> cur = map[i];
            for (int j = cur.size() - 1; j >= 0; j--) {
                res[index++] = cur.get(j);
            }
        }
        return res;
    }

    public static List<Integer> convertToList(int[] ok) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : ok) {
            list.add(j);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> listNums = new ArrayList<>();
        listNums.add(convertToList(new int[]{1, 2, 3}));
        listNums.add(convertToList(new int[]{4, 5, 6}));
        listNums.add(convertToList(new int[]{7, 8, 9}));
        findDiagonalOrder(listNums);
    }
}

