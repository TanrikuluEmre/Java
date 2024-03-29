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

            System.out.println(c);

            if(oncelik(c)>0){
                  while( (!y.isEmpty())    && (oncelik(y.peek()) >= oncelik(c))){
                     postIfade=postIfade+y.pop();
                  }
                  y.push(c);
            }
            else{
                postIfade=postIfade+c;
            }

            System.out.println(postIfade);

        }

      //  System.out.println(y.size());
        
        int yiginBoyut=y.size();

        for(int i=0; i < yiginBoyut ; i++){
            postIfade=postIfade + y.pop();
            System.out.println("---->"+postIfade);
        }
        return postIfade;

    } 


    public static int postfixHesapla(String postIfade){
         
        String [] postfixDizi=postIfade.split(" ");

        Stack <String> y= new Stack <>();

        String e;
        int s1=0,s2=0, s3=0;

        for(int i=0;i<postfixDizi.length; i++){
            //System.out.println("-->"+postfixDizi[i]);
            e=postfixDizi[i];
            e.trim(); //boşlukların temizlenmesini sağlar

            System.out.println("-->"+e+"<---");
            if(e.equals("")) //e boş ise bir sonraki dizi elemanına geç
                  continue;
            
            if(e.equals("+")){ //stringler için eşitlik kontrolü
                s2=Integer.parseInt(y.pop()); // yığından çekilen string ifade int e dönüşüştürülür
                s1=Integer.parseInt(y.pop());
                s3=s1+s2;
                y.push(String.valueOf(s3)); // String.valueOf herhangi tipteki veriyi Stringe dönüştürür
            }
            else if(e.equals("-")){ 
                s2=Integer.parseInt(y.pop()); 
                s1=Integer.parseInt(y.pop());
                s3=s1-s2;
                y.push(String.valueOf(s3)); 
            }
            else if(e.equals("*")){ 
                s2=Integer.parseInt(y.pop()); 
                s1=Integer.parseInt(y.pop());
                s3=s1*s2;
                y.push(String.valueOf(s3)); 
            }
            else if(e.equals("/")){ 
                s2=Integer.parseInt(y.pop()); 
                s1=Integer.parseInt(y.pop());
                s3=s1/s2;
                y.push(String.valueOf(s3)); 
            }
            else{
                y.push(e);
            }

        }

        int sonuc=Integer.parseInt(y.pop());

        if( !y.isEmpty()){

            System.out.println("Positfix ifade hatalı");
            return 0;
        }


        return sonuc;
    }


    public static void main(String[] args) throws Exception {
       
       /* String ifade="a + b*c-d/ e";

        String sonuc=infix2postfix(ifade);
        System.out.println(sonuc);
*/
        String postfixIfade="6  6      85  *  +     10  -";
       System.out.println( postfixHesapla(postfixIfade)) ;
        
    }
}