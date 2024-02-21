import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rasmus Engström
 */
public class GraphIO{

    static public void readFile(Graph g, String fileName) throws IOException {
        try {
            File filen = new File(fileName);
            Scanner scanner = new Scanner(filen);
            int node = scanner.nextInt();
            for(int i = 0; i < node; i++){
                g.addNode(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }

            // Använder detta för att inte kasta en IOException när scanner.nextline
            try{
                while(scanner.hasNextInt()){
                    g.addEdge(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
                }
            } finally {

                scanner.close();
            }

        }catch (FileNotFoundException e){
            throw new IOException();
        }
    }
}
