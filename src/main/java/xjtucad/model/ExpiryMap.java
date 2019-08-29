package xjtucad.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 带有效期的HashMap 简单实现 实现了基本的方法，内部有一个(K,Long)的HashMap
 *
 * @param <K>
 * @param <V>
 */
public class ExpiryMap<K, V> extends HashMap<K, V>{

    private static final long serialVersionUID = 1L;

    /**
     * default expiry time 30m
     */
    private long EXPIRY = 1000 * 60 *60*24;

    private HashMap<K, Long> expiryMap = new HashMap<>();

    public ExpiryMap(){
        super();
    }

    //1<<4 = 16
    public ExpiryMap(long defaultExpiryTime){
        this(1 << 4, defaultExpiryTime);
    }
    public ExpiryMap(int initialCapacity, long defaultExpiryTime){
        super(initialCapacity);
        this.EXPIRY = defaultExpiryTime;
    }

    /**
     * 不传入有效期的put，采用默认的EXPIRY，30min
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        expiryMap.put(key, System.currentTimeMillis() + EXPIRY);
        return super.put(key, value);
    }
    public boolean containsKey(Object key) {
        return !checkExpiry(key, true) && super.containsKey(key);
    }
    /**
     * 传入有效期的put
     *
     * @param key
     * @param value
     * @param expiryTime 键值对有效期 毫秒
     * @return
     */
    public V put(K key, V value, long expiryTime) {
        expiryMap.put(key, System.currentTimeMillis() + expiryTime);
        return super.put(key, value);
    }
    public int size() {
        return entrySet().size();
    }
    public boolean isEmpty() {
        return entrySet().size() == 0;
    }

    /**
     * 检查某个value对应的key是否在expiryMap的有效期内
     *
     * @param value 一个HashMap
     * @return
     */
    public boolean containsValue(Object value) {
        if (value == null) return Boolean.FALSE;
        Set<Map.Entry<K, V>> set = super.entrySet();
        Iterator<Map.Entry<K, V>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            //K=key
            //V=HashMap
            if(value.equals(entry.getValue())){
                if(checkExpiry(entry.getKey(), false)) {
                    iterator.remove();
                    return Boolean.FALSE;
                }else return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 获取集合中所有的值，去掉不存在的value
     *
     * @return
     */
    public Collection<V> values() {

        Collection<V> values = super.values();

        if(values == null || values.size() < 1) return values;

        Iterator<V> iterator = values.iterator();

        while (iterator.hasNext()) {
            V next = iterator.next();
            if(!containsValue(next)) iterator.remove();
        }
        return values;
    }
    public V get(Object key) {
        if (key == null)
            return null;
        if(checkExpiry(key, true))
            return null;
        return super.get(key);
    }
    /**
     * @param key
     * @return null:不存在或key为null -1:过期  存在且没过期返回value 因为过期的不是实时删除，所以稍微有点作用
     * @Description: 是否过期
     */
    public Object isInvalid(Object key) {
        if (key == null)
            return null;
        if(!expiryMap.containsKey(key)){
            return null;
        }
        long expiryTime = expiryMap.get(key);

        boolean flag = System.currentTimeMillis() > expiryTime;

        if(flag){
            super.remove(key);
            expiryMap.remove(key);
            return -1;
        }
        return super.get(key);
    }
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            expiryMap.put(e.getKey(), System.currentTimeMillis() + EXPIRY);
        super.putAll(m);
    }

    /**
     * @return 过滤掉已过期token的entrySet
     */
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K, V>> set = super.entrySet();
        Iterator<Map.Entry<K, V>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            if(checkExpiry(entry.getKey(), false)) iterator.remove();
        }

        return set;
    }
    /**
     * 检查有效期
     *
     * @param isRemoveSuper 为true 则super中也删除
     * @return
     * @Description: 是否过期
     * @author: qd-ankang
     * @date: 2016-11-24 下午4:05:02
     */
    private boolean checkExpiry(Object key, boolean isRemoveSuper){

        if(!expiryMap.containsKey(key)){
            return Boolean.FALSE;
        }
        long expiryTime = expiryMap.get(key);

        boolean flag = System.currentTimeMillis() > expiryTime;

        if(flag){
            //如果过期，从expiryMap中删除这个有效期
            if(isRemoveSuper)
                super.remove(key);
            expiryMap.remove(key);
        }else {
            //没过期，重置有效期（默认的30min）
            expiryMap.put((K)key,System.currentTimeMillis() + EXPIRY);
        }
        return flag;
    }
//    public static void main(String[] args) throws InterruptedException {
//
//        ExpiryMap<String, String> map = new ExpiryMap<>(10);
//        map.put("test", "ankang");
//        map.put("test1", "ankang");
//        map.put("test2", "ankang", 3000);
//        System.out.println("test1" + map.get("test"));
//        Thread.sleep(1000);
//        System.out.println("isInvalid:" + map.isInvalid("test"));
//        System.out.println("size:" + map.size());
//        System.out.println("size:" + ((HashMap<String, String>)map).size());
//        for (Map.Entry<String, String> m : map.entrySet()) {
//            System.out.println("isInvalid:" + map.isInvalid(m.getKey()));
//            map.containsKey(m.getKey());
//            System.out.println("key:" + m.getKey() + "     value:" + m.getValue());
//        }
//        System.out.println("test1" + map.get("test"));
//
//    }
}