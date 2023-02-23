import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            boolean div3 = (i % 3 == 0);
            boolean div5 = (i % 5 == 0);
            if( div3 && div5 ) {
                result.add("FizzBuzz");
            } else if (div3) {
                result.add("Fizz");
            } else if ( div5 ) {
                result.add("Buzz");
            } else {
                result.add("" + i);
            }
        }
        return result;
    }
}
