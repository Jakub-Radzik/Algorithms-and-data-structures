package RBTree;

public class Node {
     private int key;
     private Node left;
     private Node right;
     private boolean color;

    public Node(int key, boolean color) {
        this.key = key;
        left = null;
        right = null;
        this.color = color;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    public String toString() {
       StringBuilder txt = new StringBuilder();

       txt.append("=======================================================\n");
       txt.append("[Key: ").append(this.key).append(" Color: ");
       if(color){
           txt.append("RED");
       }else{
           txt.append("BLACK");
       }
       txt.append("]\n[");
       if(left!=null){
           txt.append("LEFT KEY: ").append(left.key).append(" ").append("LEFT COLOR: ");
           if(left.color){
               txt.append("RED | ");
           }else{
               txt.append("BLACK | ");
           }
       }else{
            txt.append("LEFT EMPTY | ");
       }

       if(right!=null){
           txt.append("RIGHT KEY: ").append(right.key).append(" ").append("RIGHT COLOR: ");
           if(right.color){
               txt.append("RED");
           }else{
               txt.append("BLACK");
           }
       }else{
           txt.append("RIGHT EMPTY");
       }
       txt.append("]\n");
       txt.append("=======================================================\n");


        return txt.toString();
    }
}
