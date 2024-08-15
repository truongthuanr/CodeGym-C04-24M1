package P10_List;

public class MyLinkedListTest {

    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList lkList = new MyLinkedList(10);

        lkList.addFirst(11);
        lkList.addFirst(12);
        lkList.addFirst(13);

        lkList.add(4,9);
        lkList.add(4,8);

        lkList.printList();
    }
}
