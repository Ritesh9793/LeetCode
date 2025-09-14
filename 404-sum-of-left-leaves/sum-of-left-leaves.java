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
    public int sumOfLeftLeaves(TreeNode root) {
        //kya pata root hi 'null' ho isliye check kar liya :)
        if(root == null) return 0;
        //ek variable le liya summation ko store karne ke liye
        int sum = 0;

        //abhi check kar liya ki kahi left node bhi null to nahi
        //left ka left aur right node null rehna jaruri hai
        // kyoki example me aisa hi diya hai 
        if(root.left != null && root.left.left == null && root.left.right==null) {
            sum += root.left.val;
        }

        //root ke dono side pe checck karna jaruri hai
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        //last me summation return kara diya
        return sum;
    }
}