import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        
        Map<Character, List<String>> map = new HashMap<>();
        
        if(digits.equals("")) return new ArrayList<>();
        map.computeIfAbsent('2', k-> List.of("a", "b", "c"));
        map.computeIfAbsent('3', k-> List.of("d", "e", "f"));
        map.computeIfAbsent('4', k-> List.of("g", "h", "i"));
        map.computeIfAbsent('5', k-> List.of("j", "k", "l"));
        map.computeIfAbsent('6', k-> List.of("m", "n", "o"));
        map.computeIfAbsent('7', k-> List.of("p", "q", "r", "s"));
        map.computeIfAbsent('8', k-> List.of("t", "u", "v"));
        map.computeIfAbsent('9', k-> List.of("w", "x", "y", "z"));
        List<String> answer = new ArrayList<>();
        backtracking(map, digits, 0, new StringBuilder(), answer);

        return answer; 
    }

    private void backtracking(
        Map<Character,List<String>> map, String digits, int offset, StringBuilder comb,
        List<String> answer) {
            if(offset == digits.length()) {
                answer.add(comb.toString());
                return;
            }

            for(String l : map.get(digits.charAt(offset))) {
                comb.append(l);
                backtracking(map, digits, offset+1, comb, answer);
                comb.deleteCharAt(comb.length()-1);
            }
    }
}