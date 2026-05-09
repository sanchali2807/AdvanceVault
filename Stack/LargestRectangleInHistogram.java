class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer>st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<n;i++){
        while(!st.isEmpty() && heights[i] < heights[st.peek()]){
            int ele = heights[st.pop()];
            int nse = i;
            // "What is the largest rectangle where 5 is the minimum height?"
            int pse = st.isEmpty() ? -1 : st.peek();
            // and why we take st.peek()and not ele because we want the range in wihch curr ele is the smallest its prev and next smallest is the curr and peek so it c an only be smallest in that range 
            // if there is a smaller one before the current element we are at take that index but if the stack is empty it means all element befpre it are greater that the current so we take -1 
            int width = nse - pse - 1;
            // why -1 because the current index we are at we are not to include that;
            int area = width * ele;
            maxArea = Math.max(area,maxArea);
        }
        st.push(i);
        }
        while(!st.isEmpty()){
            int ele = heights[st.pop()];
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea , ((nse-pse-1) * ele));
        }
        return maxArea;
    }
}
