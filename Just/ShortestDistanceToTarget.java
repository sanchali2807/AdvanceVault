class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        //brute force
       int n = words.length;
       int steps = 0;
       int i = startIndex;
       int j = startIndex;
       while(steps<n){
        if(words[i].equals(target)){
            return steps;
        }
        if(words[j].equals(target)){
            return steps;
        }
        steps++;
        i = (i - 1 + n) % n;
        j = (j + 1 ) % n;
       }
       return -1;
    }
}
