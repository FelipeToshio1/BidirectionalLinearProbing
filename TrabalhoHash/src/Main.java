package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int hashmapSize;
        int mod;
        int increment;
        int key;
        int cont = 1;
        int menu = 0;

        Scanner read = new Scanner(System.in);
        System.out.printf("Write the map size:");
        hashmapSize = read.nextInt();
        System.out.printf("Write the increment ");
        increment = read.nextInt();
        HashFunctions hash = new HashFunctions(hashmapSize, increment);

        hash.tableAutoFill();

        System.out.printf("\n**************Menu**************");
        System.out.printf("\n2 - Insert key");
        System.out.printf("\n3 - Search key");
        System.out.printf("\n4 - Remove key");
        System.out.printf("\n5 - Print map");
        System.out.printf("\n********************************");
        while (menu != 1) {
            System.out.printf("\n Choose the operation: ");
            menu = read.nextInt();
            if (menu == 2) {
                System.out.printf("\n Which key should be inserted? ");
                key = read.nextInt();
                if (hashmapSize >= cont) {
                    hash.insert(key);
                    cont++;
                } else {
                    System.out.println("\n Table is full");
                }
            }
            if (menu == 3) {
                System.out.printf("\n Which key should be searched? ");
                key = read.nextInt();                
                Integer index = hash.search(key);
                if(index == null){
                    System.out.println("Dont Exist");
                } else{
                    System.out.println("\n"+index);
                }
            }
            if (menu == 4) {
                System.out.printf("\n Choose a key to be removed: ");
                key = read.nextInt();
                hash.remove(key);
                
        }
        if (menu == 5) {
            ArrayList<Integer> map = hash.getHashmap();
            for (int i = 0; i < map.size(); i++) {
                System.out.println(i + "-->" + map.get(i));
            }

        }

    }

}
}
