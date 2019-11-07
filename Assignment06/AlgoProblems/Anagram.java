package Assignment06.AlgoProblems;

public class Anagram {

//		  Example 1:
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//        
//        Example 2:
//        Input: s = "rat", t = "car"
//        Output: false
//        
//        Note:
//        You may assume the string contains only lowercase alphabets.

        public boolean isAnagram(String s, String t) {
        	if(s == null && t == null) return true;
        	if(s == null || t == null || s.length() != t.length()) return false;
        	
        	int[] count = new int[26];
        	for(char ch : s.toCharArray()) {
        		count[ch - 'a']++;
        	}
        	for(char ch : t.toCharArray()) {
        		count[ch - 'a']--;
        		if(count[ch - 'a'] < 0) return false;
        	}
        	for(int i = 0; i < 26; i++) {
        		if(count[i] != 0) return false;
        	}
        	return true;
          }
        
        // O(n)的时间是肯定要花的
}
