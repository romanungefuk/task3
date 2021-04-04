import java.util.*;

public class Task3 {


    public static void main(String[] args) {
        TimeManager timeManager = new TimeManager();
        MyClass myClass = new MyClass();

        task31(timeManager, myClass);
        task32(timeManager, myClass);
        task33();
        task34(myClass);
        task35(myClass);

    }

    private static void task31(TimeManager timeManager, MyClass myClass) {
        String[] calendar = myClass.getCalendar();

        timeManager.setStartTime();
        List calendarList = Arrays.asList(calendar);
        timeManager.setEndTime();
        System.out.println("Преобразование массива в простой список заняло " + timeManager.getRunTime() + " нс");

        try {
            calendarList.add("13th month");
        } catch (UnsupportedOperationException e) {
            System.out.println("Но простой список имеет статический размер и не поддерживает добавление или удаление элементов");
        }

        timeManager.setStartTime();
        Collection calendarCollection = Arrays.asList(calendar);
        timeManager.setEndTime();
        System.out.println("Преобразование массива в коллекцию заняло " + timeManager.getRunTime() + " нс");

        try {
            calendarCollection.add("13th month");
        } catch (UnsupportedOperationException e) {
            System.out.println("Так же и интерфейс коллекции не поддерживает добавление или удаление элементов");
        }

        timeManager.setStartTime();
        ArrayList<String> calendarArrayList = new ArrayList<>(Arrays.asList(calendar));
        timeManager.setEndTime();
        System.out.println("Преобразование массива в ArrayList заняло " + timeManager.getRunTime() + " нс");

        calendarArrayList.add("13th month");
        System.out.println("В отличие от ArrayList:\n" + calendarArrayList);
    }

    private static void task32(TimeManager timeManager, MyClass myClass) {
        String temp;
        final int GET_INDEX_FOR_ARRAY_LIST = 5;


        String[] calendar = myClass.getCalendar();
        ArrayList<String> calendarList = new ArrayList<>(Arrays.asList(calendar));

        timeManager.setStartTime();
        calendarList.add("13th month");
        timeManager.setEndTime();
        System.out.println(calendarList + "\nДобавление нового элемента заняло " + timeManager.getRunTime() + " нс");

        timeManager.setStartTime();
        temp = calendarList.get(GET_INDEX_FOR_ARRAY_LIST);
        timeManager.setEndTime();
        System.out.println(temp + "\nОбращение к элементу ArrayList под индексом " + GET_INDEX_FOR_ARRAY_LIST + " заняло " + timeManager.getRunTime() + " нс");

        timeManager.setStartTime();
        calendarList.set(1,"Февраль");
        timeManager.setEndTime();
        System.out.println(calendarList + "\nИзменение значения элемента по индексу заняло " + timeManager.getRunTime() + " нс");

        timeManager.setStartTime();
        calendarList.remove("13th month");
        timeManager.setEndTime();
        System.out.println(calendarList + "\nУдаление элемента ArrayList по содержимому объекта заняло " + timeManager.getRunTime() + " нс");

        timeManager.setStartTime();
        calendarList.remove(3);
        timeManager.setEndTime();
        System.out.println(calendarList + "\nУдаление элемента ArrayList по индексу объекта заняло " + timeManager.getRunTime() + " нс");
    }

    private static void task33() {
        OneWayLinkedList<String> oneWayLinkedList = new OneWayLinkedList<>();

//        Добавление новых элементов
        oneWayLinkedList.insert("One");
        oneWayLinkedList.insert("Two");
        oneWayLinkedList.insert("Three");
//        Вывод односвязного списка в консоль
        oneWayLinkedList.display();
//        Поиск элемента
        System.out.println(oneWayLinkedList.find("One"));
//        Удаление первого элемента
        oneWayLinkedList.deleteFirst();
        oneWayLinkedList.display();
//        Удаление всех элементов
        while (!oneWayLinkedList.isEmpty()) {
            oneWayLinkedList.deleteFirst();
        }
        oneWayLinkedList.display();
        System.out.println(oneWayLinkedList.isEmpty());
    }

    private static void task34(MyClass myClass) {
        LinkedList<String> calendarLinkedList = new LinkedList<>(Arrays.asList(myClass.getCalendar()));
        System.out.println(calendarLinkedList);

        calendarLinkedList.add("13th month");
        System.out.println(calendarLinkedList);

        System.out.println(calendarLinkedList.get(5));

        calendarLinkedList.add(3,"Апрель");
        System.out.println(calendarLinkedList);

        calendarLinkedList.set(7, "Июль");
        System.out.println(calendarLinkedList);

        calendarLinkedList.addFirst("Январь");
        System.out.println(calendarLinkedList);

        calendarLinkedList.addLast("Декабрь");
        System.out.println(calendarLinkedList);

        System.out.println(calendarLinkedList.contains("13"));
        System.out.println(calendarLinkedList.contains("13th month"));

        System.out.println(calendarLinkedList.peekFirst());
        System.out.println(calendarLinkedList.peekLast());

        calendarLinkedList.removeFirst();
        System.out.println(calendarLinkedList);
        calendarLinkedList.removeLast();
        System.out.println(calendarLinkedList);

        calendarLinkedList.remove("Апрель");
        System.out.println(calendarLinkedList);
        calendarLinkedList.remove(12);
        System.out.println(calendarLinkedList);
    }

    private static void task35(MyClass myClass) {
        String[] calendar = myClass.getCalendar();
        ArrayList<String> calendarArrayList = new ArrayList<>(Arrays.asList(calendar));
        ArrayList<String> calendarArrayListCopy = new ArrayList<>();
        calendarArrayListCopy.addAll(calendarArrayList);
        ArrayList<String> calendarArrayListCopy2 = new ArrayList<>();
        calendarArrayListCopy2.addAll(calendarArrayList);


        Iterator<String> iter = calendarArrayList.iterator();

        System.out.println(calendarArrayList);

        while (iter.hasNext()) {
            System.out.println(iter.next());
            iter.remove();
        }
        System.out.println(calendarArrayList);

        ListIterator<String> listIterator = calendarArrayListCopy.listIterator();

        while (listIterator.hasNext()) {
            listIterator.next();
        }

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
            listIterator.set("Замена");
        }

        System.out.println(calendarArrayListCopy);

        for (String s : calendarArrayListCopy2) {
            System.out.println(s);
        }
    }
}
