class pair{
    int score;
    int id;
    pair(int score,int id){
        this.score = score;
        this.id = id;
    }
}
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>();
        Set<String> negative = new HashSet<>();
        for(String word : positive_feedback){
            positive.add(word);
        }
        for(String word : negative_feedback){
            negative.add(word);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            if(a.score!=b.score){
                return b.score-a.score;
            }
            return a.id-b.id;
        });
        int idx = 0;
        for(String s : report){
            int score = 0;
            String[]words = s.split(" ");
            for(String c : words){
                if(positive.contains(c)){
                    score += 3;
                }
                else if(negative.contains(c)){
                    score -= 1;
                }
            }
            pq.add(new pair(score,student_id[idx]));
            idx++;
        }
        List<Integer> list = new ArrayList<>();
        while(k-->0){
            list.add(pq.poll().id);
        }
return list;
    }
}
