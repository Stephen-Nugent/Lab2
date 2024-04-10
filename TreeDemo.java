//Name: Stephen Nugent
//Date: 4/9/24
//Course: CS 380

/* Lab 2 Objective:

Become familiar with Git and GitHub by creating a new
local repository on this OS and committing changes to
this java file that was provided. After modifying six
different methods and committing accordingly upload to
a local GitHub repository and submit to canvas. */


class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   //required field
   public Node root;

   //constructor
   public BinarySearchTree(Node root) {
      this.root = root; //set node passed in as root
   }
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }

      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value);
      }else{
         root.right = insert(root.right, value);
      }

      return root;
   }
   
   
   
   /*
   pre-order traversal node, left, right
   */
   public void preOrderTraversal(Node root){
      //implement me

   }

   
   
   /*
   in-order traversal left, node, right
   */
   public void inOrderTraversal(Node root){
      //implement me
   }
   
   
   
   /*
   post-order traversal left, right, node,
   */
   public void postOrderTraversal(Node root){
      //implement me
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  //implement me
      return false;           
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      //implement me
      return root.value;
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
      return root.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      Node root = new Node(24);
      BinarySearchTree t1  = new BinarySearchTree(root);
      t1.insert(t1.root, 80);
      t1.insert(t1.root,18);
      t1.insert(t1.root,9);
      t1.insert(t1.root,90);
      t1.insert(t1.root,22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}