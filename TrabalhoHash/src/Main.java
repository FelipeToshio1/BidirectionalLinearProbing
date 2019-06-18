
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
        int hashmapSize;
        int mod;
        int increment;
        int key;
        int menu = 0;

        Scanner ler = new Scanner(System.in);
        System.out.printf("Informe o tamanho do mapa: ");
        hashmapSize = ler.nextInt();
        System.out.printf("Informe o imcremento: ");
        increment = ler.nextInt();
        Hash hash = new Hash();
        System.out.printf("\n**************Menu**************");
        System.out.printf("\n2 - Inserir key");
        System.out.printf("\n3 - Buscar key");
        System.out.printf("\n4 - Remover key");
        System.out.printf("\n5 - Imprimir mapa");
        System.out.printf("\n********************************");
        while (menu != 1) {
            System.out.printf("\nInforme a operação: ");
            menu = ler.nextInt();
            if (menu == 2) {
                System.out.printf("\nInforme uma key para ser inserida: ");
                key = ler.nextInt();
                hash.insert(key);
            }
            if (menu == 3) {
                System.out.printf("\nInforme uma key para ser buscada: ");
                key = ler.nextInt();
                if(hash.buscaChave(key) == null){
                    System.out.println("\nChave nao encontrada!");
                }else{
                    System.out.println("\nChave na posição "+ hash.buscaChave(key) +".");
                }
            }
            if (menu == 4) {
                System.out.printf("\nInforme uma key para removida: ");
                key = ler.nextInt();
                /*if(hash.buscaChave(key) == null){
                    System.out.println("\nChave nao encontrada!");
                }else{
                    hash.removeChaveReinsercao(key);
                    System.out.println("\nChave removida ");
                }*/
            }
            if (menu == 5) {
                Object mapa[] = hash.getMapa();
                for (int i = 0; i < mapa.length; i++) {
                    //System.out.println("");
                    System.out.println(i + "-->" + mapa[i]);
                }
                
            }

        }

    }
 }
    
