package javaFoundation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ChenXiang
 * 2019/08/31,16:52
 * 实现LRU，要求get和put的时间复杂度为O(1)
 * 也就是维护的时间复杂度不计
 */
public class LRU {

    class LRU1<k, v> {
        /**
         * 第一种思想使用LinkedHashMap来实现
         * LinkedHashMap的一个构造函数，
         * （int initialCapacity,
         * float loadFactor,
         * boolean accessOrder）
         * 传入的第三个参数accessOrder为true的时候，就按访问顺序对LinkedHashMap排序，为false的时候就按插入顺序，默认是为false的
         * 当把accessOrder设置为true后，就可以把最近访问的元素置于最后面
         * <p>
         * 这是LinkedHashMap中另外一个方法，当返回true的时候，就会remove其中最久的元素,这个方法会在put和putAll插入新元素后，通过一个
         * void afterNodeInsertion(boolean evict) { // possibly remove eldest
         * 来进行调用，判断是否需要删除元素，
         * 可以通过重写这个方法来控制缓存元素的删除，
         * 当缓存满了后，就可以通过返回true删除最久未被使用的元素，达到LRU的要求。这样就可以满足上述第三点要求。
         * protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
         * return false;
         * }
         */
        private final int MAX_CACHE_SIZE;
        private final float DEFAULT_LOAD_FACTOR = 0.75F;
        LinkedHashMap<k, v> map;

        public LRU1(int cacheSize) {
            MAX_CACHE_SIZE = cacheSize;
            /**
             * 这里把capacity设置为(缓存大小 / loadFactor) + 1，这样可以在元素数目达到缓存大小时，不会再进行扩容，可以做到缓存大小不会再改变
             */
            int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
            /**
             * 第三个参数设置为true，代表LinkedHashMap按访问顺序排序，可作为LRU缓存
             * 第三个参数设置为false，代表按照插入顺序排序，可作为FIFO缓存
             */
            map = new LinkedHashMap<k, v>(capacity, DEFAULT_LOAD_FACTOR, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
                    return size() > MAX_CACHE_SIZE;
                }
            };
        }

        public synchronized void put(k key, v value) {
            map.put(key, value);
        }

        public synchronized v get(k key) {
            return map.get(key);
        }

        public synchronized void remove(k key) {
            map.remove(key);
        }

        public synchronized Set<Map.Entry<k, v>> getAll() {
            return map.entrySet();
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<k, v> entry : map.entrySet()) {
                stringBuilder.append(String.format("%s: %s  ", entry.getKey(), entry.getValue()));
            }
            return stringBuilder.toString();
        }
    }

    static class LRU2<k, v> {
        /**
         * 使用HashMap和链表来实现LRU缓存，主要思想和上面一样，每次添加元素或读取元素就将元素防止在链表头，缓存满了之后，就可以把尾部元素删除，实现LRU缓存
         * 只是这种方法需要自己实现移动节点和删除节点，为了防止缓存大小超出限制，每次进行put的时候都要进行检查，若缓存满了则删除尾部元素
         */
        private final int MAX_CACHE_SIZE;
        private Entry<k, v> head;
        private Entry<k, v> tail;

        private HashMap<k, Entry<k, v>> cache;

        public LRU2(int cacheSize) {
            MAX_CACHE_SIZE = cacheSize;
            cache = new HashMap<>();
        }

        private static class Entry<k, v> {
            Entry<k, v> pre;
            Entry<k, v> next;
            k key;
            v value;
        }

        private Entry<k, v> getEntry(k key) {
            return cache.get(key);
        }


        public void put(k key, v value) {
            Entry<k, v> entry = getEntry(key);
            if (entry == null) {
                if (cache.size() >= MAX_CACHE_SIZE) {
                    cache.remove(tail.key);
                    removeTail();
                }
                entry = new Entry<>();
                entry.key = key;
                entry.value = value;
                moveToHead(entry);
                cache.put(key, entry);
            } else {
                entry.value = value;
                moveToHead(entry);
            }
        }

        public v get(k key) {
            Entry<k, v> entry = getEntry(key);
            if (entry == null) {
                return null;
            }
            moveToHead(entry);
            return entry.value;
        }

        public void remove(k key) {
            Entry<k, v> entry = getEntry(key);
            if (entry != null) {
                if (entry == head) {
                    Entry<k, v> next = head.next;
                    head.next = null;
                    head = next;
                    head.pre = null;
                } else if (entry == tail) {
                    Entry<k, v> prev = tail.pre;
                    tail.pre = null;
                    tail = prev;
                    tail.next = null;
                } else {
                    entry.pre.next = entry.next;
                    entry.next.pre = entry.pre;
                }
                cache.remove(key);
            }
        }

        private void moveToHead(Entry<k, v> entry) {
            if (entry == head) {
                return;
            }
            if (entry.pre != null) {
                entry.pre.next = entry.next;
            }
            if (entry.next != null) {
                entry.next.pre = entry.pre;
            }
            if (entry==tail){
                Entry<k,v> prev=entry.pre;
                if (prev!=null){
                    tail.pre=null;
                    tail=prev;
                    tail.next=null;
                }
            }
            if (head==null||tail==null){
                head=tail=null;
                return;
            }
            entry.next=head;
            head.pre=entry;
            entry.pre=null;
            head=entry;
        }

        private void removeTail() {
            if (tail != null) {
                Entry<k, v> prev = tail.pre;
                if (prev == null) {
                    head = null;
                    tail = null;
                } else {
                    tail.pre = null;
                    tail = prev;
                    tail.next = null;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Entry<k, v> entry = head;
            while (entry != null) {
                stringBuilder.append(String.format("%s:%s ", entry.key, entry.value));
                entry = entry.next;
            }
            return stringBuilder.toString();
        }
    }
}
