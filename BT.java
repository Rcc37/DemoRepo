import java.util.*;
public class BT{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int  index=-1;
        public Node buildTree(int nodes[]){//this will return the root Node
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node newNode=new Node(nodes[index]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
            
        }
        //preorder traversal(here the root gets printed 1st then left part and then right)
        public void preorder(Node root){
            if(root==null){
                //System.out.print(" -1 ");//if you want to print -1 instaed of null
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        //inorder (1st left part then root in middle and then right part)
        public  void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        //postorder (1st left part then 2nd right and then root at last)
        public void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        //level order traversal (level wise it will display the tree )
        public void levelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right !=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        //count the number of Nodes
        public int countNode(Node root){
            if(root==null){
                return 0;
            }
            int leftNode=countNode(root.left);
            int rightNode=countNode(root.right);
            return leftNode+rightNode+1;
        }
        //sum of the nodes
        public int  sumNodes(Node root){
            if(root==null){
                return 0;
            }

            int leftdata=sumNodes(root.left);
            int rightdata=sumNodes(root.right);
            return leftdata+rightdata+root.data;  
        }
        //hight of the tree
        public int treeHight(Node root){
            if(root==null){
                return 0;
            }
            int leftheight=treeHight(root.left);
            int rightheight=treeHight(root.right);
            
            int myheight=Math.max(leftheight,rightheight)+1;
            return myheight;
        }
        //diameter of a tree o(n^2) 
        //1st one including root & 2nd one excluding root element
        public int diameter(Node root){
            if(root==null){
                return 0;
            }
            int dia1=diameter(root.left);//left diameter(left traversal)
            int dia2=diameter(root.right);//right diameter(right travrsal)
            int dia3=treeHight(root.left)+treeHight(root.right)+1;

            return Math.max(dia3,Math.max(dia1,dia2));
        }
        //Approach 2 for diameter of a tree O(n)
        //here the height will be stored and not called
        class treeInfo{
            int ht;
            int dia;

            treeInfo(int height,int diameter){
                this.ht=height;
                this.dia=diameter;
            }

        }
        public treeInfo diameter2(Node root){
            if(root==null){
                return new treeInfo(0, 0);
            }
            //this is for height 
            treeInfo leftht=diameter2(root.left);
            treeInfo rightht=diameter2(root.right);
            int myheight=Math.max(leftht.ht,rightht.ht)+1;

            //the diameter
            int diam1=leftht.ht;
            int diam2=rightht.ht;
            int diam3=leftht.ht+rightht.ht+1;

            int mydiam=Math.max(diam3,Math.max(diam1,diam2));

            return new treeInfo(myheight,mydiam);

        }
        //sum of the root at Kth level
        public int  levelAdd(Node root,int level){
            if(root==null){
                return 0;
            }
            int sum=0;
            int val=1;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                        val++;
                    }
                }else{
                    if(val==level){
                        sum+=currNode.data;
                    }
                    if(currNode.left !=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right !=null){
                        q.add(currNode.right);
                    }
                }
                
            }
            return sum;
        }
        //root to leaf check the sum 
        public  boolean hasPathSum(Node root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && root.data == sum) {
                return true;
            }
            return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
        }
        //left side of the tree
        void leftSide(Node root, int level, int[] maxLevel) {
            if (root == null) {
                return;
            }
            if (maxLevel[0] < level) {
                System.out.print(root.data);
                maxLevel[0] = level;
            }
            leftSide(root.left,  level + 1, maxLevel);
            leftSide(root.right, level + 1, maxLevel);
        }
        //min height of the tree
        int minDepth(Node root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            if (root.left != null) {
                left = minDepth(root.left);
            }
            if (root.right != null) {
                right = minDepth(root.right);
            }
            return Math.min(left, right) + 1;
        }
        
       
    }
    
    public static void main(String[] args) {
       int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
       BinaryTree tree=new BinaryTree();
       Node root=tree.buildTree(nodes);
       //tree.levelOrder(root);
    //    System.out.println(tree.levelAdd(root, 2)); 
       System.out.println(tree.sumNodes(root));
    }
}