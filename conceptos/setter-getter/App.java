public class App{
    
    public static void main(String[] args){
        Rectangulo r1 = new Rectangulo(4,5);
        System.out.println(r1.base);
        r1.altura=8;
        System.out.println(r1.altura);

        Rectangulo2 r2 = new Rectangulo2(4,5);
        System.out.println(r2.getBase());
        r2.setAltura(8);
        System.out.println(r2.getAltura());
        
        
    }
    
}