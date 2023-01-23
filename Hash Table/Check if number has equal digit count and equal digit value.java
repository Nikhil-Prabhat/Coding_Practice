class Solution {
    public boolean digitCount(String num) {
     Map<Integer,Integer> referenceMap = new HashMap<>();
        Map<Integer,Integer> actualMap = new HashMap<>();
        boolean result = Boolean.TRUE;

        // Reference Map
        for(int i=0;i<num.length();i++)
        {
            referenceMap.put(i,num.charAt(i)-'0');
        }

        // Actual Map
        for(int i=0;i<num.length();i++)
        {
            int numChar = num.charAt(i) - '0';
            actualMap.put(numChar,actualMap.getOrDefault(numChar,0)+1);
        }

        // Return true if both maps are equal else false
        for(Map.Entry<Integer,Integer> map : referenceMap.entrySet())
        {
            if(Objects.isNull(actualMap.get(map.getKey()))) {
                if (map.getValue() != 0)
                    return false;
            }
            else if(Objects.nonNull(actualMap.get(map.getKey())) && map.getValue() != actualMap.get(map.getKey()))
                return false;
        }

        return true;
    }
}