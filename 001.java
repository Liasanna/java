import java.util.LinkedList;
import java.util.Queue;
 
class Main
{
    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<String>();
 
        queue.add("A");     // Вставляем `A` в queue
        queue.add("B");     // Вставляем `B` в queue
        queue.add("C");     // Вставляем `C` в queue
        queue.add("D");     // Вставляем `D` в queue
 
        // Печатает начало queue (`A`)
        System.out.println("The front element is " + queue.peek());
 
        queue.remove();     // удаление переднего элемента (`A`)
        queue.remove();     // удаление переднего элемента (`B`)
 
        // Печатает начало queue (`C`)
        System.out.println("The front element is " + queue.peek());
 
        // Возвращает общее количество элементов в queue
        System.out.println("The queue size is " + queue.size());
 
        // проверяем, пуста ли queue
        if (queue.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }
    }
}