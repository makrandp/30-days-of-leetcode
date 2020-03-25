/**
 * 
 * Leetcode problem #1146. Snapshot Array
 * 
 * https://leetcode.com/problems/snapshot-array/
 */

class SnapshotArray {
    
    List<HashMap<Integer, Integer>> snaps;
    public SnapshotArray(int length) {
        snaps = new ArrayList<>();
        //add first hashmap
        snaps.add(new HashMap<>());
    }
    
    public void set(int index, int val) {
        int snapId = snaps.size() - 1;
        snaps.get(snapId).put(index, val);
    }
    
    public int snap() {
        int snapId = snaps.size() - 1;
        snaps.add(new HashMap<>());
        return snapId;
    }
    
    public int get(int index, int snap_id) {
        for(int i = snap_id; i >= 0; i--) {
            if(snaps.get(i).containsKey(index)) {
                return snaps.get(i).get(index);
            }
        }
        //return 0 if not found
        return 0;
    }
}

//Using treemap
class SnapshotArray {
    
    List<TreeMap<Integer, Integer>> snaps;
    int snapId = 0;

    public SnapshotArray(int length) {
        snaps = new ArrayList<>();
        for(int i = 0; i < length; i++)
        {
            snaps.add(new TreeMap<Integer, Integer>());
            snaps.get(i).put(0,0);
        }
    }
    
    public void set(int index, int val) {
        snaps.get(index).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return snaps.get(index).floorEntry(snap_id).getValue();
    }
}