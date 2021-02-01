public class Main {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        TreeNode pre = null;
        public TreeNode insertIntoBST(TreeNode root, int val) {//只插入跟节点即可
            //计算左右节点的值
            if(root == null){
                return  new TreeNode(val,null,null);
            }
            int v = root.val;
            if(val<v){
               root.left = insertIntoBST(root.left,val);
            }else {
                root.right =  insertIntoBST(root.right,val);
            }
            //比左大，比右小  下一节点为null 停止递归，
            return root;
        }
    }
}
