Runtime: 2 ms, faster than 100.00% of Java online submissions for Remove Comments.
Memory Usage: 37.5 MB, less than 5.43% of Java online submissions for Remove Comments.

 str.substring(0,0) = "" 
 str.substring(str.length()) = ""

class Solution {    
    private boolean incomment;
    private String unfinish;
    private List<String> res;
    
    public List<String> removeComments(String[] source) {
        incomment = false;
        unfinish = "";
        res = new ArrayList<>();
        for (String line : source)
            if (incomment)
                processIncomment(line);
            else
                processNotIncomment(line);
        return res;
    }
    
    private void addLine(String line) {
        unfinish = "";
        if (!line.isEmpty())
            res.add(line);
    }
    
    private void processIncomment(String line) {
        int c = line.indexOf("*/");
        if (c == -1)
            return;
        incomment = false;
        processNotIncomment(line.substring(c + 2));
    }

    private void processNotIncomment(String line) {
        int a = line.indexOf("/*");
        int b = line.indexOf("//");
        if (a == -1 && b == -1) {
            addLine(unfinish + line);
            return;
        }
        if (b != -1 && (a == -1 || b < a)) {
            addLine(unfinish + line.substring(0, b));
            return;
        } 
        incomment = true;
        unfinish += line.substring(0, a);
        processIncomment(line.substring(a + 2));
    }
}