import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    public static String teams() throws FileNotFoundException{
        String team;
        File file = new File("C:/Users/ars/IdeaProjects/TelegaBot/src/teams.txt");
        Scanner sc = new Scanner(file);

        // we just need to use \\Z as delimiter
        sc.useDelimiter("\\Z");

        team = sc.next();
        return team;
    }

}
