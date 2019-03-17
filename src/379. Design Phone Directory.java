class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    int maxNumbers = 0;
    HashMap<Integer, Integer> m = new HashMap<>();
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        for (int i = 0; i < maxNumbers; i++){
            m.put(i, 0);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int temp = 0;
        boolean check = false;
        for (int i = 0; i < maxNumbers; i++){
            if (m.get(i) == 0){
                m.put(i, 1);
                temp = i;
                check = true;
                break;
            }
        }
        if (!check) temp = -1;
        return temp;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (m.get(number) == 1) return false;
        else return true;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (m.get(number) != 1) return;
        m.put(number, 0);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */