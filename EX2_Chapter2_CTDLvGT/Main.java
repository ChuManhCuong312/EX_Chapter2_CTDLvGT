package EX2_Chapter2_CTDLvGT;

import java.util.EmptyStackException;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    public Stack() {
        this.top = null;
    }

    // 1. Trả về true nếu ngăn xếp rỗng và false nếu ngược lại.
    boolean isEmpty() {
        return top == null;
    }

    // 2. Xóa sạch ngăn xếp.
    void clear() {
        top = null;
    }

    // 3. Chèn một nút có giá trị x vào đỉnh của ngăn xếp.
    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    // 4. Loại bỏ phần tử ở đỉnh ngăn xếp và trả về giá trị của nó.
    int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    // 5. Trả về giá trị của một nút ở đỉnh của ngăn xếp.
    int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // 6. Hiển thị tất cả các giá trị trong ngăn xếp từ đỉnh đến đáy.
    void traverse() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 7. Sử dụng ngăn xếp để chuyển đổi một số nguyên từ hệ thập phân sang hệ nhị phân.
    void decimalToBinary(int number) {
        Stack stack = new Stack();
        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    // 8. Sử dụng ngăn xếp để đảo ngược một xâu ký tự.
    String reverseString(String input) {
        Stack stack = new Stack();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append((char) stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        int choice, value;
        String inputString;

        do {
            System.out.println("\nChọn một hành động:");
            System.out.println("1. Kiểm tra ngăn xếp rỗng");
            System.out.println("2. Xóa sạch ngăn xếp");
            System.out.println("3. Thêm phần tử vào ngăn xếp");
            System.out.println("4. Loại bỏ phần tử đỉnh ngăn xếp");
            System.out.println("5. Lấy giá trị đỉnh ngăn xếp");
            System.out.println("6. Hiển thị ngăn xếp");
            System.out.println("7. Chuyển đổi số từ hệ thập phân sang hệ nhị phân");
            System.out.println("8. Đảo ngược một xâu ký tự");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ngăn xếp rỗng: " + stack.isEmpty());
                    break;

                case 2:
                    stack.clear();
                    System.out.println("Ngăn xếp đã được xóa sạch.");
                    break;

                case 3:
                    System.out.print("Nhập giá trị cần thêm: ");
                    value = scanner.nextInt();
                    stack.push(value);
                    System.out.println(value + " đã được thêm vào ngăn xếp.");
                    break;

                case 4:
                    try {
                        value = stack.pop();
                        System.out.println(value + " đã được loại bỏ từ đỉnh ngăn xếp.");
                    } catch (EmptyStackException e) {
                        System.out.println("Ngăn xếp rỗng, không thể loại bỏ phần tử.");
                    }
                    break;

                case 5:
                    try {
                        value = stack.top();
                        System.out.println("Giá trị đỉnh ngăn xếp: " + value);
                    } catch (EmptyStackException e) {
                        System.out.println("Ngăn xếp rỗng.");
                    }
                    break;

                case 6:
                    System.out.println("Các phần tử trong ngăn xếp:");
                    stack.traverse();
                    break;

                case 7:
                    System.out.print("Nhập số nguyên để chuyển đổi: ");
                    value = scanner.nextInt();
                    System.out.print("Số " + value + " trong hệ nhị phân: ");
                    stack.decimalToBinary(value);
                    break;

                case 8:
                    System.out.print("Nhập xâu ký tự cần đảo ngược: ");
                    inputString = scanner.next();
                    String reversedString = stack.reverseString(inputString);
                    System.out.println("Xâu ký tự sau khi đảo ngược: " + reversedString);
                    break;

                case 9:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 9);

        scanner.close();
    }
}
