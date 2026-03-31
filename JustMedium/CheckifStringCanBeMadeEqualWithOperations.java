class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[]s1even = {s1.charAt(0),s1.charAt(2)};
        char[]s1odd = {s1.charAt(1),s1.charAt(3)};
        char[]s2even = {s2.charAt(0),s2.charAt(2)};
        char[]s2odd = {s2.charAt(1),s2.charAt(3)};
        Arrays.sort(s1even);
        Arrays.sort(s1odd);
        Arrays.sort(s2even);
        Arrays.sort(s2odd);
        return Arrays.equals(s1even,s2even) && Arrays.equals(s1odd,s2odd);
    }
}
