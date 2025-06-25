// Time Complexity : O(nklogk) k is size of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
Convert each string to a character array, sort it, and use the sorted string as a key.
Group all original strings with the same sorted key in a HashMap.
Return all grouped anagram lists from the HashMap’s values.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if (!hm.containsKey(sorted))
                hm.put(sorted, new ArrayList<String>());
            hm.get(sorted).add(strs[i]);
        }
        return new ArrayList<List<String>>(hm.values());

    }
}

// Time Complexity : O(nk) k is size of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
Each string is hashed by multiplying unique prime numbers representing its characters
A HashMap maps each unique hash to a list index, grouping anagrams
The final grouped anagram lists are returned
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, Integer> hm = new HashMap<>();
        List<List<String>> arr = new ArrayList<List<String>>();
        int k = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            double hashValue = hashProduct(str);
            if (hm.containsKey(hashValue)) {
                arr.get(hm.get(hashValue)).add(strs[i]);
            } else {
                hm.put(hashValue, k);
                arr.add(new ArrayList<String>());
                arr.get(k).add(strs[i]);
                k++;
            }
        }
        return arr;
    }

    public double hashProduct(String str) {
        int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                83, 89, 97, 101 };
        double product = 1;
        for (int i = 0; i < str.length(); i++) {
            product *= primes[str.charAt(i) - 'a'];
        }
        return product;
    }
}

// Time Complexity : O(nk) k is size of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
For each string, build a 26-length frequency array representing character counts and convert it into a unique string key.
Use this key in a HashMap to group anagrams, since anagrams have identical frequency arrays.
Store and return grouped strings in a list of lists 
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();
        int k = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] al = new int[26];
            for (int j = 0; j < str.length(); j++) {
                al[str.charAt(j) - 'a'] = al[str.charAt(j) - 'a'] + 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(String.valueOf(al[j]));
                sb.append("#");
            }
            if (hm.containsKey(sb.toString())) {
                res.get(hm.get(sb.toString())).add(str);
            } else {
                res.add(new ArrayList<String>());
                hm.put(sb.toString(), k);
                res.get(k).add(str);
                k++;
            }

        }
        return res;
    }
}