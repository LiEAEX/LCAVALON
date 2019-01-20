class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new LinkedList<>();
        HashMap<String, Integer> m = new HashMap<>();
        int n = cpdomains.length;
        
        for (int i = 0; i < n; i++){
            // a[0]-number  a[1]-address
            String[] a = cpdomains[i].split(" "); 
            // b[0], b[1], b[2] or b[0], b[1]
            // 必须用\\.对.进行正则化
            String[] b = a[1].split("\\."); // Each address will have either 1 or 2 "." characters.
            
            String temp = "";
            for(int j = b.length - 1; j >= 0; j--){
                temp = b[j] + (temp.equals("") ? temp : "." + temp);
                m.put(temp, m.getOrDefault(temp, 0) + Integer.parseInt(a[0]));
            }
        }
        
        for(String str : m.keySet()){
            res.add(m.get(str) + " " + str);
        }
        
        return res;
        
    }
}

用下面的拆字符串方法更快
int index = s.indexOf(' ');
int visit = Integer.parseInt(s.substring(0, index));
String domain = s.substring(index + 1);