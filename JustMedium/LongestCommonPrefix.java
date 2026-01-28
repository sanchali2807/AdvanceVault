class Solution {
    public String longestCommonPrefix(String[] arr) {

        if (arr == null || arr.length == 0)
            return "";

        String first = arr[0];
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {

            char ch = first.charAt(i);

            // check same index in all strings
            for (int j = 1; j < arr.length; j++) {

                // if index exceeds OR mismatch
                if (i >= arr[j].length() || arr[j].charAt(i) != ch) {
                    return prefix.toString();
                }
            }

            prefix.append(ch);
        }

        return prefix.toString();
    }
}
