class AllOne {
    private class Node {
        int count;
        LinkedHashSet<String> keysSet;
        Node previous, next;
        
        Node(int c) {
            count = c;
            keysSet = new LinkedHashSet<>();
        }
    }
    
    private Map<String, Node> keyToNodeMap;
    private Node headNode, tailNode;
    
    public AllOne() {
        keyToNodeMap = new HashMap<>();
        headNode = new Node(0);
        tailNode = new Node(0);
        headNode.next = tailNode;
        tailNode.previous = headNode;
    }
    
    private Node addNodeAfter(Node previousNode, int count) {
        Node newNode = new Node(count);
        newNode.next = previousNode.next;
        newNode.previous = previousNode;
        previousNode.next.previous = newNode;
        previousNode.next = newNode;
        return newNode;
    }

    private void removeNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public void inc(String key) {
        if (!keyToNodeMap.containsKey(key)) {
            if (headNode.next == tailNode || headNode.next.count != 1) {
                addNodeAfter(headNode, 1);
            }
            headNode.next.keysSet.add(key);
            keyToNodeMap.put(key, headNode.next);
        } else {
            Node currentNode = keyToNodeMap.get(key);
            int currentCount = currentNode.count;
            if (currentNode.next == tailNode || currentNode.next.count != currentCount + 1) {
                addNodeAfter(currentNode, currentCount + 1);
            }
            currentNode.next.keysSet.add(key);
            keyToNodeMap.put(key, currentNode.next);
            currentNode.keysSet.remove(key);
            if (currentNode.keysSet.isEmpty()) {
                removeNode(currentNode);
            }
        }
    }

    public void dec(String key) {
        if (!keyToNodeMap.containsKey(key)) {
            return;
        }
        
        Node currentNode = keyToNodeMap.get(key);
        int currentCount = currentNode.count;
        
        currentNode.keysSet.remove(key);
        
        if (currentCount == 1) {
            keyToNodeMap.remove(key);
        } else {
            if (currentNode.previous == headNode || currentNode.previous.count != currentCount - 1) {
                addNodeAfter(currentNode.previous, currentCount - 1);
            }
            currentNode.previous.keysSet.add(key);
            keyToNodeMap.put(key, currentNode.previous);
        }
        
        if (currentNode.keysSet.isEmpty()) {
            removeNode(currentNode);
        }
    }

    public String getMaxKey() {
        return tailNode.previous == headNode ? "" : tailNode.previous.keysSet.iterator().next();
    }

    public String getMinKey() {
        return headNode.next == tailNode ? "" : headNode.next.keysSet.iterator().next();
    }
}
