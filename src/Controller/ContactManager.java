package Controller;

import Model.LinkedList;
import Model.Node;
import Model.Contact;

public class ContactManager {
    private LinkedList<Contact> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contact c) {
        contacts.appendToTail(c);
    }

    public Contact findContactByName(String name) {
        Node<Contact> curr = contacts.getHead();
        while (curr != null) {
            if (curr.getValue().getName().equalsIgnoreCase(name)) {
                return curr.getValue();
            }
            curr = curr.getNext();
        }
        return null;
    }

    public boolean deleteContactByName(String name) {
        Node<Contact> curr = contacts.getHead();
        while (curr != null) {
            if (curr.getValue().getName().equalsIgnoreCase(name)) {
                contacts.deleteByValue(curr.getValue());
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public void printList() {
        contacts.print();
    }
}
