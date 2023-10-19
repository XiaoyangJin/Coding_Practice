import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookInventory {

    public static List<Integer> maxCopiesRealTime(List<Integer> portalUpdate){
        //write your code here
        //res: the return result list
        List<Integer> res = new ArrayList<>();
        //hm: the HashMap<ID, Number>() to keep trackint the inventory
        HashMap<Integer, Integer> hm = new HashMap<>();
        //currMax: the Integer to keep tracking the current max number
        int currMax = 0;

        for(int i = 0; i < portalUpdate.size(); i++){
            int currId = portalUpdate.get(i);
            if(currId > 0){
                hm.put(currId, hm.getOrDefault(currId, 0) + 1);
                currMax = Math.max(currMax, hm.get(currId));
            } else{
                hm.put(-currId, hm.get(-currId) - 1);
                currMax = 0;
                for(int count : hm.values()){
                    currMax = Math.max(currMax, count);
                }
            }
            res.add(currMax);
        }
        return res;
    }

    //this is the test part
    public static void main(String[] args){
        List<Integer> portalUpdate = new ArrayList<>();
        portalUpdate.add(6);
        portalUpdate.add(6);
        portalUpdate.add(2);
        portalUpdate.add(-6);
        portalUpdate.add(-6);
        portalUpdate.add(-6);

        System.out.println(maxCopiesRealTime(portalUpdate));
    }
}
