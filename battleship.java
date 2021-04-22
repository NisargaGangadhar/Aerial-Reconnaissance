import java.util.*; 
import java.util.HashMap;
import java.util.Map; 
class battleship{  
    public static<K> void increment(Map<K, Integer> map, K key)
    {
        map.putIfAbsent(key, 0);
        map.put(key, map.get(key) + 1);
    }
    static ArrayList<Integer> mostFrequent(int arr[], int n)
    {
         int count1=0,count3=0;
         ArrayList<Integer> ar = new ArrayList<>();
         for(int i=0;i<n;i++){
             if(arr[i] == 3){
                 count3++;
             }
             else if(arr[i]==1){
                count1++;
             }
             else{
                 if(count3 >= 1 && count1>0 || count3>1){
                     int fin_count = count1+count3;
                     ar.add(fin_count);
                     count1=0;
                     count3=0;
                 }
                 else{
                     count1=0;
                     count3=0;
                 }
              
             }

         }
         return ar ;
    }
    public String battle(int rows, int col, int[][] ship){
        Map<Integer,Integer> map=new HashMap<Integer,Integer>(); 
        //columns check
        for(int j=0;j<col;j++){
            int[] ar = new int[rows];
            for(int i=0;i<rows;i++){
                ar[i]=ship[i][j];
            }
            ArrayList<Integer> res_ar = new ArrayList<>();
            res_ar = mostFrequent(ar, rows);
            if(res_ar.isEmpty() == false){
            for(int k=0;k<res_ar.size();k++){
                increment(map, res_ar.get(k));
            }
        }
    }
        //rows check
        for(int j=0;j<rows;j++){
            int[] ar = new int[col];
            for(int i=0;i<col;i++){
                ar[i]=ship[j][i];
            }
            ArrayList<Integer> res_ar = new ArrayList<>();
            res_ar = mostFrequent(ar, col);
            if(res_ar.isEmpty() == false){
            for(int k=0;k<res_ar.size();k++){
                increment(map, res_ar.get(k));
            }
        }
    }
    StringBuilder s = new StringBuilder();
        for(Map.Entry m:map.entrySet()){  
            //System.out.print(m.getKey()+":"+m.getValue()+" ");  
            s.append(m.getKey()).append(":").append(m.getValue()).append(" ");}
            String r = " ";
            r = s.deleteCharAt(s.length() - 1).toString();
            return r;
            

    }
 public static void main(String args[]){  
    int[][] a = {{2,1,0,0,2},{3,2,2,2,1},{1,2,1,2,3},{3,2,3,2,2},{1,2,1,2,1},{1,2,2,2,1},{2,3,3,2,2}};
    battleship b = new battleship();
    System.out.println(b.battle(7,5,a));
 }  
}  