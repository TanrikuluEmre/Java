public class oncelikKuyrukDugum {

    public int veri;
    public int oncelik;
    public oncelikKuyrukDugum sonraki;

    public oncelikKuyrukDugum(int v, int o){
        this.veri=v;
        this.oncelik=o;
        this.sonraki=null;
    }

    public void yazdır(){
        System.out.println("Oncelik:" + this.oncelik +"    Veri: " + this.veri);
    }

    
}
public class oncelikKuyrugu {
    public oncelikKuyrukDugum on;
    public oncelikKuyrukDugum arka;

    public oncelikKuyrugu(){
        this.on=null;
        this.arka=null;
    }

    public boolean bosmu(){
        if(this.on==null)
            return true;
        else
            return false;
    }


    public void ekle(int v, int o){
        oncelikKuyrukDugum yeni=new oncelikKuyrukDugum(v, o);

        if(this.bosmu()){   //kuyruk boş ise 
            this.on= this.arka =yeni;
            return;
        }

        //basa ekle: yeni gelenin önceliği kuyruk önündekinden küçük ise (1 2 den öncelikli olacak şekilde kodluyoruz)
        if(yeni.oncelik < this.on.oncelik){
            yeni.sonraki=this.on;
            this.on=yeni;
            return;
        }

        //sona ekle: yeni gelenin önceliği kuyruk arkasındakinden büyük yada eşit ise
        if(yeni.oncelik >= this.arka.oncelik){
            this.arka.sonraki=yeni;
            this.arka=yeni;
            return;
        }

        //araya ekle: aynı önceliğe sahip düğümlerin en sonuna ekleme
        oncelikKuyrukDugum temp=this.on;

        while(yeni.oncelik >= temp.sonraki.oncelik){
            temp=temp.sonraki;
        }

        yeni.sonraki= temp.sonraki;
        temp.sonraki=yeni;

    }


    public int cikart(){
        if(this.bosmu()){
            return -1;
        }
        int veri=this.on.veri;
        if(this.on.sonraki==null){ //kuyrukta tek değer varsa arka null yapılır
            this.arka=null;
        }
        this.on=this.on.sonraki;//listedeki ilk düğüm silinir, tek düğüm varsa o da null olacaktır.
        return veri;
    }


    public void listele(){

        oncelikKuyrukDugum temp=this.on;
        while(temp!=null){
            temp.yazdır();
            temp=temp.sonraki;
        }

    }

    
}