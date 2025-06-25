// Time Complexity : O(n)
// Space Complexity : O(1)  since hashmap has 256 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
I have taken 2 hashmaps. The first one has mapping from string s to string t 
The second hashmap has mapping from string t to string s
if anywhere the mapping is different return false, return true
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
       HashMap<Character,Character> hm1 = new HashMap<>();
       HashMap<Character,Character> hm2 = new HashMap<>();
       int i=0,j=0;
       while(i<s.length()){
        if(hm1.containsKey(s.charAt(i))){
            if(hm1.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }
        }
        else{
            hm1.put(s.charAt(i),t.charAt(i));
        }
        if(hm2.containsKey(t.charAt(i))){
            if(hm2.get(t.charAt(i))!=s.charAt(i)){
                return false;
            }
        }
        else{
            hm2.put(t.charAt(i),s.charAt(i));
        }
        i++;

       }
       return true;

    }
}


// Time Complexity : O(n)
// Space Complexity : O(1) since hashmap has 256 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
I have taken a hashmap and hashset. The hashmap has mapping from string s to string t 
If present in hashmap then i check if valu equals character of t else add s character to hashmap
and add t character to hashset.
If not present in hashmap but if hashset already contains return false;
*/



class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        int i = 0, j = 0;
        while (i < s.length()) {
            if (hm.containsKey(s.charAt(i))) {
                if (hm.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                hm.put(s.charAt(i), t.charAt(i));
                if (hs.contains(t.charAt(i))) {
                    return false;
                } else {
                    hs.add(t.charAt(i));
                }
            }

            i++;

        }
        return true;

    }
}

// Time Complexity : O(n)
// Space Complexity : O(1) since array has 256 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
I have taken two arrays of size 256 , for 256 ascii characters.
mapping t string to s array and s string t array
if s array or t array has wrong mapping or no mapping(null value)
return false;
*/


class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sarr = new char[256];
        char[] tarr = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (sarr[cs - ' '] != ct && sarr[cs - ' '] != '\u0000')
                return false;
            if (tarr[ct - ' '] != cs && tarr[ct - ' '] != '\u0000')
                return false;
            sarr[cs - ' '] = ct;
            tarr[ct - ' '] = cs;
        }
        return true;
    }
}




