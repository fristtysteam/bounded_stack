/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package j.bounded_stack;

import java.util.NoSuchElementException;

import java.util.NoSuchElementException;

/**
 *
 * @author D00250937
 */
public class Bounded_stack {

 


/**
 *
 * @author michelle
 */
public class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     *
     * Returns the number of Songs currently stored in the list.
     *
     * @return the number of Songs currently stored in the list
     */
    public int size() {
        return size;
    }

    /**
     *
     * Returns the Song at the specified position in the list.
     *
     * @param index the position from which data should be retrieved
     * @return the Song at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * >= size)
     */
    public Song get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid position provided");
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     *
     * Returns the position of the given Song in the linked list.
     *
     * @param value the Song to be found in the list
     *
     * @return the position of the Song in the list, or -1 if it could not be
     * found
     */
    public int indexOf(Song value) {
        if (first == null) {
            return -1;
        }

        Node current = first;
        for (int i = 0; i < size; i++) {
            if (value == current.data) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     *
     * Adds a new node with the given Song value to the end of the linked list.
     *
     * @param value the Song to be added to the end of the list
     * @return true if the Song was successfully added, false otherwise
     */
    public boolean add(Song value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    /**
     *
     * Adds a new node with the given value to the linked list at the specified
     * position.
     *
     * @param value the value of the node to be added
     *
     * @param pos the position at which to add the new node, where 0 <= pos <=
     * size
     *
     * @return true if the node was successfully added, false otherwise
     *
     * @throws IndexOutOfBoundsException if pos is less than 0 or greater than
     * the size of the list
     */
    public boolean add2(Song value, int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Invalid position provided");
        }

        Node newNode = new Node(value);

        if (pos == 0) {
            newNode.next = first;
            first = newNode;
            if (last == null) {
                last = newNode;
            }
        } else if (pos == size) {
            if (last == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        } else {
            Node current = first;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     *
     * Returns an array containing all Songs in the linked list.
     *
     * @return an array containing all Songs in the list
     */
    public Song[] toArray() {
        Song[] songArray = new Song[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            songArray[index] = current.data;
            current = current.next;
            index++;
        }
        return songArray;
    }

    /**
     *
     * Removes the first instance of the given Song from the linked list.
     *
     * @param value the Song to be removed from the list
     *
     * @return true if the Song was successfully removed, false otherwise
     */
    public boolean remove(Song value) {
        if (first == null) {
            return false;
        }

        if (first.data.equals(value)) {
            first = first.next;
            size--;
            return true;
        }

        Node current = first;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    /**
     *
     * Returns true if the linked list is empty, false otherwise.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }
/**

Returns the last element in the linked list.
@return the last element in the linked list
@throws NoSuchElementException if the linked list is empty
*/
public Song tail() throws NoSuchElementException {
if (isEmpty()) {
throw new NoSuchElementException("List is empty");
}
return last.data;
}

    private static class Node {

        private Song data;
        public Node next;

        public Node(Song value) {
            this.data = value;
            this.next = null;
        }
    }
}

}
