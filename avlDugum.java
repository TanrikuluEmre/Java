public class avlDugum {
    public int veri;
    public int yukseklik;
    public avlDugum sol;
    public avlDugum sag;

    public avlDugum(int deger){
        this.veri=deger;
        this.yukseklik=1;
        this.sol=null;
        this.sag=null;
    }
}
public class avlAgac {
    
    public int getYukseklik(avlDugum d){
        if(d==null){
            return 0;
        }
        return d.yukseklik;
    }

    public int getBalance(avlDugum d){
        if(d==null){
            return 0;
        }
        return getYukseklik(d.sol)-getYukseklik(d.sag);
    }

    public avlDugum solaDondur(avlDugum p){
        avlDugum pr=p.sag;
        avlDugum prl=pr.sol;

        //sola döndürme
        p.sag=prl;
        pr.sol=p;

        //yükseklikleri güncelle
        p.yukseklik=Math.max(getYukseklik(p.sol),getYukseklik(p.sag))+1;
        pr.yukseklik=Math.max(getYukseklik(pr.sol),getYukseklik(pr.sag))+1;

        return pr;
    }

    public avlDugum sagaDondur(avlDugum p){
        avlDugum pl=p.sol;
        avlDugum plr=pl.sag;

        //saga döndürme
        p.sol=plr;
        pl.sag=p;

        //yükseklikleri güncelle
        p.yukseklik=Math.max(getYukseklik(p.sol),getYukseklik(p.sag))+1;
        pl.yukseklik=Math.max(getYukseklik(pl.sol),getYukseklik(pl.sag))+1;


        return pl;

    }


    public avlDugum ekle(avlDugum d, int deger){
        if(d==null){
            return (new avlDugum(deger));
        }
        if(deger<d.veri){
            d.sol=ekle(d.sol, deger);
        }
        else{
            d.sag=ekle(d.sag,deger);
        }

        //yukseklik guncelle
        d.yukseklik=Math.max(getYukseklik(d.sol),getYukseklik(d.sag))+1;

        //balance faktörü hesapla
        int bf=getBalance(d);

        //LL durumu
        if(bf>1 && deger<d.sol.veri){
            return sagaDondur(d);

        }

        //RR durumu
        if(bf<-1  && deger > d.sag.veri){
            return solaDondur(d);
        }

        //LR dengesizliği
        if(bf>1   && deger > d.sol.veri){
            d.sol=solaDondur(d.sol);
            return sagaDondur(d);
        }



        //RL dengesizliği

        if(bf < -1  && deger < d.sag.veri){
            d.sag=sagaDondur(d.sag);
            return solaDondur(d);
        }


        return d;

    }




}