import java.util.Scanner;

@SuppressWarnings("ALL")
public class Console {

    Scanner io;

    public Console(NodeMap map){

        io = new Scanner(System.in);

        while (map.currentNode() != null) {

            print(map.currentNode().getDescription());
            print(map.currentNode().getQuestion());

            if (map.currentNode().getQuestion().equals("-")) {
                pressEnterToContinue();
                map.noDecision();
            } else {
                map.decision(
                        fromConsoleGetInt("Yes or No? (press 1 for Yes or 2 No, 3 for maybe)")
                ) ;
            }
        }

    }

    public  void print(String  info){System.out.println(info);}
    public  void lineBreak(){
        System.out.println("\n---------------");
    }
    public  void pressEnterToContinue(){
        print("Press Enter key to continue...");
        try { System.in.read();}
        catch(Exception e) {}
    }
    public  int fromConsoleGetInt(String prompt){
        print(prompt);
        int retVal = io.nextInt();
        return retVal;
    }


}
