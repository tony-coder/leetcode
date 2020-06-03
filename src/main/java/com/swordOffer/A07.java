package com.swordOffer;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class A07 {
    private TreeNode Build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight)
            return null;
        int k;
        for (k = inLeft; k <= inRight; k++) {
            if (inorder[k] == preorder[preLeft]) {
                break;
            }
        }
        int numleft = k - inLeft;
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = Build(preorder, inorder, preLeft + 1, preLeft + numleft, inLeft, k - 1);
        root.right = Build(preorder, inorder, preLeft + numleft + 1, preRight, k + 1, inRight);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return Build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}