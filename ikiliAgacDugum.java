public class ikiliAgacDugum {
    public int veri;
    public ikiliAgacDugum sol;
    public ikiliAgacDugum sag;

    public ikiliAgacDugum(int deger){
        this.veri=deger;
        this.sol=null;
        this.sag=null;
    }

    public void yazdir(){
        System.out.println(this.veri);
    }
    
}
public class ikiliAramaAgac {

    public ikiliAgacDugum kok;

    public ikiliAramaAgac(){
        this.kok=null;
    }


    public void ekle(int deger){
        ikiliAgacDugum yeni= new ikiliAgacDugum(deger);

        if(this.kok==null){
            this.kok=yeni;
            System.out.println("kok:" + deger);
            return;
        }

        ikiliAgacDugum parent=null;
        ikiliAgacDugum aktif=this.kok;

        while(true){
            parent=aktif;
            if(deger<aktif.veri){
                aktif=aktif.sol;
                if(aktif==null){
                    parent.sol=yeni;
                    System.out.println("Parent:" + parent.veri + "  soluna eklenen:" + yeni.veri);
                    return;
                }
            }
            else if(deger>aktif.veri){
                aktif=aktif.sag;
                if(aktif==null){
                    parent.sag=yeni;
                    System.out.println("Parent:" + parent.veri + "  sagina eklenen:" + yeni.veri);
                    return;
                }
            }
            else{
                System.out.println("Bu degerden var");
                return;
            }

        }

    }


    public ikiliAgacDugum minDugum(){
        if(this.kok==null){
            return null;
        }
        ikiliAgacDugum aktif=this.kok;
        while(aktif.sol!=null){
            aktif=aktif.sol;
        }
        return aktif;
    }

    public ikiliAgacDugum maxDugum(){
        if(this.kok==null){
            return null;
        }
        ikiliAgacDugum aktif=this.kok;
        while(aktif.sag!=null){
            aktif=aktif.sag;
        }
        return aktif;
    }

    public ikiliAgacDugum dugumBul(int deger){
        if(this.kok==null){
            return null;
        }
        ikiliAgacDugum aktif=this.kok;
        while(aktif !=null){
            if(aktif.veri == deger){
                return aktif;
            }
            else if(deger < aktif.veri){
                aktif=aktif.sol;
            }
            else{
                aktif=aktif.sag;
            }
        }
        return null;
    }

    
    public ikiliAgacDugum minDugum(ikiliAgacDugum kokDugum){
        if(kokDugum==null){
            return null;
        }
        ikiliAgacDugum aktif=kokDugum;
        while(aktif.sol!=null){
            aktif=aktif.sol;
        }
        return aktif;
    }

    public ikiliAgacDugum dugumSil(ikiliAgacDugum kokDugum, int deger){
        if(kokDugum==null){
            System.out.println("Silme başarısız");
            return null;
        }
        if(deger<kokDugum.veri){
            kokDugum.sol=dugumSil(kokDugum.sol,deger);
            return kokDugum;
        }
        else if(deger>kokDugum.veri){
            kokDugum.sag=dugumSil(kokDugum.sag,deger);
            return kokDugum;
        }else{
            if(kokDugum.sol!=null && kokDugum.sag!=null){
                ikiliAgacDugum temp=this.minDugum(kokDugum.sag);
                kokDugum.veri=temp.veri;
                kokDugum.sag=dugumSil(kokDugum.sag,temp.veri);
                System.out.println("kontrol_sol_sag_cocuk");
                return kokDugum;
            }
            else if(kokDugum.sol!=null){
                kokDugum=kokDugum.sol;
                kokDugum.sol=null;
                System.out.println("kontrol_tek_sol_cocuk");
                return null;
            }
            else if(kokDugum.sag!=null){
                kokDugum=kokDugum.sag;
                kokDugum.sag=null;
                System.out.println("kontrol_tek_sag_cocuk");
                return null;
            }
            else{
                System.out.println("kontrol_yaprak");
                kokDugum=null;
                return null;
                
            }
        }
    }
//------------------------------------------------------------------------------------------------------
    public void kokOrtadaDolas(ikiliAgacDugum localRoot){
        if(localRoot !=null){
            kokOrtadaDolas(localRoot.sol);
            localRoot.yazdir();
            kokOrtadaDolas(localRoot.sag);
        }
    }


}