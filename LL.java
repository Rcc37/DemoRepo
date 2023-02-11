public class LL {
    Node head;
    private int size;
    
    LL(){
        size =0;
    }

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    //add an element ,1st,last
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }
    //add last
    public void addlast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        
        Node currNode=head;
        while(currNode.next != null){
            currNode = currNode.next;
        }

        currNode.next=newNode;

    }

    //Print data 
    public void printList(){
        Node currNode = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }

    //delete first 
    public void delFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }



    //delete Last
    public void delLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node secondlast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondlast = secondlast.next;
        }
        secondlast.next = null;
        

    }

    public int getsize(){
        return size;
    }
    //reverse a linked list using iterate 
    public void reverseIterate(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head ;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode; 
        }
        head.next = null;
        head = prevNode;

    }
    //recursive approach for reversing a link list
    public Node reverseRecursive(Node head){
        if(head ==null||head.next == null){
            return head;
        }
        Node newhead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
        
    }
    //del middle
    public void delmiddle(int index){
        if(index > size||index<0){
            System.out.println("Invalid index");
        }
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        
        if(index == 0){
            head = head.next;
            return;
        }
        Node currNode= head;
        for(int i =1;i<index;i++){
            currNode=currNode.next;
        }
        currNode.next= currNode.next.next;
        size--;
    }
     //add middle
     public void addMiddle(String data,int index){
        if(index < 0||index > size){
            System.out.println("Invalid index");
            return;
        }
        Node newNode = new Node(data);
        if(head == null||index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currNode=head;
        for(int i = 0;i<size;i++){
            if(i==index){
                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next =nextNode;
            }
            currNode=currNode.next;
            
        }
    }
    //print an element at an index 
    public void returnindex(String value){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode=head;
        for(int i =0;i<size;i++){
            if(currNode.data==value){
                System.out.println("The value is found at index "+ i);
            }
            currNode=currNode.next;
        }
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.addlast("List");
        list.addFirst("This");
        list.printList();
        list.head =list.reverseRecursive(list.head);
        list.printList();  

    }
}
