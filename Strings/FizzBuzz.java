class Solution {
     public List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1,n)
                .mapToObj(num -> checkDivisiblity(num))
                .collect(Collectors.toList());
    }

    private String checkDivisiblity(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }
}
