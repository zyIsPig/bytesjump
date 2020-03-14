import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class LRUCache {

    private int ca;
    private HashMap<Integer,Integer> hs;
    private LinkedList<List<Integer>> lruList=new LinkedList<>();

    public LRUCache(int capacity) {
        this.ca=capacity;
        this.hs=new HashMap<>();

        for (int i=0;i<ca;i++){
            List<Integer> l=new LinkedList<>();
            lruList.add(l);
        }



    }


    public int get(int key) {
        if(hs.containsKey(key))return hs.get(key);
        return -1;

    }

    public void put(int key, int value) {


        if(hs.containsKey(key)){//包含，覆盖
                hs.replace(key,value);

        }else {
            if(hs.size()<ca){
                hs.put(key,value);
                lruList.get(0).add(0,key);
            }
            else {

            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */