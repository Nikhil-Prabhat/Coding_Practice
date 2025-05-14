public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1) {
            return true;
        }

        Map<Character, Long> characterLongMap = s.chars()
                .mapToObj(charElement -> (char) charElement)
                .collect(Collectors.groupingBy(charElement -> charElement, Collectors.counting()));

        Long firstValue = characterLongMap
                            .values()
                            .iterator()
                            .next();

        return characterLongMap
                .entrySet()
                .stream()
                .allMatch(map -> map.getValue().equals(firstValue));

    }
	

public boolean repeatedSubstringPattern(String str) {
	int l = str.length();
	for(int i=l/2;i>=1;i--) {
		if(l%i==0) {
			int m = l/i;
			String subS = str.substring(0,i);
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<m;j++) {
				sb.append(subS);
			}
			if(sb.toString().equals(str)) return true;
		}
	}
	return false;
}


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s+s;
        return doubled.substring(1,doubled.length()-1).contains(s); 
    }
}
