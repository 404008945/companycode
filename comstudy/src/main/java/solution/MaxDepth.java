package solution;

public class MaxDepth {
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public int dfs(TreeNode root,int level){
      if (root == null){
          return level;
      }
      return Math.max(dfs(root.left,level+1),dfs(root.right,level+1));
  }

    public int maxDepth(TreeNode root) {
       return dfs(root,0);
    }
}
