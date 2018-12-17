class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> s = new ArrayList<>();
        for (int i = 1; i < n + 1; i++){
            if (i % 3 == 0 && i % 5 == 0){
                s.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0 && i % 5 != 0){
                s.add("Fizz");
                continue;
            }
            if (i % 3 != 0 && i % 5 == 0){
                s.add("Buzz");
                continue;
            }
            String tmp = Integer.toString(i);
            s.add(tmp);
        }
        return s;
    }
}