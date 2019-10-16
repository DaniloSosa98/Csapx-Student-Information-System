import java.util.Collection;

public interface DB<K, V>{

    V addValue(V value);

    Collection<V> getAllValues();

    V getValue(K key);

    boolean hasKey(K key);
}
