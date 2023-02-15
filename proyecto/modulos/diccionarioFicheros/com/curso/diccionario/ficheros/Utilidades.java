
import java.util.Optional;

import java.net.URL;
import java.nio.file.Path;

public interface Utilidades {

    public static final int DISTANCIA_MAXIMA_PERMITIDA = 2;
    public static final int MAXIMOS_A_DEVOLVER = 10;
    
    public static Optional<Map<String,List<String>>> cargarDiccionario(String idioma){
        Optional<Path> pathDelFichero = getRutaDiccionario(idioma);
        if(!path.isEmpty())
            try{
                String contenido = Files.readString(path.get());
                return contenido.lines() // JAVA 11
                
                
                // Y devulevo
            }catch(IOException){
            }
        return Optional.empty();
    }
    
    private static Optional<Path> getRutaDiccionario(String idioma){
        URL urlDelFichero = Utilidades.class.getClassLoader().getResource("diccionario."+idioma+".txt");
        if (urlDelFichero == null )
            return Optional.empty();
        return Optional.of(Path.of(urlDelFichero.toUri())));
    }
    
    public static int distancia(String str1, String str2) {
        if ( Math.abs(str1.length() - str1.length()) > DISTANCIA_MAXIMA_PERMITIDA ) return DISTANCIA_MAXIMA_PERMITIDA+1;
        return computeLevenshteinDistance(str1.toCharArray(),
                                          str2.toCharArray());
    }
    
    private static int minimum(int a, int b, int c) {
         return Math.min(a, Math.min(b, c));
    }

    private static int computeLevenshteinDistance(char [] str1, char [] str2) {
        int [][]distance = new int[str1.length+1][str2.length+1];

        for(int i=0;i<=str1.length;i++){
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++){
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){ 
                  distance[i][j]= minimum(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];
    }
    
    public static String normalizarPalabra(String palabra){
        return Objects.requireNonNull(palabra).toLowerCase();
    }
}
