public class Main {
    public static void main(String[] args) {
        //String[] commands = new String[]{"CountIntervals","count","add","add","add","add","add","count","add","add"};
        //int[][] data = new int[][]{{},{},{8,43},{13,16},{26,33},{28,36},{29,37},{},{34,46},{10,23}};

        String[] commands = new String[]{"CountIntervals","count","add","add","add","add","add","count","add","add"};
        int[][] data = new int[][]{{},{},{1,1},{2,2},{3,3},{4,4},{5,5},{},{6,6},{7,7}};

        CountIntervals countIntervals = new CountIntervals();
        for(int i = 0; i < commands.length; i++){
            switch (commands[i]){
                case "CountIntervals":
                    countIntervals = new CountIntervals();
                    break;
                case "count":
                    System.out.println(countIntervals.count());
                    break;
                case "add":
                    countIntervals.add(data[i][0], data[i][1]);
                    break;
            }
        }
    }
}