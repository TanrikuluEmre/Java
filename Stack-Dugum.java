public class yiginDugum {
    public int veri;
    public yiginDugum sonraki;

    public yiginDugum(){
        this.veri=0;
        this.sonraki=null;
    }
    public yiginDugum(int deger){
        this.veri=deger;
        this.sonraki=null;
    }
}

public class yigin {
    private yiginDugum yiginUst; //liste başını tutan değişken (head)

    public yigin(){
        this.yiginUst=null;
    }

    public boolean isEmpty(){
        if(this.yiginUst == null){
            return true;
        }
        else{
            return false;
        }
    }



    public void push(int deger){
        yiginDugum yeni=new yiginDugum(deger);  // başa ekleme işlemi
        yeni.sonraki=this.yiginUst;
        this.yiginUst=yeni;
    }


    public int pop(){
        if(this.isEmpty() ){
            return -1;  //yığın boş
        }
        int deger=this.yiginUst.veri;
        this.yiginUst=this.yiginUst.sonraki;
        return deger;
    }


    
    public int peek(){
        if(this.isEmpty() ){
            return -1;  //yığın boş
        }
        return (this.yiginUst.veri);
        
    }
}