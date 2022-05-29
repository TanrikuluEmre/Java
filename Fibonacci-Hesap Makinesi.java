public class hesapMakinesi {

    public double topla(double a,double b){
        return (a+b);
    }
    public static double cikar(double a,double b){
        return (a-b);
    }
    public double carp(double a,double b){
        return (a*b);
    }
    public double bol(double a,double b){
        return (a/b);
    }
    
}

public class App {

    public static int sayac;

    public static long factorial(int n){
        if(n==0) {
            return 1;
        }
        else{
            return (n*factorial(n-1));
        }
        
    }

    public static double usAl(double a,int n){
        
        sayac++;
        if(n==0){
            return 1;
        }
        else if(n==1){
            return a;
        }
        else{
            return (a* usAl(a,n-1)); 
        }
    }

    public static double usAl1(double a,int n){
        sayac++;
        double y;
        if(n==0){
            return 1;
        }
        if(n % 2 == 0){  //üs çift sayı ise 
            y=usAl1(a,n/2);
            return y*y;
        }
        else{ //üs tek sayı ise
            y=usAl1(a,(n-1)/2);
            return a*y*y;
        }
    }


    public static int Ackerman(int m,int n){
        
        sayac++;
        if(m==0){
            return n+1;
        }
        if(n==0){
            return Ackerman(m-1,1);
        }
        return Ackerman(m-1, Ackerman(m,n-1));
    }


    public static int [] fibo_iter(int n){
        int [] f_dizi=new int [n];
        f_dizi[0]=1;
        f_dizi[1]=1;

        for(int i=2; i<n; i++){
            f_dizi[i]=f_dizi[i-1] + f_dizi[i-2];
        }
        return f_dizi;
    }

    public static int fibo_rec(int n){
        sayac++;
        if(n==0){
            return 1;
        }
        else if(n==1){
            return 1;
        }
        return (fibo_rec(n-1) + fibo_rec(n-2));
    }


    public static void main(String[] args) throws Exception {
        

        long sonuc=factorial(10);
        System.out.println("10!="+sonuc);

        sayac=0;
        System.out.println("2 üzeri 21=" + usAl(2,21));
        System.out.println("Fonksiyonun özyineleme sayısı:" + sayac);

        sayac=0;
        System.out.println("2 üzeri 21=" + usAl1(2,21));
        System.out.println("Fonksiyonun özyineleme sayısı:" + sayac);

        sayac=0;
        System.out.println("Ackerman(2,3)=" + Ackerman(2,3));
        System.out.println("Fonksiyonun özyineleme sayısı:" + sayac);

        sayac=0;
        System.out.println("10. Fibonacci sayısı=" + fibo_rec(10));
        System.out.println("Fonksiyonun özyineleme sayısı:" + sayac);
        
        System.out.println("------------------static ifadesi--------------");

        
        hesapMakinesi hm=new hesapMakinesi();
        System.out.println(hm.carp(2,3));

        //cikar fonksiyonu statik olarak tanımlandığında, sınıfa ait bir fonksiyon haline gelir ve sınıf adı referans gösterilerek
        //çağırılıp çalıştırılabilir.

        hesapMakinesi.cikar(5, 3);
        hm.topla(5, 8);


    }
}