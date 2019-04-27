package 春招.京东.紧急疏散;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description 体育场突然着火了，现场需要紧急疏散，但是过道真的是太窄了，同时只能容许一个人通过。现在知道了体育场的所有座位分布，
 *              座位分布图是一棵树，已知每个座位上都坐了一个人，安全出口在树的根部，也就是1号结点的位置上。
 *              其他节点上的人每秒都能向树根部前进一个结点，
 *              但是除了安全出口以外，没有任何一个结点可以同时容纳两个及以上的人，
 *              这就需要一种策略，来使得人群尽快疏散，问在采取最优策略的情况下，体育场最快可以在多长时间内疏散完成。
 *              第一行包含一个正整数n，即树的结点数量（1<=n<=100000）。
 *              接下来有n-1行，每行有两个正整数x，y，表示在x和y结点之间存在一条边。(1<=x<=y<=n)
 * @Author ChenXiang
 * @Date 2019/04/13,19:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a, b;
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i);
            nodes[i] = node;
        }
        //接下来只有n-1行
        for (int i = 1; i < n; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            nodes[a].integers.add(b);
            nodes[b].integers.add(a);
        }

        int max = 0;
        List<Integer> integers = nodes[1].integers;
        for (Integer integer : integers) {
            int count = getNodeEdge(nodes, integer, 1);
            max = Math.max(max, count);
        }
        System.out.println(max + 1);
    }


    /**
     * @param nodes
     * @param i
     * @param unBL
     * @return int
     * @methodname getNodeEdge
     * @description 求unBL边忽略后，node[i]节点连通的节点数
     * @author ChenXiang
     * @date 21:36,2019/4/14
     */
    private static int getNodeEdge(Node[] nodes, int i, int unBL) {
        int count = 0;
        List<Integer> integers = nodes[i].integers;
        count += integers.size() - 1;
        for (Integer integer : integers) {
            if (integer == unBL) {
                continue;
            }
            count += getNodeEdge(nodes, integer, nodes[i].val);
        }
        return count;
    }

    static class Node {
        int val;//本身的号码
        List<Integer> integers;//邻接的节点

        public Node(int val) {
            this.val = val;
            integers = new ArrayList<Integer>();
        }
    }
}
