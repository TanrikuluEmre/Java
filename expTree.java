import java.util.Stack;

public class Node {
    public char data;
    public Node leftChild;
    public Node rightChild;

    public Node(char c){
        this.data=c;
        this.leftChild=null;
        this.rightChild=null;
    }

    public void displayNode(){
        System.out.print(this.data);
    }
    
}

public class expTree {
    public Node root;

    public expTree(){
        this.root=null;
    }

    /*
    postfix bir ifadeyi alıp (yığın yapısı kullanarak) ikili ağaca (expression Tree ye) dönüştüren fonksiyon
    23*84/+
    */

    public void createExpTree(String s){
        Stack <Node> stk=new Stack <>();

        s=s+"#";
        int i=0;
        char symbol=s.charAt(i);
        Node newNode;

        while(symbol != '#'){
           if ( (symbol >= '0'  && symbol <='9')  || (symbol >= 'a'  && symbol <='z')){
               newNode=new Node(symbol);
               stk.push(newNode);
           }
           else if (symbol=='+' || symbol=='-' || symbol=='*' || symbol=='/'){
                newNode=new Node(symbol);
                Node right=stk.pop();
                Node left=stk.pop();
                newNode.leftChild=left;
                newNode.rightChild=right;
                stk.push(newNode);
           } 
           symbol=s.charAt(++i);
        }
        this.root=stk.pop();
    }

    public void postOrderTraverse(Node localRoot){
        if(localRoot != null){
            postOrderTraverse(localRoot.leftChild);
            postOrderTraverse(localRoot.rightChild);
            localRoot.displayNode();
        }
    }
    
    public void preOrderTraverse(Node localRoot){
        if(localRoot != null){
            localRoot.displayNode();
            preOrderTraverse(localRoot.leftChild);
            preOrderTraverse(localRoot.rightChild);
            
        }
    }
    public void inOrderTraverse(Node localRoot){
        if(localRoot != null){
            inOrderTraverse(localRoot.leftChild);
            localRoot.displayNode();
            inOrderTraverse(localRoot.rightChild);
            
        }
    }

     
    
}