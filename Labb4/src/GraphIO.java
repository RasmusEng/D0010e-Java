import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO{

    static public void readFile(Graph g, String fileName) throws IOException {
        try {
            File filen = new File(fileName);
            Scanner scanner = new Scanner(filen);
            int node = scanner.nextInt();
            for(int i = 0; i < node; i++){
                g.addNode(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }

            try{
                while(scanner.hasNextLine()){
                    g.addEdge(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
                }
            }catch(Exception e){
                scanner.close();
            }

        }catch (FileNotFoundException e){
            throw new IOException();
        }


    }

}
