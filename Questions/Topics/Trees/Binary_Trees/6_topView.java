https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

#code

  // User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        
        Queue<Pair> q = new ArrayDeque<>();
        TreeMap<Integer,Integer> mpp = new TreeMap<>();
        q.add(new Pair(0,root));
        
        
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(!mpp.containsKey(curr.hd)){
                mpp.put(curr.hd,curr.node.data);
            }
            
            if(curr.node.left!=null){
                q.add(new Pair(curr.hd-1,curr.node.left));
            }
            
            if(curr.node.right!=null){
                q.add(new Pair(curr.hd+1,curr.node.right));
            }
            
            
        }
        
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        
        for(Map.Entry<Integer, Integer> entry: mpp.entrySet()){
            arr.add(entry.getValue());
        }
  
            return arr;
          }
    
    
    static class Pair{
        int hd;
        Node node;
        
        public Pair(int hd,Node node){
            this.hd = hd;
            this.node = node;
        }
          }
}
