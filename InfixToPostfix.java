import java.util.Stack;

public class App {
    //infix bir ifadenin postfixe dönüştürülmesi ve postfix bir ifadenin sonucunun hesaplanması 
    
    public static int oncelik(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    

    public static String infix2postfix(String infixIfade){

       

       Stack <Character> y= new Stack <>();

        String postIfade  ="";
        for(int i=0; i<infixIfade.length(); i++){
            char c=infixIfade.charAt(i);
            if(oncelik(c)>0){
                  while( (!y.isEmpty())    && (oncelik(y.peek()) >= oncelik(c))){
                     postIfade=postIfade+y.pop();
                  }
                  y.push(c);
            }
            else{
                postIfade=postIfade+c;
            }
        }
        for(int i=0; i< y.size() ; i++){
            postIfade=postIfade+y.pop();
        }

        return postIfade;


    } 

    public static void main(String[] args) throws Exception {
       
        String ifade="a+b*c-d";
        System.out.println(infix2postfix(ifade));
        
    }
}