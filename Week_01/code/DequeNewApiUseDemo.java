import java.util.Deque;
import java.util.LinkedList;

/**
 * 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 * @author jaylinjiehong
 * @date 2020-06-27
 */
public class DequeNewApiUseDemo {
    public static void main(String[] args) {
//        Deque<String> deque = new LinkedList<String>();
//        deque.push("a");
//        deque.push("b");
//        deque.push("c");
//        System.out.println(deque);
//
//        String str = deque.peek();
//        System.out.println(str);
//        System.out.println(deque);
//
//        while (deque.size()>0){
//            System.out.println(deque.pop());
//        }
//        System.out.println(deque);

        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size()>0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
