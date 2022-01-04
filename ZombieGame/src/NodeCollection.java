//import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class NodeCollection {

    private ArrayList<Node> nodes;
/****************************************************/
/*************    SUPPORT MAP BUILDER  **************/
/****************************************************/
/****************************************************/
    public Node locateNodeBy(int nodeID) {
        for (Node n : nodes) {
            if (nodeID == n.getID()) {
                return n;
            }
        }
        return new Node();
    }
    public ArrayList<Node> arrayList(){
        return nodes;
    }
    public Node get(int index){ return nodes.get(index); }
/****************************************************/
/**************         BUILD      ******************/
/****************************************************/
/****************************************************/
    public NodeCollection()  throws FileNotFoundException {
        java.io.File prc = new java.io.File("src/data.csv");
        Scanner fileRef = new Scanner(prc);
        nodes = new ArrayList<Node>();
        Node node;
        while (fileRef.hasNext()) {
            String line = fileRef.nextLine();
            node = mapFields(line);
            nodes.add(node);
        }
        fileRef.close();
    }

    //private @NotNull
    Node mapFields(String line) {
        String[] stringArray = line.split(",");
        Node m = new Node();
        m.setID(valueOf(stringArray[0]));
        m.setFirstID(valueOf(stringArray[1]));
        m.setSecondID(valueOf(stringArray[2]));
        m.setThirdID(valueOf(stringArray[3]));
        m.setFourthID(valueOf(stringArray[4]));
        m.setDescription(stringArray[5]);
        m.setQuestion(stringArray[6]);
        m.setActionID(stringArray[7]);
        m.setZombieID(stringArray[8]);
        return m;
    }

    public String toString(){
        String str = "";
        for(Node n : nodes){
            str += n.toString() + "\n";
        }
        return str;
    }
}
