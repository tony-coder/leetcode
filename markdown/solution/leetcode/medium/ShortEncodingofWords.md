[820. 单词的压缩编码](https://leetcode-cn.com/problems/short-encoding-of-words/)

给定一个单词列表，我们将这个列表编码成一个索引字符 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？

**示例：**


```
输入: words = ["time", "me", "bell"]
输出: 10
说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
```

**提示：**


```
1 <= words.length <= 2000
1 <= words[i].length <= 7
每个单词都是小写字母 。
```

### 方法一 反转+排序：

简单来说就是反转字符串后按字典序排序，进行前缀匹配
![a175eba7060cddbcf43ebbedf3e838b9a3592923a4a8776ec765e66c391882c8.jpg](https://i.loli.net/2020/03/28/n6l4oNwV5EvUSr9.jpg)


```java
class Solution {
    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public int minimumLengthEncoding(String[] words) {
        int i,ans=0;
        for(i=0;i<words.length;i++){
            words[i]=reverse(words[i]);
        }
        Arrays.sort(words);
        for(i=0;i<words.length-1;i++){
            if(words[i].length()<=words[i+1].length() && words[i].equals(words[i+1].substring(0,words[i].length())))
                continue;
            else
                ans+=words[i].length()+1;
        }
        return ans+words[i].length()+1;
    }
}
```


### 方法二 字典树：

**思路**

目标就是保留所有不是其他单词后缀的单词

**算法**

去找到是否不同的单词具有相同的后缀，我们可以将其反序之后插入字典树中。例如，我们有 "time" 和 "me"，可以将 "emit" 和 "em" 插入字典树中。

![820_2.jpg](https://i.loli.net/2020/03/28/qVIxaZc62Cvodkl.jpg)

然后，字典树的叶子节点（没有孩子的节点）就代表没有后缀的单词，统计叶子节点代表的单词长度加一的和即为我们要的答案。


```java
/**
 * 方法二 字典树
 * 时间复杂度 O(∑wi) 其中 wi 是 words[i] 的长度。对于每个单词中的每个字母，只需要进行常数次操作。
 */
class Solution {
    int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> mp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            // 倒着插入
            for (int j = words[i].length() - 1; j >= 0; j--) {
                cur = cur.getNext(words[i].charAt(j));
            }
            mp.put(cur, i);  // 插入字符串的末尾节点与该字符串在输入字符串数组中对应的位置
        }
        int ans = 0;
        for (TrieNode t : mp.keySet()) {
            if (t.count == 0)  // 如果一个字符串是另一个字符串的前缀，则其末尾节点记录的count必定不为0，因为肯定存在子节点
                ans += words[mp.get(t)].length() + 1;
        }
        return ans;
    }

}

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    int count;  // 记录该节点的子节点数

    public TrieNode() {
        this.count = 0;
    }

    public TrieNode getNext(char ch) {
        if (child[ch - 'a'] == null) {
            TrieNode node = new TrieNode();
            child[ch - 'a'] = node;
            count++;
        }
        return child[ch - 'a'];
    }
}
```
**复杂度分析**

- 时间复杂度：`$O(\sum w_i)$`，其中 `$w_i$` 
是 words[i] 的长度。对于每个单词中的每个字母，只需要进行常数次操作。
- 空间复杂度：`$O(S*\sum w_i)$`，字典树的空间开销，其中 SS 为字符集大小。
