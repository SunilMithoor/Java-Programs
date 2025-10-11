package dsa;

public class CustomLinkedListMain {


    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);      // 5 -> 10 -> 20 -> 30
        list.addAt(2, 15);     // 5 -> 10 -> 15 -> 20 -> 30

        list.printList();
        System.out.println("Contains 20? " + list.contains(20));
        System.out.println("Element at index 3: " + list.get(3));

        list.remove(15);
        list.printList();

        list.reverse();
        list.printList();
    }

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class CustomLinkedList<T> {
        private Node<T> head;
        private int size;

        public CustomLinkedList() {
            this.head = null;
            this.size = 0;
        }

        // Add at the end
        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        // Add at the beginning (O(1))
        public void addFirst(T data) {
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            size++;
        }

        // Add at a specific index
        public void addAt(int index, T data) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index);
            }
            if (index == 0) {
                addFirst(data);
                return;
            }
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

        // Remove first occurrence
        public void remove(T data) {
            if (head == null) return;
            if (head.data.equals(data)) {
                head = head.next;
                size--;
                return;
            }
            Node<T> current = head;
            while (current.next != null && !current.next.data.equals(data)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
                size--;
            }
        }

        // Get element at index
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index);
            }
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        // Check if list contains element
        public boolean contains(T data) {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(data)) return true;
                current = current.next;
            }
            return false;
        }

        // Print list
        public void printList() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        // Get size
        public int size() {
            return size;
        }

        // Reverse the list (common interview question)
        public void reverse() {
            Node<T> prev = null;
            Node<T> current = head;
            Node<T> next;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
    }
}