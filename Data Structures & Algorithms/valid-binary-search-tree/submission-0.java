/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    private boolean valid(TreeNode node, Integer min, Integer max){
        if(node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        return valid(node.left, min, node.val) && valid(node.right, node.val,max);
    }
}
