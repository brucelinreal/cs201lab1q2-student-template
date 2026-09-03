public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){ //HHAHAHA
            return null;
        } 
        return head.getElement();
    }

    public E last(){    
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){ 
        Node<E> hello = head; 
        String res = "";
        while (hello!= null) {
            res += hello.getElement(); 
            hello = hello.getNext(); 
        }
        return res; 
    }

    public E removeLast(){
        Node<E> current = head; 
        E res; 

        if (head == null) {
            return null; 
        }

        if (head.getNext() == null) {
            return null; 
        }

        while (current.getNext().getNext() != null ){ 
            current = current.getNext(); 
        }
        res = current.getNext().getElement();
        current = null; 
        tail = current;

        return res; 
    }

    public void reverse(){       
        Node<E> current = head;
        Node<E> next = head.getNext(); 
        Node<E> prev = null; 

          if (head == null) {
            head.setNext(null);; 
        }

        if (head.getNext() == null) {
            head.getNext().setNext(null);; 
        }
        while (current != null) {
            next = current.getNext(); 
            current.getNext().setNext(prev); 
            prev = current; 
            current = next;  
        }

    }
}