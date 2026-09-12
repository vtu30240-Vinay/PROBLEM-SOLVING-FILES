class MyHashSet {

    private boolean[] set;

    public MyHashSet() {
        // Constraints: 0 <= key <= 1,000,000
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}
INPUT;
Input:
["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
[[],[1],[2],[1],[3],[2],[2],[2],[2]]

OUTPUT;
[null,null,null,true,false,null,true,null,false]
