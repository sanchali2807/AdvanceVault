class Solution {

    void prefix(int num, List<Integer> list) {
        if (num <= 0) return;

        list.add(num);

        int val = num / 10;

        prefix(val, list);
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<Integer> st = new HashSet<>();

        // store prefixes of arr1
        for (int i = 0; i < arr1.length; i++) {

            List<Integer> list = new ArrayList<>();

            prefix(arr1[i], list);

            for (int j : list) {
                st.add(j);
            }
        }

        int max = 0;

        // check arr2 prefixes
        for (int i = 0; i < arr2.length; i++) {

            List<Integer> l = new ArrayList<>();

            prefix(arr2[i], l);

            for (int j : l) {

                if (st.contains(j)) {

                    int len = String.valueOf(j).length();

                    max = Math.max(max, len);

                    break; 
                }
            }
        }

        return max;
    }
}
