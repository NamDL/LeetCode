//
///*Given a non-negative number represented as a singly linked list of digits, plus one to the number.
//	The digits are stored such that the most significant digit is at the head of the list.
//	Example:
//	Input:
//	1->2->3
//
//	Output:
//	1->2->4*/
//
//
//public class Plus_One_LinkedList_369 {
//
//	public static void main(String[] args) {
//		Node root=Node.insert(null, 9);
//		Node.insert(root, 9);
//		Node.insert(root, 9);
//		System.out.println("Before Adding one");
//		Node.printList(root);
//		System.out.println("\nAfter adding one");
//		Node.printList(addOne(root));
//	}
//
//	public static Node addOne(Node root){
//		int val=add1(root);
//		if(val==1){
//			Node node=new Node(1);
//			node.next=root;
//			return node;
//		}
//		return root;
//	}
//
//	public static int add1(Node root){
//		if(root==null){
//			return 1;
//		}
//		if(add1(root.next)==1){
//			int val=root.data+1;
//			root.data=val%10;
//			return(val/10);
//		}
//		return 0;
//	}
//
//}
