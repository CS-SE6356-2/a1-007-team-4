package assignment;

public class Main {

    public static void main(String[] args) {
        new NamePrinter().printNames();
    }
}

class NamePrinter {
    /**
     * This method prints the concatenation of the elements with the delimiter. 
     * For this case, the elements is the names of the team members and the delimiter is a dash.
     * The output will have the names of all team members separated by a dash.
     */
    public void printNames() {
        String separator = "-";

        String[] names = {
                "Phifong Phan",
                "Stephen Mercado",
                "Hogan Steffes",
                "Andy Hudson"};

        System.out.println(String.join(separator, names));
    }
}