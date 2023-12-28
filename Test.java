import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        
        // Add elements to the list
        myList.add("Element 1");
        myList.add("Element 2");
        myList.add("Element 3");
        
        // Call the separate function for the loop
        printList(myList);
    }
    
    // Separate function for looping through the list
    public static void printList(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }
}
    
