package linkedlists;

import org.junit.Test;

public class MyLinkedListNoTailTest {

    @Test
    public void shouldAddValue() {
        MyLinkedListNoTail linkedList = new MyLinkedListNoTail();
        linkedList.addValue(0);
        linkedList.addValue(1);
        linkedList.addValue(2);

        System.out.println(linkedList);
    }

    @Test
    public void shouldRemoveAtIdx() {
        MyLinkedListNoTail linkedList = new MyLinkedListNoTail();
        linkedList.addValue(0);
        linkedList.addValue(1);
        linkedList.addValue(2);
        linkedList.addValue(3);

        linkedList.removeAtIdx(2);

        System.out.println(linkedList);
    }

    @Test
    public void shouldInsertHead() {
        MyLinkedListNoTail linkedList = new MyLinkedListNoTail();
        linkedList.addValue(1);
        linkedList.addValue(2);
        linkedList.addValue(3);

        linkedList.insertHead(0);

        System.out.println(linkedList);
    }
}