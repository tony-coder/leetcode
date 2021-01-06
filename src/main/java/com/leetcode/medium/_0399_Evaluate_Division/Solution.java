package com.leetcode.medium._0399_Evaluate_Division;

import java.util.*;

/**
 * 广度优先搜索
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 遍历equations，用哈希表将每个不同的字符串映射成整数
        int cnt = 0, n = equations.size();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(equations.get(i).get(0))) {
                mp.put(equations.get(i).get(0), cnt++);
            }
            if (!mp.containsKey(equations.get(i).get(1))) {
                mp.put(equations.get(i).get(1), cnt++);
            }
        }
        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Node>[] edges = new List[cnt];
        for (int i = 0; i < cnt; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int u = mp.get(equations.get(i).get(0));
            int v = mp.get(equations.get(i).get(1));
            edges[u].add(new Node(v, values[i]));
            edges[v].add(new Node(u, 1.0 / values[i]));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (mp.containsKey(query.get(0)) && mp.containsKey((query.get(1)))) {
                int ia = mp.get(query.get(0));
                int ib = mp.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> q = new LinkedList<>();
                    //Queue 中 add() 和 offer()都是用来向队列添加一个元素。
                    //在容量已满的情况下，add() 方法会抛出IllegalStateException异常，offer() 方法只会返回 false 。
                    q.offer(ia);
                    double[] ratios = new double[cnt];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!q.isEmpty() && ratios[ib] < 0) {
                        int x = q.poll();
                        for (Node node : edges[x]) {
                            int y = node.getIndex();
                            double val = node.getValue();
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                q.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            res[i] = result;
        }
        return res;
    }
}

class Node {
    private int index;
    private double value;

    public Node(int index, double value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
