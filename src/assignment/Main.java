package assignment;

public class Main {

    public static void main(String[] args) {
        new NamePrinter().printNames();
    }
}

class NamePrinter {
    /**
<<<<<<< HEAD
     * This method prints the concatenation of the elements with the delimiter. 
     * For this case, the elements is the names of the team members and the delimiter is a dash.
     * The output will have the names of all team members separated by a dash.
=======
     * Prints the names of the group members separated by commas.
>>>>>>> 7e8103d5cf2d365a35278e49f885b7c305656252
     */
    public void printNames() {
        String separator = ",";

        String[] names = {
                "Phifong Phan",
                "Name 2",
                "Hogan Steffes",
                "Name 4",
                "Name 5"};

        System.out.println(String.join(separator, names));
    }
}