package EX8_Chapter2_CTDLvGT;

import java.util.Scanner;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        int choice, value;
        double decimalValue;

        do {
            System.out.println("\nChọn một hành động:");
            System.out.println("1. Kiểm tra hàng đợi rỗng");
            System.out.println("2. Xóa sạch hàng đợi");
            System.out.println("3. Thêm phần tử vào cuối hàng đợi");
            System.out.println("4. Loại bỏ phần tử đầu hàng đợi");
            System.out.println("5. Lấy giá trị phần tử đầu hàng đợi");
            System.out.println("6. Hiển thị hàng đợi");
            System.out.println("7. Chuyển đổi số từ hệ thập phân sang hệ nhị phân");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hàng đợi rỗng: " + queue.isEmpty());
                    break;

                case 2:
                    queue.clear();
                    System.out.println("Hàng đợi đã được xóa sạch.");
                    break;

                case 3:
                    System.out.print("Nhập giá trị cần thêm vào hàng đợi: ");
                    value = scanner.nextInt();
                    queue.enqueue(value);
                    System.out.println(value + " đã được thêm vào hàng đợi.");
                    break;

                case 4:
                    try {
                        value = queue.dequeue();
                        System.out.println("Phần tử " + value + " đã được loại bỏ từ hàng đợi.");
                    } catch (EmptyStackException e) {
                        System.out.println("Hàng đợi rỗng, không thể loại bỏ phần tử.");
                    }
                    break;

                case 5:
                    try {
                        value = queue.first();
                        System.out.println("Giá trị của phần tử đầu hàng đợi: " + value);
                    } catch (EmptyStackException e) {
                        System.out.println("Hàng đợi rỗng.");
                    }
                    break;

                case 6:
                    System.out.println("Các phần tử trong hàng đợi:");
                    queue.traverse();
                    break;

                case 7:
                    System.out.print("Nhập số thực nhỏ hơn 1 để chuyển đổi sang hệ nhị phân: ");
                    decimalValue = scanner.nextDouble();
                    queue.decimalToBinary(decimalValue);
                    break;

                case 8:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 8);

        scanner.close();
    }
}
