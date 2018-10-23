import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgo {

    private static List<GreedyAlgo> list = new ArrayList<>();

    static {
        //wi=[35、30、60、50、40、10、25]
        //pi=[10、40、30、50、35、40、30]
        list.add(new GreedyAlgo(35, 10, 0, 1));
        list.add(new GreedyAlgo(30, 40, 0, 2));
        list.add(new GreedyAlgo(60, 30, 0, 3));
        list.add(new GreedyAlgo(50, 50, 0, 4));
        list.add(new GreedyAlgo(40, 35, 0, 5));
        list.add(new GreedyAlgo(10, 40, 0, 6));
        list.add(new GreedyAlgo(25, 30, 0, 7));

    }

    int code;
    int weight;
    int price;
    int status;

    public GreedyAlgo(int weight, int price, int status, int code) {
        this.weight = weight;
        this.price = price;
        this.status = status;
        this.code = code;
    }


    public static int biggest(int sum) {
        list.sort(new Comparator<GreedyAlgo>() {
            @Override
            public int compare(GreedyAlgo o1, GreedyAlgo o2) {
                return -(o1.price / o1.weight - o2.price / o2.weight);
            }
        });
        int oldSum = 0;
        int sumPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).weight + oldSum <= sum) {
                oldSum += list.get(i).weight;
                sumPrice += list.get(i).price;
                list.get(i).status = 1;
                System.out.println(String.format("选定编号%d,重量%d,选定价格%d,总重量%d", list.get(i).code, list.get(i).weight, list.get(i).price, oldSum));
            } else {
                list.get(i).status = 2;
                System.out.println(String.format("未选定编号%d,重量%d,选定价格%d,总重量%d", list.get(i).code, list.get(i).weight, list.get(i).price, oldSum));
                break;
            }
        }
        return sumPrice;
    }


    public static void main(String[] args) {
        System.out.println(biggest(150));
    }

}
