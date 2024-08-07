https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

#code 

  //User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ll = new ArrayList<>();
      
      int level =0;
      
      leftView(root,ll,level);
      
      return ll;
    }
    
    private void leftView(Node node,List<Integer> res,int level){
        if(node==null){
            return;
        }
        if(res.size()==level){
            res.add(node.data);
        }
        
       
        leftView(node.left,res,level+1);
        leftView(node.right,res,level+1);
    }
}
