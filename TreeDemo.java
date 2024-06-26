//Name: Stephen Nugent
//Date: 4/9/24
//Course: CS 380

/* Lab 2 Objective:

Become familiar with Git and GitHub by creating a new
local repository on this OS and committing changes to
this java file that was provided. After modifying six
different methods and committing accordingly upload to
a local GitHub repository and submit to canvas. */


//imports
import java.util.ArrayList;
import java.util.Stack;

class Node{
   //fields
   int value;
   Node left, right;

   //constructor
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }
}

class BinarySearchTree{

   //field
   public Node root;

   //constructor
   public BinarySearchTree(Node root) {
      this.root = root; //set node passed in as root
   }

   
   /**
      Recursive insert method that will add values to the bst.
      @param root is a node that will be used to traverse the entire tree since it is the start.
      @param value is a node value that the user is looking for.
      @return a Node that corresponds to the root of the updated bst.
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

      //return root
      return root;
   }


   /**
    A method that uses pre-order traversal which can be thought of as node, left, right. This means that the
    print statement that will occur inside the method will read a node, then go left, and once it can't go left
    anymore it will try to go right or return to the previous node.
    @param root is a node that represents the root of the bst that will be traversed pre-order.
    */
   public void preOrderTraversal(Node root){

      //check if root is initially null and if true inform user that the tree is empty
      if (root == null) {
         System.out.println("BST is empty...");
         return; //if this point is reached then leave the method early
      }

      //create stack to hold nodes
      Stack<Node> stack = new Stack<>();
      //create arraylist that will hold the node values in the correct order according to the traversal being used
      ArrayList<Integer> orderList = new ArrayList<>();

      //for loop to iterate through tree
      for (Node node = root;;) {
         //check if node is null
         if (node == null) {
            //if stack is empty then break out of the loop
            if (stack.empty()) break;

            //if this point is reached pop the stack
            node = stack.pop();
            node = node.right; //update node
         } else {
            orderList.add(node.value); //add value to arraylist
            stack.push(node); //add node to stack
            node = node.left; //update node
         }
      }

      //for loop to iterate through arraylist and print values
      for (Integer integer : orderList) {
         System.out.print(integer + " ");
      }
   }

   
   /**
      A method that uses in-order traversal which can be thought of as left, node, right. This means that the
      print statement that will occur inside the method will read the tree from smallest to largest values.
      @param root is a node that represents the root of the bst that will be traversed in-order.
   */
   public void inOrderTraversal(Node root){

      //check if root is initially null and if true inform user that the tree is empty
      if (root == null) {
         System.out.println("BST is empty...");
         return; //if this point is reached then leave the method early
      }

      //create stack to hold nodes
      Stack<Node> stack = new Stack<>();
      //create arraylist that will hold the node values in the correct order according to the traversal being used
      ArrayList<Integer> orderList = new ArrayList<>();

      //for loop to iterate through tree
      for (Node node = root;;)
      {
         //check if node is null
         if (node == null)
         {
            //if stack is empty then break out of the loop
            if (stack.empty()) break;

            //if this point is reached pop the stack
            node = stack.pop();
            orderList.add(node.value); //add value to arraylist
            node = node.right; //update node
         }
         else
         {
            stack.push(node); //add node to stack
            node = node.left; //update node
         }
      }

      //for loop to iterate through arraylist and print values
      for (Integer integer : orderList) {
         System.out.print(integer + " ");
      }
   }


   /**
    A method that uses post-order traversal which can be thought of as left, right, node. This means that the
    print statement that will occur inside the method will go left, then right, and once it can't any further
    read the node, then return to the previous node.
    @param root is a node that represents the root of the bst that will be traversed post-order.
    */
   public void postOrderTraversal(Node root){

      //check if root is initially null and if true inform user that the tree is empty
      if (root == null) {
         System.out.println("BST is empty...");
         return; //if this point is reached then leave the method early
      }

      //create stack to hold nodes
      Stack<Node> stack = new Stack<>();
      //create stack to keep track of visits
      Stack<Integer> stackVisit = new Stack<>();
      //create arraylist that will hold the node values in the correct order according to the traversal being used
      ArrayList<Integer> orderList = new ArrayList<>();

      //set up stacks initially
      stack.push(root);
      stackVisit.push(0);

      //while loop that will continue until the stack is empty
      while (!stack.empty())
      {
         //get int val representing amount of visits
         int visit = stackVisit.pop();
         Node node = stack.peek(); //peek the top node

         //check if visit is 0
         if (visit == 0)
         {
            // First visit.
            stackVisit.push(1);

            //check if node to the left is not null
            if (node.left != null)
            {
               //push left node onto stack
               stack.push(node.left);
               stackVisit.push(0); //push 0 for visit count
            }
         }
         //check if visit is 1
         else if (visit == 1)
         {
            // Second visit.
            // Left subtree done.
            stackVisit.push(2); //push 2 for visit count

            //check if node to the left is not null
            if (node.right != null)
            {
               //push right node onto stack
               stack.push(node.right);
               stackVisit.push(0); //push 0 for visit count
            }
         }
         else // visit >= 2
         {
            // Third visit.
            // Right subtree done.
            stack.pop(); //pop node from stack
            orderList.add(node.value); //add value to arraylist
         }
      }

      //for loop to iterate through arraylist and print values
      for (Integer integer : orderList) {
         System.out.print(integer + " ");
      }
   }

   
   /**
      A method to find the node in the tree with a specific value.
      @param root is a node that will be used to traverse the entire tree since it is the start.
      @param key is a node value that the user is looking for.
      @return a boolean value that dictates whether the value was in the tree or not.
    */
   public boolean find(Node root, int key){

      //check if root is equal to null
      if(root == null)
      {
         return false; //return false
      }

      //check if root value is equal to the given key
      if(root.value == key)
      {
         return true; //return true
      }

      //check if given key is less than the root value
      if(key < root.value)
      {
         return find(root.left, key); //recursive call updating the root to it's left child
      }
      else
      {
         return find(root.right, key); //recursive call updating the root to it's right child
      }
   }

   
   /**
      A method to find the node in the tree with the smallest value.
      @param root is a node that will be used to traverse the entire tree since it is the start.
      @return an int value that corresponds to the minimum value in the bst.
   */
   public int getMin(Node root){

      //check if root is null
      if (root == null) {
         System.out.println("BST is empty..."); //inform the user that the BST was empty based off of the root provided
         return Integer.MIN_VALUE; //return val that will act as a flag signifying that the bst is empty
      }

      //create temp node
      Node temp = root;

      //while loop that will continue until we've gone as far left as possible
      while (temp.left != null) {
         temp = temp.left; //update temp
      }

      //return temp value which should be the minimum value
      return temp.value;
   }
  
  
   /**
      A method to find the node in the tree with the largest value.
      @param root is a node that will be used to traverse the entire tree since it is the start.
      @return an int value that corresponds to the maximum value in the bst.
    */
   public int getMax(Node root){

      //check if root is null
      if (root == null) {
         System.out.println("BST is empty..."); //inform the user that the BST was empty based off of the root provided
         return Integer.MAX_VALUE; //return val that will act as a flag signifying that the bst is empty
      }

      //create temp node
      Node temp = root;

      //while loop that will continue until we've gone as far right as possible
      while (temp.right != null) {
         temp = temp.right; //update temp
      }

      //return temp value which should be the minimum value
      return temp.value;
   }
   

   /**
      This method will delete nodes if inside the bst.
      @param root is a node that will be used to traverse the entire tree since it is the start.
      @param key is a node value that the user is looking for.
      @return a Node that corresponds to the root of the updated bst.
   */
   public Node delete(Node root, int key){

      //check if root is null
      if(root == null){
         return root; //return root
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

      //return root
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

      //-------------- in-order --------------

      System.out.print("in-order : "); //print statement
      t1.inOrderTraversal(t1.root); //call inOrderTraversal method that prints results
      System.out.println(); //used for formatting

      //-------------- pre-order --------------

      //print pre-order results to user
      System.out.print("pre-order : ");
      t1.preOrderTraversal(t1.root); //call preOrderTraversal method that prints results
      System.out.println(); //used for formatting

      //-------------- post-order --------------

      //print post-order results to user
      System.out.print("post-order : ");
      t1.postOrderTraversal(t1.root); //call postOrderTraversal method that prints results
      System.out.println(); //used for formatting

      //-------------- getMin --------------
      System.out.println("-------------------------------"); //used for formatting
      int min = t1.getMin(root); //declare int value to hold min

      //check if min is not equal to Integer.MIN_VALUE
      if(min != Integer.MIN_VALUE)
         System.out.print("min value found in the tree : " + min); //display results

      System.out.println(); //used for formatting

      //-------------- getMax --------------
      int max = t1.getMax(root); //declare int value to hold min

      //check if min is not equal to Integer.MAX_VALUE
      if(max != Integer.MAX_VALUE)
         System.out.print("max value found in the tree : " + max); //display results

      System.out.println(); //used for formatting

      //-------------- find --------------
      System.out.println("-------------------------------"); //used for formatting
      System.out.print("is 80 apart of the bst? t/f : "); //print statement
      //call find method that returns a boolean in regard to whether the key is in the bst or not
      System.out.println(t1.find(t1.root, 80));

      System.out.print("is 4 apart of the bst? t/f : "); //print statement
      //call find method that returns a boolean in regard to whether the key is in the bst or not
      System.out.println(t1.find(t1.root, 4));

      System.out.print("is 22 apart of the bst? t/f : "); //print statement
      //call find method that returns a boolean in regard to whether the key is in the bst or not
      System.out.println(t1.find(t1.root, 22));
   }  
}