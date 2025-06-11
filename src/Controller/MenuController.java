
package Controller;

import Model.Contact;
import View.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView   = new ConsoleView();
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            consoleView.displayMenu();
            String option = consoleView.getInput("Seleccione una opción");

            switch (option) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    printList();
                    break;
                case "5":
                    consoleView.showMessage("Saliendo...");
                    exit = true;
                    break;
                default:
                    consoleView.showMessage("Opción no válida.");
            }
        }
    }

    private void addContact() {
        String name  = consoleView.getInput("Ingrese el nombre del contacto");
        String phone = consoleView.getInput("Ingrese el teléfono del contacto");
        contactManager.addContact(new Contact(name, phone));
        consoleView.showMessage("Contacto agregado: " + name);
    }

    private void findContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto a buscar");
        Contact c = contactManager.findContactByName(name);
        if (c != null) {
            consoleView.showMessage("Encontrado: " + c);
        } else {
            consoleView.showMessage("Contacto no encontrado.");
        }
    }

    private void deleteContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto a borrar");
        boolean deleted = contactManager.deleteContactByName(name);
        if (deleted) {
            consoleView.showMessage("Contacto borrado: " + name);
        } else {
            consoleView.showMessage("Contacto no encontrado.");
        }
    }

    private void printList() {
        consoleView.showMessage("\n-- Lista de contactos --");
        contactManager.printList();
    }
}