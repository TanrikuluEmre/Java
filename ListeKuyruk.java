public class kuyrukDugum {
    
    public int eleman;
    public kuyrukDugum sonraki;
    
    public kuyrukDugum(int e){
        this.eleman=e;
        this.sonraki=null;
    }
    
    public void yazdir(){
        System.out.println("Eleman degeri:"+this.eleman);
    }
}

public class listeKuyruk {

    public kuyrukDugum on, arka;  

    public listeKuyruk(){
        this.on=this.arka=null;
    }

    public boolean bosmu(){
        if(this.on==null) return true;
        else return false;
    }
    
    
    public void ekle(int deger){
        kuyrukDugum yeni=new kuyrukDugum(deger);
        if(this.bosmu()){
            this.on=yeni;
            this.arka=yeni;
        }else{
            this.arka.sonraki=yeni;
            this.arka=yeni;
        }
    }


    public int cikart(){
        if(this.bosmu()){
            return -1;
        }
        int veri=this.on.eleman;

        if(this.on.sonraki==null){ //kuyrukta tek değer varsa arka null yapılır
            this.arka=null;
        }

        this.on=this.on.sonraki;//listedeki ilk düğüm silinir, tek düğüm varsa o null olacaktır.
        return veri;
    }