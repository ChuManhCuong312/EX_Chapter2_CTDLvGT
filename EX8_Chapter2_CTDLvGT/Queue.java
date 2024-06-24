package EX8_Chapter2_CTDLvGT;

import java.util.EmptyStackException;

class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // 1. Kiểm tra hàng đợi có rỗng không
    public boolean isEmpty() {
        return front == null;
    }

    // 2. Xóa sạch hàng đợi
    public void clear() {
        front = null;
        rear = null;
    }

    // 3. Thêm một phần tử vào cuối hàng đợi
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // 4. Loại bỏ và trả về phần tử từ đầu hàng đợi
    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int val = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        return val;
    }

    // 5. Trả về giá trị của phần tử đầu hàng đợi
    public int first() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return front.data;
    }

    // 6. Hiển thị tất cả các giá trị trong hàng đợi từ phía trước đến phía sau
    public void traverse() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 7. Chuyển đổi số thực nhỏ hơn 1 từ hệ thập phân sang hệ nhị phân và hiển thị
    public void decimalToBinary(double number) {
        if (number >= 1 || number <= 0) {
            System.out.println("Số không hợp lệ. Vui lòng nhập số thực nhỏ hơn 1.");
            return;
        }

        StringBuilder binary = new StringBuilder();
        binary.append("0."); // Hệ nhị phân của số thập phân nhỏ hơn 1 bắt đầu bằng "0."

        while (number > 0) {
            if (binary.length() >= 32) {
                System.out.println("Không thể biểu diễn chính xác trong 32 bit.");
                return;
            }

            double r = number * 2;
            if (r >= 1) {
                binary.append(1);
                number = r - 1;
            } else {
                binary.append(0);
                number = r;
            }
        }

        System.out.println("Hệ nhị phân của số " + number + " là: " + binary.toString());
    }
}
