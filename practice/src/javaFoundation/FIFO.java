package javaFoundation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ChenXiang
 * 2019/09/03,16:02
 */
public class FIFO<k, v> {
    /**
     * 先进先出，可以使用LinkedHashMap来实现，将第三个参数传入为false或者使用默认，可以实现按照插入顺序排序
     */
    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTOR = 0.75F;
    LinkedHashMap<k, v> map;

    public FIFO(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        /**
         * 这里把capacity设置为(缓存大小 / loadFactor) + 1，这样可以在元素数目达到缓存大小时，不会再进行扩容，可以做到缓存大小不会再改变
         */
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
        /**
         * 第三个参数设置为true，代表LinkedHashMap按访问顺序排序，可作为LRU缓存
         * 第三个参数设置为false，代表按照插入顺序排序，可作为FIFO缓存
         */
        map = new LinkedHashMap<k, v>(capacity, DEFAULT_LOAD_FACTOR, false) {
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