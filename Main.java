
// public class Main{
//         static class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode(int x) { 
//             val = x;
//             left=null;
//             right =null;
//         }
//     }

//         static class BT{
//         static int  index=-1;
//         public TreeNode buildTree(int nodes[]){//this will return the root Node
//             index++;
//             if(nodes[index]==-1){
//                 return null;
//             }
//             TreeNode newNode=new TreeNode(nodes[index]);
//             newNode.left=buildTree(nodes);
//             newNode.right=buildTree(nodes);

//             return newNode;
            
//         }

        
//         public  boolean hasPathSum(TreeNode root, int sum) {
//             if (root == null) {
//                 return false;
//             }
//             if (root.left == null && root.right == null && root.val == sum) {
//                 return true;
//             }
//             return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//         }
//         int minDepth(TreeNode root) {
//             if (root == null) {
//                 return 0;
//             }
//             if (root.left == null && root.right == null) {
//                 return 1;
//             }
//             int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
//             if (root.left != null) {
//                 left = minDepth(root.left);
//             }
//             if (root.right != null) {
//                 right = minDepth(root.right);
//             }
//             return Math.min(left, right) + 1;
//         }
        
//     }
//     public static void main(String args[]) {
//        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//        BT tree=new BT();
//        TreeNode root=tree.buildTree(nodes);
//        System.out.println(tree.minDepth(root)); 
//    } 
// }

public class Main {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String s = "This is a test";
        System.out.println("Reversed: " + reverseWords(s));
    }
}


