package term2.sorted;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Двусвязный список, где каждый элемент содержит ссылки на предыдущий и следующий элементы. 
 * Реализация java.util.LinkedList в openjdk 7
 * http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/7-b147/java/util/LinkedList.java?av=f
 */
public class DoublyLinkedList<T> implements List<T> {
	
	//первый элемент списка
	private Node<T> first;
	 
	//последний элемент списка
	private Node<T> last;
	
	/* количество модификаций списка. Необходимо для отслеживания модификаций
	 * списка во время перебора итератором.*/
	private int modCount;
	
	// количество элементов в списке
	private int size;

	/**
	 * Класс элемента списка
	 */
	private static class Node<T> {
		//ссылка на предыдущий элемент списка
		Node<T> prev;
		//ссылка на следующий элемент списка
		Node<T> next;
		//данные текущего элемента
		T data;
		
		//конструктор класса Node<T> с тремя параметрами
		public Node(Node<T> prev, T data,Node<T> next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	/*
	 * Итератор, позволяющий перебирать элементы списка в обоих направлениях
	 * http://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
	 */
	private class ListItr implements ListIterator<T> {
		/* Последний элемент, который вернул итератор
		 * Если элемент был удален, то lastReturned = null
		 */
		private Node<T> lastReturned = null;
		//следующий элемент, который вернет метод next()
		private Node<T> next;
		//индекс следующего элемента, который вернет метод next()
		private int nextIndex;
		/* Запоминаем количество модификаций списка до начала перебора, 
		 * чтобы отслеживать конкурентные модификации
		 */
		private int expectedModCount = modCount;
		
		/*В качестве аргумента в конструктор передается индекс элемента, 
		с которого требуется начать перебор */
		ListItr(int index) {
			next = (index == size) ? null : getNode(index);
			nextIndex = index;
		}
		
		/**
		 * @return Возвращает true, если перебраны еще не все элементы 
		 * в направлении к концу списка
		 */
		public boolean hasNext() {
			return nextIndex < size;
		}

		/**
		 * @return Возвращает следующий элемент в направлении к концу списка
		 * @throws NoSuchElementException
		 *             если в текущей итерации перебраны все элементы
		 */
		public T next() {
			// проверяем, не было ли конкурентных модификаций
			checkForComodification();
			// если в текущей итерации перебраны все элементы, кидаем исключение
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			/*
			 * Возвращаем данные элемента next и сдвигаем ссылки next и lastReturned
			 */
