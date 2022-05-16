public class stack {
    //dizi ile yığın uygulaması //bu yığında pozitif tamsayılar tutlacaktır
    public int kapasite;
    public int yigin [];
    public int yiginUst;  //yığının en üsttteki elemanının pozisyon bilgisini tutar

    public stack(int boyut){
        this.kapasite= boyut;
        this.yigin=new int [boyut]; //javada dizi oluşturma
        this.yiginUst=-1;  //dizide -1. poziyon olmadığı için başlangıç değeri -1 olarak atandı
    }

    public boolean isEmpty(){   //yığın boş ise true aksi halde false döndürür
        if(this.yiginUst < 0) {
            return true;
        }
        return false;
    }

    public boolean isFull(){  //yığın tamamen dolu ise true döndürür
        if(this.yiginUst == this.kapasite -1){
            return true;
        }
        else{
            return false;
        }
    }

    public int push(int deger){  //değeri yığına atmaya çalışır, atabilirse 0 atamazsa -1 döndürür
         if(this.isFull()){
             return -1;
         }
         else{
            this.yiginUst++;
            this.yigin[this.yiginUst]=deger;
            return 0;
         }

    }

    public int pop(){ //yığının en üstündeki elemanı yığından alır ve döndürür
        if(this.isEmpty()){
            return -1;
        }
        int deger=this.yigin[this.yiginUst];
        this.yiginUst--;
        return deger;
    }

    public int peek(){ //yığının en üstündeki elemanın döndürür
        if(this.isEmpty()){
            return -1;
        }
        return(this.yigin[this.yiginUst]);
               
    }
}