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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // agar dono me null hai to true return kara diya
        if (p == null && q == null) return true;

        // agar ek me null aur dusre me koi element hai to false return kara diya
        if (p == null || q == null) return false;

        // agar dono ke values bhi same nahi hai to bhi flase return kara diya 
        if (p.val != q.val) return false;

        // Recursively left aur right dono check kar liya
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}