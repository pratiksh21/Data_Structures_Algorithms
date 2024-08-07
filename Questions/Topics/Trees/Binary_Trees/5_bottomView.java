https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

#code

  

//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        
       Queue<Pair> q = new ArrayDeque<>();
       Map<Integer,Integer> mpp = new TreeMap<>();
       
       q.add(new Pair(0,root));
       
       while(!q.isEmpty()){
           Pair curr = q.poll();
           mpp.put(curr.hd,curr.node.data);
           
           if(curr.node.left!=null){
               q.add(new Pair(curr.hd-1,curr.node.left));
           }
           
           if(curr.node.right!=null){
               q.add(new Pair(curr.hd+1,curr.node.right));
           }
       }
       
       ArrayList<Integer> ll = new ArrayList<>();
       
       for(Map.Entry<Integer,Integer> entry: mpp.entrySet()){
           ll.add(entry.getValue());
       }
       
       
       
       return ll;
       
    }
    
    
    static class Pair{
        int hd;
        Node node;
        
        public Pair(int hd,Node node){
            this.hd= hd;
            this.node= node;
        }
    }
}
