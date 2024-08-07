https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=root-to-leaf-paths

#code
/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        pathToLeaf(root,result,new ArrayList<>());
        
        return result;
    }
    
    
    private  static void pathToLeaf(Node node, List<ArrayList<Integer>> result, ArrayList<Integer> sub){
        if(node == null){
            return;
        }
        
        sub.add(node.data);
        
        if(node.left==null && node.right == null){
            result.add(new ArrayList<>(sub));
        }
        
        pathToLeaf(node.left,result,sub);
        pathToLeaf(node.right,result,sub);
        sub.remove(sub.size()-1);
    }
    
}
        
