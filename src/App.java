import Model.Contact;

public class App {
    public static void main(String[] args) throws Exception {

        Contact c1 = new Contact("Alice", "123456789");
        Contact c2 = new Contact("Bob", "987654321"); 
        Contact c3 = new Contact("Charlie", "555555555");
        Contact c4 = new Contact("Alice", "123456789");
        Contact c5 = new Contact("David", "111222333");

        System.out.println(c1.equals(c4)); // true, mismo nombre y teléfono
        System.out.println(c1.equals(c2)); // false, diferentes contactos
        System.out.println(c1.equals(c3)); // false, diferentes contactos
        System.out.println(c1.equals(c5)); // false, diferentes contactos

    }
}
