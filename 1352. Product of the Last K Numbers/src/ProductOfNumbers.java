public class ProductOfNumbers {

    private static class Node{
        private final Node next;
        private final int num;

        public Node(Node next, int num) {
            this.next = next;
            this.num = num;
        }

        public Node getNext() {
            return next;
        }

        public int getNum() {
            return num;
        }
    }

    private Node HEAD;
    private int size;

    public ProductOfNumbers() {
        HEAD = null;
        size = 0;
    }

    public void add(int num) {
        size++;
        HEAD = new Node(HEAD, num);
    }

    public int getProduct(int k) {
        if(k > size){
            return 0;
        }
        int product = 1;
        Node slider = HEAD;
        for(int i = 0; i < k; i++){
            System.out.println("" + product + ", " + slider.getNum());
            product *= slider.getNum();
            if(product == 0){
                break;
            }
            slider = slider.getNext();
        }
        System.out.println();
        return product;
    }
}
