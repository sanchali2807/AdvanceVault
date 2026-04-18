*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
		String s = "abca";
		int k = 2;
	 KDistinct(s,k);
	}
	public static void KDistinct(String s,int k){
	    int n = s.length();
	    Set<String> st = new HashSet<>();
	    for(int r=0;r<n;r++){
	    Map<Character,Integer> mp = new HashMap<>();
	    StringBuilder str = new StringBuilder();
	        for(int l = r;l<n;l++){
	            str.append(s.charAt(l));
	            mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)+1);
	            if(mp.size()==k){
	                st.add(str.toString());
	            }
	            if(mp.size() > k){
	                break;
	            }
	        }
	        mp.put(s.charAt(r),mp.get(s.charAt(r))-1);
	        if(mp.get(s.charAt(r)) == 0){
	            mp.remove(s.charAt(r));
	        }
	        
	    }
	    System.out.println(st.size());
	}
}
