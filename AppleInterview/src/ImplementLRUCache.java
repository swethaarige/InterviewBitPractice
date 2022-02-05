import java.util.*;

/*
Least Recently Used (LRU) is a common caching strategy. It defines the policy to evict elements
from the cache to make room for new elements when the cache is full, meaning it discards the least
recently used items first.
Let’s take an example of a cache that has a capacity of 4 elements. We cache elements 1, 2, 3 and 4.
The diagram above represents the cache state after first access of all four elements.
We now need to cache another element “5”.
In LRU cache, we evict the least recently used element (in this case “1”) in case a new element
needs to be cached. Now “2” is next in line to be evicted if a new element needs to be cached.
Let’s see what happens when “2” is accessed again.
Now “3” becomes the next in line to be evicted from the cache.
Hint
Doubly linked list
Hashing
Think about evictions
Caching is a technique to store data in a faster storage (usually RAM) to serve future requests faster.
Cache stores are usually not big enough to store a full data set. We need to evict data from the cache
when it becomes full.
LRU is very simple and a commonly used algorithm for this process. We evict the oldest data from the
cache to accommodate new data.
To implement an LRU cache we use two data structures: a hashmap and a doubly linked list. A doubly
linked list helps in maintaining the eviction order and a hashmap helps with O(1)O(1) lookup of cached
keys. Here is the algorithm:
If the element exists in hashmap
    move the accessed element to the tail of the linked list
Otherwise,
    if eviction is needed i.e. cache is already full
        Remove the head element from doubly linked list and delete its hashmap entry
    Add the new element at the tail of linked list and in hashmap
Get from Cache and Return
Note: The doubly linked list is for tracking the most recently accessed elements. The element at the tail of the doubly linked list is the most recently accessed element.

All newly inserted elements go to the tail, and any element accessed goes to the tail.

Runtime Complexity:

get (hashset): Constant, O(1)O(1)
set (hashset): Constant, O(1)O(1)
Deletion at head when adding a new element: Constant, O(1)O(1)
Search for deleting and adding to tail: Linear, O(n)O(n)
Memory Complexity: Linear, O(n)O(n), where nn is the size of cache
 */
public class ImplementLRUCache {
    static class LRUCache {
        public static class LinkedListNode {
            int value;
            LinkedListNode next;

            LinkedListNode(int value) {
                this.value = value;
                this.next = null;
            }
        }

        int capacity;

        //LinkedListNode holds key and value pairs
        Set<Integer> cache;
        LinkedList<LinkedListNode> cache_vals;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashSet<Integer>(capacity);
            cache_vals = new LinkedList<LinkedListNode>();
        }


        LinkedListNode get(int key) {
            if (!cache.contains(key)) {

                return null;
            } else {

                ListIterator<LinkedListNode> iterator1 = cache_vals.listIterator(0);
                while (iterator1.hasNext()) {
                    LinkedListNode node = iterator1.next();
                    if (node.value == key) {
                        return node;
                    }
                }
                return null;
            }
        }

        void set(int key, int value) {
            LinkedListNode node = get(key);

            if (node == null) {
                evict_if_needed();
                node = new LinkedListNode(key);
                cache_vals.addLast(node);
                cache.add(key);
            } else {
                cache_vals.remove(node);
                cache_vals.addLast(node);
            }
        }

        void evict_if_needed() {
            if (cache_vals.size() >= capacity) {
                LinkedListNode node = cache_vals.remove();
                cache.remove(node.value);

            }
        }

    }
}