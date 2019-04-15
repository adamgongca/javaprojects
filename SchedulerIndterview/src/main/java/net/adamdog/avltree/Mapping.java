package net.adamdog.avltree;

import java.util.NoSuchElementException;

public interface Mapping<K, V> {
	public V get(K k) throws NoSuchElementException;
	public default boolean defined(K k) {
		try {
			this.get(k);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}
	};
	public void set(K k, V v);
	public V remove(K k) throws NoSuchElementException;

}