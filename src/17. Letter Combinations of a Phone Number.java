class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        
        if (digits.length() == 0) {
            return list;
        }
        
        if (digits.length() == 1) {
            String letters = getString(digits.charAt(0));
            
            for (char letter : letters.toCharArray()) {
                list.add(letter + "");
            }
            
            return list;
        }
        
       
        combineAndMix(0, digits, "", list);
        
        return list;
    }
    
    private void combineAndMix(int index, 
                               String digits, 
                               String current, 
                               List<String> result) {
        
        if (current.length() == digits.length()) {
            result.add(current);
        } else {
            String newLetters  = getString(digits.charAt(index));
            
            for (char letter : newLetters.toCharArray()) {
                combineAndMix(index + 1, digits, current + letter, result);
            }
        }
    }
    
    private String getString(char letter) {
            switch(letter) {
                case '2':
                    return "abc";
                case '3':
                    return "def";
                case '4':
                    return "ghi";
                case '5':
                    return "jkl";
                case '6':
                    return "mno";
                case '7':
                    return "pqrs";
                case '8':
                    return "tuv";
                case '9':
                    return "wxyz";                    
                default:
                    return "";
            }
        
    }
}