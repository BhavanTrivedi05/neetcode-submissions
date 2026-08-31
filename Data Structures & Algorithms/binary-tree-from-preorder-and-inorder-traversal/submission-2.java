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
    private int preIdx = 0;
    private Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i =0; i<inorder.length;i++) {
            idxMap.put(inorder[i],i);
        }    
        return build(preorder, 0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int left, int right){
        if(left > right) return null;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int mid = idxMap.get(rootVal);
        root.left = build(preorder, left, mid-1);
        root.right = build(preorder,mid+1,right);
        return root;
    }
}
