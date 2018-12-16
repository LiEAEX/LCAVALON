class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<>();
        for (String str : emails){
            String[] parts = str.split("@"); // split into local and domain parts
            String[] local = parts[0].split("\\+");
            s.add(local[0].replace(".", "") + "@" + parts[1]);
			//String local = parts[0].replace(".", ""); // remove all '.'
            //int i = local.indexOf('+');
            //s.add(local.substring(0, i) + "@" + parts[1]);
        }
        return s.size();
		//char[] a = str.toCharArray();
    }
}