class AllOne {
    class Node {
        Node last, next;
        Set<String> keys = new HashSet<>();
        int count;
        public Node(int count, String key) {
            this.count = count;
            this.keys.add(key);
        }
    }
    Map<String, Node> map;
    Node head, tail; // Doubly Linked List
    
    public AllOne() {
        map = new HashMap<>();
        head = new Node(-1, "");
        tail = new Node(-1, "");
        head.next = tail;
        tail.last = head;
    }
    
    
    public void inc(String key) {
      
        Node node = map.getOrDefault(key, head);
        int count = removeKey(key) + 1;
        
        
        if (node.next.count != count) insert(node, node.next, new Node(count, key));
        else node.next.keys.add(key);
        map.put(key, node.next);
        
        // Clean up
        if (node.keys.isEmpty()) remove(node);
    }
    
   
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        
        Node node = map.get(key);
        int count = removeKey(key) - 1;
        if (count == 0) { // reduce to 0, delete
            map.remove(key);
        } else { 
            if (node.last.count != count) insert(node.last, node, new Node(count, key));
            else node.last.keys.add(key);
            map.put(key, node.last);
        }
        
        if (node.keys.isEmpty()) remove(node);
    }
    
    
    public String getMaxKey() {
        if (map.isEmpty()) return "";
        return tail.last.keys.iterator().next();
    }
    
    
    public String getMinKey() {
        if (map.isEmpty()) return "";
        return head.next.keys.iterator().next();
    }
        
    private void remove(Node node) {
        node.last.next = node.next;
        node.next.last = node.last;
    }
    
    private int removeKey(String key) {
        if (!map.containsKey(key)) return 0;
        Node node = map.get(key);
        node.keys.remove(key);
        return node.count;
    }
    
    private void insert(Node last, Node next, Node newNode) {
        newNode.next = next;
        next.last = newNode;
        last.next = newNode;
        newNode.last = last;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */