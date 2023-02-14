
public class Rectangulo2{
    
    private int base;
    private int altura;
    
    public Rectangulo (int base, int altura){
        this.setBase(base);
        this.setAltura(altura);
    }
    
    public void setBase(int base){
        if(base<0) throw new IllegalArgumentException();
        this.base=base;
    }
    public void setAltura(int altura){
        if(altura<0) throw new IllegalArgumentException();
        this.altura=altura;
    }
    
    public int getBase(){
        return this.base;
    }

    public int getAltura(){
        return this.altura;
    }

}
