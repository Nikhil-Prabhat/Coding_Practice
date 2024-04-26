class Solution {
    int citiesCount;
    long sumOfCities = 0;
    
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> citiesConnectionCountMap = new HashMap<>();
        Map<Integer, Integer> valuesMap = new HashMap<>();
        citiesCount = n;

        // Initialise the citiesConnectionMap
        Arrays.stream(roads)
                .forEach(
                        arr -> {
                            citiesConnectionCountMap.put(arr[0], citiesConnectionCountMap.getOrDefault(arr[0], 0) + 1);
                            citiesConnectionCountMap.put(arr[1], citiesConnectionCountMap.getOrDefault(arr[1], 0) + 1);
                        }
                );

        // Initialise the valuesMap
        citiesConnectionCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(map -> map.getKey())
                .forEach(
                        cityConnectionMapKey -> {
                            valuesMap.put(cityConnectionMapKey, citiesCount--);
                        }
                );

        // Calculate the final sum
        Arrays.stream(roads)
                .forEach(
                        arr -> {
                            sumOfCities += (valuesMap.get(arr[0]) + valuesMap.get(arr[1]));
                        }
                );

        return sumOfCities;
    }
}