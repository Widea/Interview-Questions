/*
Question:Given an arbitrary ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

Source: LeetCode
*/
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        if(ransomNote.length() > magazine.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c: magazine.toCharArray())
        {
                int count = map.containsKey(c) ? map.get(c) + 1 : 1;
                map.put(c, count);
        }
        
        for(char c: ransomNote.toCharArray())
        {
            int count = map.containsKey(c) ? map.get(c) - 1 : -1;
            if(count == -1)
                return false;
            map.put(c, count);
        }
        
        return true;
    }
}
