package ru.job4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class MyCache.
 *
 * @param <V> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.09.2017
 */
public class MyCache<V extends Model> {

    /**
     * The cache.
     */
    private Map<Integer, V> cache = new ConcurrentHashMap();

    /**
     * This method adds the value in cache.
     *
     * @param value value.
     * @return if value added then return true otherwise false.
     */
    public boolean add(V value) {
        boolean result = false;
        if (!this.cache.containsValue(value)) {
            this.cache.put(this.cache.size(), value);
            result = true;
        }
        return result;
    }

    /**
     * This method removes the value from cache.
     *
     * @param key key.
     * @return if value removed then return true otherwise false.
     */
    public boolean delete(Integer key) {
        boolean result = false;
        if (this.cache.containsKey(key)) {
            this.cache.remove(key);
            result = true;
        }
        return result;
    }

    /**
     * This method updates the value from cache.
     *
     * @param key   key.
     * @param value value.
     * @return if value updated then return true otherwise false.
     */
    public V update(Integer key, V value) {
        return this.cache.computeIfPresent(key, (k, v) -> {
            if (value.getVersion() == v.getVersion()) {
                value.updateVersion();

            } else {
                try {
                    throw new OptimisticException("Used another version!");
                } catch (OptimisticException e) {
                    e.printStackTrace();
                }
            }
            return value;
        });
    }
}