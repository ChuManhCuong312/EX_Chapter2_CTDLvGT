package EX4_Chapter2_CTDLvGT;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo ngăn xếp
        Stack<Integer> s = new Stack<>();

        // Khởi tạo các biến
        int x = 3;
        int y = 1;

        // Làm rỗng ngăn xếp
        s.clear();

        // Thực hiện các thao tác với ngăn xếp
        s.push(5); // Ngăn xếp: [5]
        s.push(7); // Ngăn xếp: [5, 7]
        s.pop();   // Loại bỏ 7; Ngăn xếp: [5]

        x += y;    // x = 3 + 1 = 4

        s.pop();   // Loại bỏ 5; Ngăn xếp: []

        s.push(x); // s.push(4); Ngăn xếp: [4]
        s.push(y); // s.push(1); Ngăn xếp: [4, 1]
        s.push(2); // Ngăn xếp: [4, 1, 2]
        s.pop();   // Loại bỏ 2; Ngăn xếp: [4, 1]
        s.pop();   // Loại bỏ 1; Ngăn xếp: [4]

        // In ra các phần tử từ ngăn xếp cho đến khi ngăn xếp rỗng
        while (!s.isEmpty()) {
            y = s.pop();
            System.out.println(y);
        }

        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}

/*Với đoạn code sau:
x = 3;y = 5;z = 2;
x = 3; y = 1;
s.makeEmpty();
s.push(5);s.push(7);s.pop();
x += y;
s.pop();
s.push(x);s.push(y); s.push(2);s.pop();s.pop();
while (! s.isEmpty( )){
 y = s.pop();
 System.out.println(y);
}
System.out.println("x = " + x);
System.out.println("y = " + y);
Khi chạy sẽ in ra kết quả:
4
x = 4
y = 4 */

