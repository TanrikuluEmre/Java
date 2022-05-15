public class Dugum {
    public int veri;
    public Dugum onceki;
    public Dugum sonraki;

    public Dugum(){
        this.veri=0;
        this.onceki=null;
        this.sonraki=null;
    }

    public Dugum(int deger){
        this.veri=deger;
        this.onceki=null;
        this.sonraki=null;
    }

    public void yazdir(){
        System.out.println(this.veri);
    }

}

public class ciftBagliListe {
    public Dugum ilk; //listenin başını tutan değişken

    public ciftBagliListe(){
        this.ilk=null;
    }


    public void basaEkle(int deger){
        Dugum yeni=new Dugum(deger);

        if(this.ilk==null){
            this.ilk=yeni;
            return;
        }

        this.ilk.onceki=yeni;  //listenin başındakinden önceki eleman yeni değişkeni olur
        yeni.sonraki=this.ilk;
        
        this.ilk=yeni;

    }
/*
    public void basaEkle(Dugum yeni){
        this.ilk.onceki=yeni;  //listenin başındakinden önceki eleman yeni değişkeni olur
        yeni.sonraki=this.ilk;
        
        this.ilk=yeni;
    }

*/

public void sonaEkle(int deger){

    Dugum yeni=new Dugum(deger);

    if(this.ilk==null){
        this.ilk=yeni;
        return;
    }

    Dugum temp=this.ilk;
    while(temp.sonraki != null){    //tempi en son düğüme konumlandırma
        temp=temp.sonraki;
    }

    temp.sonraki=yeni;
    yeni.onceki=temp;

}



public void arayaEkle(int deger, int indis){
    if((this.ilk==null) || (indis==1)){
        this.basaEkle(deger);
        return;
    }

    Dugum yeni=new Dugum(deger);
    Dugum temp=this.ilk;

    int sayac=1;
    while(temp.sonraki != null){
        if(sayac + 1 == indis){   //temp istenen yere konumlandırıldı
            break;
        }
        sayac++;
        temp=temp.sonraki;
    }

    temp.sonraki.onceki=yeni;
    yeni.sonraki=temp.sonraki;
    temp.sonraki=yeni;
    yeni.onceki=temp;

}

public void listele(){
    Dugum temp=this.ilk;
    if(temp!=null){
        System.out.println("Liste elemanları");
        while(temp!=null){
            temp.yazdir();
            temp=temp.sonraki;
        }
    }
    else{
        System.out.println("Liste boş");
    }
}