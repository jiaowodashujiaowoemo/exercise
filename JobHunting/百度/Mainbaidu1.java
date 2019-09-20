import java.util.*;

/**
 * @Author ChenXiang
 * @Date 2019/9/10,21:39
 * @Description 百度笔试第三题，一棵树从下到上，只能删除叶子节点，输出每个节点是在第几次遍历中被删除的
 * 思路是对的，本来可以AC，但是自己做了一个不该做的假设，上面的节点一定比下面的小，但是其实不是的
 */
public class Mainbaidu1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, List<Integer>> arr = new LinkedHashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (arr.get(x) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                arr.put(x, list);
            } else {
                arr.get(x).add(y);
            }
        }

        for (int i = n; i > 0; i--) {
            map.put(i, 1);
        }

        List<Map.Entry<Integer, List<Integer>>> entrySet = new ArrayList<>(arr.entrySet());

        for (int j = entrySet.size() - 1; j >= 0; j--) {
            int i = entrySet.get(j).getKey();
            List child = arr.get(i);
            if (child != null) {
                int min = Integer.MAX_VALUE;
                List<Integer> list = arr.get(i);
                for (Integer key : list) {
                    System.out.println(key);
                    min = Math.min(map.get(key), min);
                }
                map.put(i, map.get(i) + min);
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println(map.get(n));
    }
    /**
     5
     1 4
     1 5
     4 2
     2 3
     */
}
