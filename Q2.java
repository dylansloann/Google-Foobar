import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static String sortString(String n) {
        char tmp[] = n.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
    
    public static String reverseString(String n) {
        String reversed = "";
        for(int i = n.length() - 1; i >= 0; i--) {
            reversed = reversed + n.charAt(i);
        }
        return reversed;
    }
        
    public static int solution(String n, int b) {
        int k = n.length();
        
        ArrayList<String> holder = new ArrayList<String>();
        String curr = n;
        
        boolean breakCondition = false;
        int finalIndex = 0;

        while (!breakCondition) {
            holder.add(curr);
            
            String ascend = sortString(curr);
            String descend = reverseString(ascend);

            int ascendInt = Integer.parseInt(ascend, b); 
            int descendInt = Integer.parseInt(descend, b); 

            if (b != 10) {
                int descendBase10 = Integer.parseInt(Integer.toString(descendInt, 10));
                int ascendBase10 = Integer.parseInt(Integer.toString(ascendInt, 10));
                curr = Integer.toString(descendBase10 - ascendBase10, b);
            } else {
                curr = Integer.toString(descendInt - ascendInt);
            }

            while (curr.length() != k) {
                curr = '0' + curr;
            }

            for (int i = 0; i < holder.size(); i++) {
                if (curr.equals(holder.get(i))) {
                    breakCondition = true;
                    finalIndex = i;
                    break;
                }
            }
        }

        return holder.size() - finalIndex;
    }
}