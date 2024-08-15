package P10_List;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(6);

        System.out.println("Element4: " + listInteger.get(4));
        System.out.println("Element5: " + listInteger.get(5));
        System.out.println("Element1: " + listInteger.get(1));

        listInteger.get(7);
        System.out.println("Element7: " + listInteger.get(7));
    }
}
