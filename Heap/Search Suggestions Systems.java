class Solution {
    /* Priority Queue does not have any order, it's order is dependent on how you poll it */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });

        Arrays.stream(products).forEach(
                product -> priorityQueue.add(product)
        );

        List<String> listWithLexicorgraphicallySortedElements = new ArrayList<>();
        while (!priorityQueue.isEmpty())
            listWithLexicorgraphicallySortedElements.add(priorityQueue.poll());

        String searchWordSeachKey = "";
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            searchWordSeachKey += searchWord.charAt(i);
            List<String> elementsAsPerSearchkey = getElementsAsPerSearchkey(searchWordSeachKey, listWithLexicorgraphicallySortedElements);
            result.add(elementsAsPerSearchkey);
        }

        return result;
    }

    private List<String> getElementsAsPerSearchkey(String key, List<String> stringlist) {
        List<String> resultList = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < stringlist.size(); i++) {
            if (stringlist.get(i).contains(key) && count < 3) {
                resultList.add(stringlist.get(i));
                count++;
            }

            if (count == 4)
                break;
        }
        return resultList;
    }
}


// Accepted Solution 
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        			PriorityQueue<String> priority = new PriorityQueue<>(3, (s1, s2) -> s1.compareTo(s2));
			List<List<String>> list = new ArrayList<>();

			for (int i = 1; i <= searchWord.length(); i++) {
				String temp = searchWord.substring(0, i);
				for (String s : products) {
					if (s.startsWith(temp)) {
						priority.offer(s);
					}
				}
				List<String> temp_list = new ArrayList<>();
				for (int j = 0; j < 3; j++) {
					if (priority.peek() != null) {
						temp_list.add(priority.poll());
					}
				}
				priority.clear();
				list.add(temp_list);
			}
			return list;
    }

}