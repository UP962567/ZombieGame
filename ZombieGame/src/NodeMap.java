import java.io.FileNotFoundException;


public class NodeMap {

    private Node head;
    private Node currentNode;

/****************************************************/
/**************      NAVIGATE       *****************/
/****************************************************/
/****************************************************/
    public Node currentNode() { return currentNode;}

    public void noDecision(){
        currentNode = currentNode.getFirstNode();
    }

    public void decision(int decision) {
        switch (decision) {
            case 1:
                currentNode = currentNode.getFirstNode();
                break;
            case 2:
                currentNode = currentNode.getSecondNode();
                break;
            case 3:
                currentNode = currentNode.getThirdNode();
                break;
            case 4:
                currentNode = currentNode.getFourthNode();
                break;

        }
    }
/****************************************************/
/**************         BUILD      ******************/
/****************************************************/
/****************************************************/

    public NodeMap()  {
        NodeCollection nodeCollection;   //scope: constructor only, part of process, no requirement to keep;
        try {
            nodeCollection = new NodeCollection();
            head = nodeCollection.get(0);
        } catch (FileNotFoundException e) {
            //message
            return;
        }
        buildMap(nodeCollection);
        currentNode = head;
    }


    private void buildMap(NodeCollection nodeCollection)   {
        if (nodeCollection == null) {return;}
        for(Node source : nodeCollection.arrayList()){
            int FirstID = source.getFirstID();
            int SecondID = source.getSecondID();
            int ThirdID = source.getThirdID();
            int FourthID = source.getFourthID();
            Node FirstNode = nodeCollection.locateNodeBy(FirstID);
            Node SecondNode = nodeCollection.locateNodeBy(SecondID);
            Node ThirdNode = nodeCollection.locateNodeBy(ThirdID);
            Node FourthNode = nodeCollection.locateNodeBy(FourthID);

            source.setFirstNode(FirstNode);
            source.setSecondNode(SecondNode);
            source.setThirdNode(ThirdNode);
            source.setFourthNode(FourthNode);

        }
    }

    public String toString(){
        String string = "";
        string += FirstPath() + "\n";
        string += SecondPath() + "\n";
        string += ThirdPath() + "\n";
        string += FourthPath() + "\n";
        string += ActionPath() + "\n";
        return string;
    }

    public String FirstPath(){
        Node node = head;
        String string = "First PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getFirstNode();
            if (node.getID() == 0) { node = null;}
        }
        return string;
    }

    public String SecondPath(){
        Node node = head;
        String string = "Second PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getSecondNode();
            if (node.getID() == 0) { node = null;}
        }
        return string;
    }

    public String ThirdPath(){
        Node node = head;
        String string = "Third PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getThirdNode();
            if (node.getID() == 0) { node = null;}
        }
        return string;
    }
    public String FourthPath(){
        Node node = head;
        String string = "Fourth PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getFourthNode();
            if (node.getID() == 0) { node = null;}
        }
        return string;
    }

    public String ActionPath(){
        Node node = head;
        String string = "Action PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getActionNode();
            if (node.getID() == 0) { node = null;}
        }
        return string;
    }


}