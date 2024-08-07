https://leetcode.com/problems/binary-tree-preorder-traversal/description/


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
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        preOrder(root,res);

        return res;
        
    }


    private void preOrder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
       

       res.add(node.val);

        preOrder(node.left,res);
        
        preOrder(node.right,res);
    }
}
