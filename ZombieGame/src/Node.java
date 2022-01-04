public class Node {

    private int ID;
    private int FirstID;
    private int SecondID;
    private int ThirdID;
    private int FourthID;
    private String ActionID;
    private String description;
    private String question;
    private String ZombieID;
    private Node FirstNode;
    private Node SecondNode;
    private Node ThirdNode;
    private Node FourthNode;
    private Node ActionNode;


    public Node(int ID, int firstID, int secondID,int thirdID, int fourthID, String description,String zombieID, String question, String actionID, Node firstNode,
                Node secondNode,Node thirdNode, Node fourthNode, Node actionNode) {
        this.ID = ID;
        FirstID = firstID;
        SecondID = secondID;
        ThirdID = thirdID;
        FourthID = fourthID;
        ActionID = actionID;
        ZombieID = zombieID;
        this.description = description;
        this.question = question;
        FirstNode = firstNode;
        SecondNode = secondNode;
        ThirdNode = thirdNode;
        FourthNode = fourthNode;
        ActionNode = actionNode;
    }



    public Node() {}

    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}


    public int getFirstID() {return FirstID;}
    public void setFirstID(int firstID) {FirstID = firstID;}
    public int getSecondID() {return SecondID;}
    public void setSecondID(int secondID) {SecondID = secondID;}
    public int getThirdID() {return ThirdID;}
    public void setThirdID(int thirdID) {ThirdID = thirdID;}
    public int getFourthID() {return FourthID;}
    public void setFourthID(int fourthID) {FourthID = fourthID;}



    public String getActionID() {return ActionID;}
    public void setActionID(String actionID) {ActionID = actionID;}

    public String getZombieID() {return ZombieID;}
    public void setZombieID(String zombieID) {ZombieID = zombieID;}


    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getQuestion() {return question;}
    public void setQuestion(String question) {this.question = question;}

    public Node getFirstNode() {return FirstNode;}
    public void setFirstNode(Node firstNode) {FirstNode = firstNode;}
    public Node getSecondNode() {return SecondNode;}
    public void setSecondNode(Node secondNode) {SecondNode = secondNode;}
    public Node getThirdNode() {return ThirdNode;}
    public void setThirdNode(Node thirdNode) {ThirdNode = thirdNode;}
    public Node getFourthNode() {return FourthNode;}
    public void setFourthNode(Node fourthNode) {FourthNode = fourthNode;}

    public Node getActionNode() {return ActionNode;}
    public void setActionNode(Node actionNode) {ActionNode = actionNode;}


    @Override
    public String toString() {
        return "Node{" +
                "ID=" + ID +
                ", FirstID=" + FirstID +
                ", SecondID=" + SecondID +
                ", ThirdID=" + ThirdID +
                ", FourthID=" + FourthID +
                ", ActionID='" + ActionID + '\'' +
                ", description='" + description + '\'' +
                ", question='" + question + '\'' +
                ", ZombieID='" + ZombieID + '\'' +
                ", FirstNode=" + FirstNode +
                ", SecondNode=" + SecondNode +
                ", ThirdNode=" + ThirdNode +
                ", FourthNode=" + FourthNode +
                ", ActionNode=" + ActionNode +
                '}';
    }
}
