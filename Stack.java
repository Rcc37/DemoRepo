//this is using linked list
/**public class Stack {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    
    static class stck{
        static Node head ;
        //check weather the stack is empty or not 
        public  boolean is_empty(){
            return head==null;
        }
        //add an element in the stack at the top 
        public  void push(int data){
            Node newNode= new Node(data);
            if(is_empty()){
               head = newNode;
               return;
            }
            newNode.next=head;
            head=newNode;
        }
        //delete an element from the stack from the top
        public  int  pop(){
            int top =head.data;
            if(is_empty()){
                return -1;
            }
            head=head.next;
            return top;
        }
        //show the element at the top
        public  int peek(){
            int top =head.data;
            if(is_empty()){
                return -1;
            }
            return top;
        }
    }
    public static void main(String[] args) {
        stck s=new stck();
        s.push(20);
        s.push(30);
        s.push(40);
        while(!s.is_empty()){
            System.out.println(s.peek());
            s.pop();
        }

        
    }
}
*/

//now using array list 
/**import java.util.ArrayList;
public class Stack{
    static class stck{
        ArrayList<Integer> list=new ArrayList<>();
        
        public  boolean is_empty(){
            return list.size()==0;
        }
        //push an element 
        public  void push(int data){
            list.add(data);
        }
        //pop an element
        public int  pop(){
            if(is_empty()){
              return -1;
            }
            int top = list.remove(list.size()-1);
            return top;
        }
        //peek an element int the stack
        public int peek(){
            if(is_empty()){
                return -1;
            }
            int top=list.get(list.size()-1);
            return top;

        }
    }
    public static void main(String[] args) {
        stck s = new stck();
        s.push(20);
        s.push(30);
        s.push(40);
        int a = s.pop();
        

    }
}
*/
//to reverse and push at the bottom
/**import java.util.Stack;
public class Main{
    public static void addBottom(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        addBottom(data, s);
        s.push(top);
    }
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverse(s);
        addBottom(top, s);
    }
     public static void main(String args[]) {
        Stack<Integer> s =new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);
        reverse(s);
        while(!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
        
    }
}
*/

