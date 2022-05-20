public class App {

    //aynı işi yapan fonksiyonların isimleri aynı seçilmelidir.
    //buna function overloading denir (fonksiyonların aşırı yüklenmesi)
    //aynı isim üzerinden aynı işi farklı parametrelerle gerçekleştirebiliriz
   
    public static void mesajYaz(){
        System.out.println("Merhaba");
    }
    
    public static void mesajYaz(String msj){
        System.out.println(msj);
    }

    public static int toplaInt(int x, int y) {
        return (x+y);
    }

    public static double toplaDouble (double x, double y) {
        return (x+y);
    }
    public static void main(String[] args) throws Exception {
       
       // dikdortgen d1; //d1 dikdortken sınıfın tipinde bir nesne olacak
        //d1=new dikdortgen(); //d1 dikdorthen sınıfından bir nesne olarak türetildi

        dikdortgen d1=new dikdortgen();

        d1.setGenislik(10); //değişkenlere değer aktarma
        d1.setYukseklik(20);

        System.out.println("Genişlik:"+d1.getGenislik());
        System.out.println("Yükseklik:"+d1.getYukseklik());

        int d1Alan=d1.alanHesapla();
        System.out.println("Alanı:" + d1Alan);

        int d1Cevre=d1.cevreHesapla();
        System.out.println("Çevresi:" + d1Cevre);

        System.out.println("-------------------------------");
        
        dikdortgen d2=new dikdortgen(5,15);

        System.out.println("Genişlik:"+d2.getGenislik());
        System.out.println("Yükseklik:"+d2.getYukseklik()); 
        int d2Alan=d2.alanHesapla();
        System.out.println("Alanı:" + d2Alan);
        int d2Cevre=d2.cevreHesapla();
        System.out.println("Çevresi:" + d2Cevre);
        
        System.out.println("-------------------------------");
  
        d2.setGenislik(25);
        System.out.println("Genişlik:"+d2.getGenislik());
        System.out.println("Yükseklik:"+d2.getYukseklik()); 
        d2Alan=d2.alanHesapla();
        System.out.println("Alanı:" + d2Alan);
        d2Cevre=d2.cevreHesapla();
        System.out.println("Çevresi:" + d2Cevre); 



       /* mesajYaz();
        mesajYaz();
        App.mesajYaz();
        
        mesajYaz("Veri Yapıları");
        mesajYaz("Javayı seviyoruz");

        int deger1=toplaInt(10,20);
        mesajYaz(String.valueOf(deger1));

        double deger2=toplaDouble(2.3, 5.8);
        mesajYaz(String.valueOf(deger2));

        try{
             int sonuc=10/0;
             System.out.println(sonuc);
        }
        catch(Exception e){
               System.out.println("0 a bölme hatası");
        }
        
        System.out.println("Program çalışmaya devam ediyor");
        */

        /*
        
        int x;
        x=15;

        float y;
        y=3.5f;
    
        double d;
        d=12.56;

        String ders="Veri Yapıları";
        System.out.println("x=" + x);

        if(x<10){
            System.out.println("x 10 dan küçük");
        }
        else{
            System.out.println("x 10 dan büyük");
        }
        int toplam=0;
        
        
        for(int i=0;i<x;i++){
            System.out.println("i=" + i);
            toplam=toplam+i;
        }
        System.out.println("Toplam="+ toplam);
        


        int index=0;
        int sonuc=0;

        while (index < x){
            System.out.println("index=" + index);
            sonuc += index;   //sonuc=sonuc+index;
            index++;
        }
        System.out.println("Sonuc="+ sonuc);

        */

    }
}
