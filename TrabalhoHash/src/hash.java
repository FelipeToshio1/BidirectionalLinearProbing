
public class hash {
    
    private int hashmapSize;
    private int hashmap[];
    private int increment;
    private int cont;
    private int key;
    
    public void insert(){
        
        int position = key % hashmapSize;
        int nextPosition = position;
        
        if(hashmap[position] == key){
            
        }
        else{
            hashmap[nextPosition] = position;
        }
    }
    
    public void searchPosition(int increment, int position, int hashmapSize){
       int i;
       newPosition = position + increment * i * Math.pow(-1, c);
       i++;
       if(newPosition == null){
           hashmap[position] = newPosition;
       }
       else{
           searchPosition(increment, position, hashmapSize);
       }
    }
}
