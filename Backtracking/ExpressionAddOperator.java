class Solution {
    void fun(int idx,long prevNum,long eval,String num,int target,List<String>res,StringBuilder str){
        if(idx == num.length()){
            if(eval == target){
                res.add(str.toString());
            }
                return;
        }
        String currStr = "";
        long currNum = 0;
        for(int i = idx;i<num.length();i++){
            // handle 0
            // and why idx > i it means i am moving further in my subproblem the String is not alone 0 but 0 is th estarting for another string
            if(i > idx && num.charAt(idx) == '0')return;
            currStr = num.substring(idx,i+1);
            currNum = currNum * 10 + num.charAt(i) - '0';
                int len = str.length();
            if(idx == 0){
                // because for the first level all numbers will have operator after them so we do not add any operator to the str
                str.append(currStr);
                fun(i+1,currNum,currNum,num,target,res,str);
                str.setLength(len);
            }
            else{
                str.append("+").append(currStr);
                fun(i+1,currNum,eval + currNum , num,target,res,str);
                str.setLength(len);
                // this removes the char that were appended
                str.append("-").append(currStr);
                fun(i+1,-currNum,eval - currNum , num,target,res,str);
                str.setLength(len);
                str.append("*").append(currStr);
                fun(i+1,currNum * prevNum,(eval - prevNum) + currNum * prevNum, num,target,res,str);
                str.setLength(len);
            }
        }
        
    }
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        fun(0,0,0,num,target,res,new StringBuilder());
        return res;
    }
}
