https://leetcode.com/problems/binary-tree-inorder-traversal/description/

#code

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
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res;
        
    }


    private void inOrder(TreeNode node , List<Integer> res){
        if(node == null){
            return;
        }

        inOrder(node.left,res);
        res.add(node.val);
        inOrder(node.right,res);
    }
}
