import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sayi = new Scanner(System.in);
        System.out.println("Sayi Miktarını Giriniz : ");
        int n = sayi.nextInt();

        int sayac=0;

        int []dizi=new int [n];

        for (int i = 0; i < dizi.length; i++) {
            Scanner sayi2 = new Scanner(System.in);
            System.out.println(i+".Sayi : ");
            int sonuc2 = sayi2.nextInt();
            dizi[i]=sonuc2;

        }
        int deger;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(dizi[i]<dizi[j]){
                    deger=dizi[i];
                    dizi[i]=dizi[j];
                    dizi[j]=deger;
                }
                else
                    deger=dizi[i];
            }
        }
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i]+" ");
        }
        System.out.println();

        double k=Math.ceil(Math.sqrt(n));

        int R=dizi[n-1]-dizi[0];


        double h=Math.ceil(R/k);
        System.out.println("R Değeri : "+R);
        System.out.println("k Değeri : "+k);
        System.out.println("h Değeri : "+h);

        System.out.println("*******************************");

        double []dizialt=new double[n];

        dizialt[0]=dizi[0];


        System.out.println("SINIF LİMİTLERİ");
        System.out.println("Alt Limit");
        for (int i = 1; i <= k; i++) {
            dizialt[i]=dizialt[0]+i*h;

        }
        for (int i = 0; i < k; i++) {
            System.out.print(dizialt[i]+" ");
        }
        System.out.println();
        System.out.print("Üst Limit");
        double []diziüst=new double[n];
        for (int i =0; i < k; i++) {
            diziüst[i]=dizialt[i+1]-1;
            if (diziüst[i]==k-1) {
                diziüst[i]+=h;
            }
        }
        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.print(diziüst[i]+" ");
        }
        System.out.println();
        System.out.println("*******************************");
        System.out.println("SINIF SINIRLARI");

        double []diziUstSinir=new double[n];

        for (int i = 0; i < k; i++) {
            diziUstSinir[i]=(dizialt[i+1]+diziüst[i])/2;
            if (diziUstSinir[i]==k-1) {
                diziUstSinir[i]+=h;
            }
        }
        System.out.println("Üst Sınır");
        for (int i = 0; i < k; i++) {
            System.out.print(diziUstSinir[i]+" ");
        }
        System.out.println();

        double []diziAltSinir=new double[n];
        System.out.println("Alt Sınır");
        for (int i = 0; i < k; i++) {
            diziAltSinir[i]=diziUstSinir[i]-h;
            if (diziAltSinir[i]==k-1) {
                diziAltSinir[i]+=h;
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(diziAltSinir[i]+" ");
        }
        System.out.println("");
        System.out.println("*******************************");

        System.out.println("SINIF ORTA NOKTASI");
        double []ortaNokta=new double[n];

        for (int i = 0; i < k; i++) {
            ortaNokta[i]=(diziAltSinir[i]+diziUstSinir[i])/2;

        }
        for (int i = 0; i < k; i++) {
            System.out.println(ortaNokta[i]);
        }



        System.out.println("");
        System.out.println("*******************************");
        int say=0;
        System.out.println("SINIF FREKANSI");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (dizi[j]<diziUstSinir[i]&&diziAltSinir[i]<dizi[j])
                {
                    say++;
                }


            }
            System.out.println(say);
            say=0;
        }


        System.out.println("");
        System.out.println("*******************************");
        System.out.println("TOPLAM SINIF FREKANSI");
        int []sayDizi=new int [n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (dizi[j]<diziUstSinir[i]&&diziAltSinir[i]<dizi[j])
                {
                    say++;
                }
            }
            if (i==0) {
                sayDizi[i]=say;
                System.out.println(sayDizi[i]);
                say=0;
            }
            else
            {
                sayDizi[i]=sayDizi[i-1]+say;
                System.out.println(sayDizi[i]);
                say=0;
            }
        }

        System.out.println("");
        System.out.println("*******************************");
        System.out.println("ORANSAL FREKANS");

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (dizi[j]<diziUstSinir[i]&&diziAltSinir[i]<dizi[j])
                {
                    say++;
                }
            }
            System.out.println(say+"/"+n);
            say=0;
        }

        System.out.println("");
        System.out.println("*******************************");
        System.out.println("TOPLAM SINIF FREKANSI");
        int []sayDiziCopy=new int [n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (dizi[j]<diziUstSinir[i]&&diziAltSinir[i]<dizi[j])
                {
                    say++;
                }
            }
            if (i==0) {
                sayDiziCopy[i]=say;
                System.out.println(sayDiziCopy[i]+"/"+n);
                say=0;
            }
            else
            {
                sayDiziCopy[i]=sayDiziCopy[i-1]+say;
                System.out.println(sayDiziCopy[i]+"/"+n);
                say=0;
            }
        }
    }
}

