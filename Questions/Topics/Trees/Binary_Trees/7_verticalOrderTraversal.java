https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/


#code

  import java.util.*;

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // List to store nodes with their horizontal distance and level
        List<NodeInfo> nodeList = new ArrayList<>();
        
        // Perform BFS traversal
        Queue<NodeInfo> q = new ArrayDeque<>();
        q.add(new NodeInfo(root, 0, 0));

        while (!q.isEmpty()) {
            NodeInfo nodeInfo = q.poll();
            TreeNode node = nodeInfo.node;
            int hd = nodeInfo.hd;
            int level = nodeInfo.level;

            nodeList.add(nodeInfo);

            if (node.left != null) {
                q.add(new NodeInfo(node.left, hd - 1, level + 1));
            }

            if (node.right != null) {
                q.add(new NodeInfo(node.right, hd + 1, level + 1));
            }
        }

        // Sort nodes based on horizontal distance, level, and value
        Collections.sort(nodeList, (a, b) -> {
            if (a.hd != b.hd) {
                return a.hd - b.hd;
            } else if (a.level != b.level) {
                return a.level - b.level;
            } else {
                return a.node.val - b.node.val;
            }
        });

        // Organize nodes into the result list
        List<List<Integer>> result = new ArrayList<>();
        int currentHd = Integer.MIN_VALUE;
        List<Integer> currentList = new ArrayList<>();

        for (NodeInfo nodeInfo : nodeList) {
            if (nodeInfo.hd != currentHd) {
                if (!currentList.isEmpty()) {
                    result.add(new ArrayList<>(currentList));
                }
                currentList = new ArrayList<>();
                currentHd = nodeInfo.hd;
            }
            currentList.add(nodeInfo.node.val);
        }
        if (!currentList.isEmpty()) {
            result.add(new ArrayList<>(currentList));
        }

        return result;
    }

    static class NodeInfo {
        TreeNode node;
        int hd;
        int level;

        public NodeInfo(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }
}
