class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) 
    {
        int len = s1.length();
        List<Set<Character>> set = new ArrayList<>();
        int currSet = 1;
        int[] sets = new int[26];
        for(int i=0; i<len; i++)
        {
            // System.out.println(set);
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1==c2) continue;
            if(sets[c1-'a'] == 0 && sets[c2-'a'] == 0)
            {
                Set<Character> newSet = new TreeSet<>();
                newSet.add(c1);
                newSet.add(c2);
                sets[c1-'a'] = currSet;
                sets[c2-'a'] = currSet;
                currSet++;
                set.add(newSet);
            }
            else if(sets[c1-'a'] == 0)
            {
                Set<Character> curr = set.get(sets[c2-'a']-1);
                curr.add(c1);
                sets[c1-'a'] = sets[c2-'a'];
            }
            else if(sets[c2-'a'] == 0)
            {
                Set<Character> curr = set.get(sets[c1-'a']-1);
                curr.add(c2);
                sets[c2-'a'] = sets[c1-'a'];
            }
            else if(sets[c2-'a'] != sets[c1-'a'])
            {
                // System.out.println(Arrays.toString(sets));
                // System.out.println(c2+"  "+c1);
                Set<Character> first = set.get(sets[c1-'a']-1);
                Set<Character> second = set.get(sets[c2-'a']-1);
                for(char cha : second)
                {
                    first.add(cha);
                    sets[cha-'a'] = sets[c1-'a'];
                }
                second.clear();
            }
        }
        System.out.println(set);
        
        String ans = "";
        for(int i=0; i<baseStr.length(); i++)
        {
            char ch = baseStr.charAt(i);
            int index = sets[ch-'a']-1;
            if(index<0) ans += ch;
            else ans += set.get(index).iterator().next();;
        }
        return ans;
        
    }
}

// My Tried Solution 

public String smallestEquivalentString(String s1, String s2, String baseStr) {

        // List of TreeSet to maintain unique set of characters lexicographically
        List<TreeSet<Character>> setList = new ArrayList<>();
        String finalString = "";

        for (int i = 0; i < s1.length(); i++) {
            char charS1 = s1.charAt(i);
            char charS2 = s2.charAt(i);
            boolean found = false;

            for (TreeSet<Character> set : setList) {

                // If any of the characters is there in the set, add in the set, they belong to the same set
                if (set.contains(charS1) || set.contains(charS2)) {
                    set.add(charS1);
                    set.add(charS2);
                    found = true;
                    break;
                }
            }

            // Add in the set only if the characters are not part of any set
            if (!found) {
                TreeSet<Character> treeSet = new TreeSet<>();
                treeSet.add(charS1);
                treeSet.add(charS2);
                setList.add(treeSet);
            }
        }

        // Get the result by iterating the baseStr
        for(int i=0;i<baseStr.length();i++) {
            char baseChar = baseStr.charAt(i);
            boolean baserStrFound = false;

            // Check in the setList to get the smallest lexicographically char
            for(TreeSet<Character> set : setList) {
                if(set.contains(baseChar)) {
                    Character firstCharacter = set.iterator().next();
                    finalString += firstCharacter;
                    baserStrFound = true;
                    break;
                }
            }

            // If the element is not found in the set
            if(!baserStrFound) {
                finalString += baseChar;
            }

        }

        return finalString;

    }