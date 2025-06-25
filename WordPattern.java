// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
Split the input string into words and check if the number of words matches the pattern length.
Use a HashMap to map each character in the pattern to a word, and a HashSet to ensure no two characters map to the same word.
Return false on any mismatch or duplicate mapping; otherwise, return true if the pattern holds.
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (hm.containsKey(ch)) {
                if(!hm.get(ch).equals(words[i]))
                return false;
            } else {
                if (hs.contains(words[i]))
                    return false;
                hm.put(ch, words[i]);
                hs.add(words[i]);
            }

        }
        return true;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
Use a fixed-size array alp to map pattern characters ('a' to 'z') to words, and a HashSet to track already mapped words.
For each character-word pair, check for consistency with existing mappings and ensure one-to-one correspondence.
If any mismatch or duplicate mapping is found, return false; otherwise, return true.
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] alp = new String[26];
        HashSet<String> hs = new HashSet<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (alp[ch-'a']!=null) {
                if(!alp[ch-'a'].equals(words[i]))
                return false;
            } else {
                if (hs.contains(words[i]))
                    return false;
                alp[ch-'a']= words[i];
                hs.add(words[i]);
            }

        }
        return true;
    }
}