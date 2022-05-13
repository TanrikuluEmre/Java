public class Dugum {
    public int veri;
    public Dugum sonraki;

    public Dugum(){
        this.veri=0;
        this.sonraki=null;
    }

    public Dugum(int deger){
        this.veri=deger;
        this.sonraki=null;
    }
    //dugumun veri bileşenini ekrana basmak
    public void yazdir(){
        System.out.println(this.veri);
    }
}
public class tekBagliListe {
    public Dugum ilk;  //head : listenin başlangıcını tutan değişken

    public tekBagliListe(){
        this.ilk=null;    //liste boş olarak yaratılır
    }

    /*
    public void basaEkle(Dugum yeni){
       
        yeni.sonraki=ilk;
        this.ilk=yeni;

    }
    */
    public void basaEkle(int deger){
        Dugum yeni=new Dugum(deger);
        
        yeni.sonraki=ilk;
        this.ilk=yeni;

    }

   public void sonaEkle(int deger){
        
        Dugum yeni=new Dugum(deger);

        if(this.ilk==null){   //liste boş ise
            this.ilk=yeni;
            return;
        }

        //baştan sona ilerle son düğümü bul onun sonraki bileşeni yeni düğüm olacak şeklide kodla

        Dugum temp=this.ilk;
        while (temp.sonraki!=null){
            temp=temp.sonraki;
        }
        temp.sonraki=yeni;
    
   }

   public void arayaEkle(int deger, int indis){
       if ( (this.ilk==null) || (indis == 1) ){
           this.basaEkle(deger);
           return;
       }

       Dugum yeni=new Dugum (deger);
       Dugum temp=this.ilk;
       int sayac=1;
       while(temp.sonraki!=null){
           if(sayac+1==indis){
               break;
           }
           sayac++;
           temp=temp.sonraki;
       }
       yeni.sonraki=temp.sonraki; //yeşil bağlantı
       temp.sonraki=yeni;         //mavi bağlantı

   }

//listedeki eleman sayısını hesaplayıp geri döndüren
   public int listeElemanSayisi(){
       int sayac=0;
       Dugum temp=this.ilk;
       while (temp!=null){
           sayac++;
           temp=temp.sonraki;
       }
       return sayac;
   }

   //listede değeri arar bulursa o düğümü geri döndürür
   public Dugum  elemanBul(int deger){
       Dugum temp=this.ilk;
       Dugum bulunan=null;
       while (temp!=null){
            if(temp.veri != deger){
                temp=temp.sonraki;
            }
            else{
                bulunan=temp;
                break;
            }
       }
       return bulunan;
   }


//istenen değeri listeden siler
//boş listeden eleman silinmeye çalışılırsa fonk -1 değerini döndürür
//eleman başarılı bir şekilde silinirse 0 değerini döndürür
//silmeye çalışılan eleman listede  yoksa -2 döndürür

public int elemanSil(int deger){
    if(this.ilk == null){  //liste boş ise fonksiyon geriye -1 döndürür
        return -1;
    }

    if(this.ilk.veri == deger){ //ilk eleman silinecekse, liste başlangıcı değiştirilmeli 
                                   //(sonraki düğüm liste başı olarak ayarlanmalı)
        this.ilk=this.ilk.sonraki;
        return 0;
    }

    Dugum temp=this.ilk;
    
    while(temp.sonraki.veri != deger){
        if(temp.sonraki.sonraki==null){ //liste sonunun agelinmişse eleman yoktur -2 döndürür
            return -2;
        }
        temp=temp.sonraki;
    }

    temp.sonraki=temp.sonraki.sonraki;
    return 0;

}

    //listedeki tüm elemanları baştan sona doğru sırasıyla ekrana yazar
    public void listele(){
         
        Dugum temp=this.ilk; //temp değişkeni liste başına konumlandırılır
        
        if(temp==null){
            System.out.println("Liste boş");
            return;
        }

        while(temp!=null){
            temp.yazdir();
            temp=temp.sonraki;
        }

    }


}
