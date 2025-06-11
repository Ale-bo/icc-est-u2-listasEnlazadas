package Controller;
import Model.*;
import java.util.LinkedList;

public class ContactManager {
    private LinkedList contacts = new LinkedList<>();

    public void addContact(Contact contact) {
        contacts.appendToTail(contact);
    }

    public Contact findContactByName(String name) {
        Node current = contacts.getHead();
        while (current != null) {
            Contact contact = (Contact) current.value;
            if (contact.getName().equals(name)) {
                return contact;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteContactByName(String name) {
        Node current = contacts.getHead();
        while (current != null) {
            Contact contact = (Contact) current.value;
            if (contact.getName().equals(name)) {
                contacts.deleteByValue(contact);
                return;
                }
            current = current.next;
        }
    }
    public void printList() {
        contacts.print();
    }

}



