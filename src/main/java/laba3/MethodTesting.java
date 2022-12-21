package laba3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A class that shows the execution time of ArrayList and LinkedList collections
 *
 * @author mqiiz
 */
public class MethodTesting {

    /**
     * Enum of available operations
     */
    private enum Operation {
        ADD,
        DELETE,
        GET
    }

    /**
     * @value ArrayList to test
     */
    private final List<Integer> arrayList;

    /**
     * @value LinkedList to test
     */
    private final List<Integer> linkedList;

    /**
     * @value Amount of operations
     */
    private final int amount;

    /**
     * Constructor which initializes lists and invokes MethodTesting method
     *
     * @param amount Amount of operations
     */

    public MethodTesting(int amount) {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        this.amount = amount;
        init();
    }

    /**
     * A method that fills lists
     */
    private void init() {
        for (int i = 0; i < amount; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    /**
     * A method that calculates the time spent on list method execution
     *
     * @param list Which list to test
     * @param operation Which operation to test
     * @return Time spent on execution
     */
    private long test(List<Integer> list, Operation operation) {
        long startTime = System.currentTimeMillis();
        switch (operation) {
            case ADD:
                for (int i = 0; i < amount; i++)
                    list.add(i);
                break;
            case DELETE:
                for (int i = 0; i < amount; i++)
                    list.remove(i);
                break;
            case GET:
                for (int i = 0; i < amount; i++)
                    list.get(i);
                break;
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * A method that prints the table with results
     */
    public void printResults() {
        System.out.println("List\t\tMethod\t\tAmount\t\tTime\n");
        System.out.println(String.format("ArrayList\tAdd\t\t\t%d\t\t%d ms", amount, test(arrayList, Operation.ADD)));
        System.out.println(String.format("ArrayList\tDelete\t\t%d\t\t%d ms", amount, test(arrayList, Operation.DELETE)));
        System.out.println(String.format("ArrayList\tGet\t\t\t%d\t\t%d ms", amount, test(arrayList, Operation.GET)));
        System.out.println(String.format("LinkedList\tAdd\t\t\t%d\t\t%d ms", amount, test(linkedList, Operation.ADD)));
        System.out.println(String.format("LinkedList\tDelete\t\t%d\t\t%d ms", amount, test(linkedList, Operation.DELETE)));
        System.out.println(String.format("LinkedList\tGet\t\t\t%d\t\t%d ms", amount, test(linkedList, Operation.GET)));
    }

}