import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<int[]> min = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[1]-b[1];
            }
        });
        PriorityQueue<int[]> max = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return b[1] - a[1];
            }
        });
        boolean visited[] = new boolean[1000000];
        int index = 0;
        for(String operation: operations){
            String s[] = operation.split(" ");
            int n = Integer.valueOf(s[1]);
            if(s[0].equals("I")){
                max.add(new int[]{index, n});
                min.add(new int[]{index, n});
            }else if(s[0].equals("D") && n<0){
                isValid(min, visited);
            }else if(s[0].equals("D") && n>0){
                isValid(max, visited);
            }
            index++;
        }
        answer[0] = getItem(max, visited);
        answer[1] = getItem(min, visited);
        return answer;
    }
    static void isValid(PriorityQueue<int[]> pq, boolean visited[]){
        int pair[];
        while(!pq.isEmpty()){
            pair = pq.poll();
            if(!visited[pair[0]]){
                visited[pair[0]] = true;
                break;      
            }
        }
    }
    static int getItem(PriorityQueue<int[]> pq, boolean visited[]){
        int ret = 0;
        int pair[];
        while(!pq.isEmpty()){
            pair = pq.poll();
            if(!visited[pair[0]]){
                ret = pair[1];  
                break;
            }
        }
        return ret;
    }
}