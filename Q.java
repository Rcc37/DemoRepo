/** implementation using array
public class Q{
    static class  Queue{
        static int arr[];
        static int size;
        static int rear=-1;

        Queue(int n){
            arr=new int[n];
            this.size=n;
        }
        //if queue is empty
        public  Boolean isempty(){
            return rear==-1;
        }
        //if queue is full 
        public  Boolean isFull(){
            return rear==size-1;
        }
        //to add an element (enqueue) O(1)
        public void add(int data){
            if(isFull()){
                System.out.println("the queue is full");
                return;
            }
            rear++;
            arr[rear]=data;
        }
        //dequeue to remove an element O(n)
        public int  remove(){
            if(isempty()){
                System.out.println("queue is empty");
                return -1;
            }
            int front =arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front ;
        }
        //peek(or to look at the first element )
        public  int peek(){
            if(isempty()){
               System.out.println("Queue is empty");
               return -1;
            }
            return arr[0];
        }

    }
    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.add(10);
        q.add(20);
        q.add(30);
        
        while(!q.isempty()){
            System.out.println(q.peek());
            q.remove();
        } 
    }
}
*/
/** 
//circular queue
public class Q{
    static class CircularQ{
        static int arr[];
        static int size;
        static int rear=-1;
        static int front=-1;

        CircularQ(int n){
           arr=new int[n];
           this.size=n;
        }
        //queue is empty
        public Boolean isEmpty(){
           return rear==-1 && front == -1;
        }
        //queue is full
        public Boolean isFull(){
            return (rear+1)%size ==front;
        }
        //enqueue 
        public void add(int data){
            if(isFull()){
               System.out.println("Overflow");
               return;
            }
            //if it is the 1st element 
            if(front ==-1){
                front =0;
            }
            rear =(rear+1)%size;
            arr[rear]=data;
        }
        //dequeue
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int result=arr[front];
            //if 1 element is present
            if(front ==rear){
                front=rear=-1;
            }else{
                front=(front+1)%size;
            }
            return result;
        }
        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
       CircularQ q = new CircularQ(5);
       q.add(1);
       q.add(2);
       q.add(3);
       System.out.println("the 1st delete " + q.remove());
       System.out.println("the 2nd delete "+ q.remove());
       q.add(4);
       q.add(5);
       q.add(6);
       q.add(7);
       
        while(!q.isEmpty()) {
           System.out.println(q.peek());
           q.remove();

        }
    }


}
*/
/** //queue using linked list
public class Q{
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Queue{
        static Node head=null;
        static Node tail=null;
        //is empty
        public Boolean isEmpty(){
            return head==null && tail==null;
        }
        //enqueue
        public void add(int data){
            Node newNode=new Node(data);
            if(tail==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        //dequeue
        public int remove(){
            if(isEmpty()){
                return -1;
            }
            int front =head.data;
            if(head==tail){
               tail=null;
            }
            head=head.next;
            return front;
        }
        //peek
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }

}
*/
/** 
//implementaion using collection framework queue is a interface
import java.util.*;
public class Q{
    public static void main(String[] args) {
       // Queue<Integer> q=new LinkedList<>();
        Queue<Integer> q=new  ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
*/

/** 
//impelementation of queue using 2 stacks 
import java.util.Stack;
public class Q{
    static class Queue{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        //is empty
        public Boolean is_empty(){
            return s1.isEmpty();
        }
        //add or push
        public void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        //remove an element
        public int remove(){
            if(is_empty()){
                System.out.println("The queue is empty");
                return -1;
            }
            int front=s1.pop();
            return front ;
        }
        //peek()
        public int peek(){
            if(is_empty()){
                System.out.println("the queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q =new Queue();
        q.add(10);
        q.add(20);
        q.add(30);

        while(!q.is_empty()){
            System.out.println(q.peek());
            q.remove();
        }
        
    }
}
*/