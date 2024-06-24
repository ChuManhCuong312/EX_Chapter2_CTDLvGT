package EX3_Chapter2_CTDLvGT;

import java.util.Stack;

    public class Main {
        public static void main(String[] args) {
            // Khởi tạo ngăn xếp
            Stack<Integer> s = new Stack<>();

            // Khởi tạo các biến theo bài
            int x = 3;
            int y = 5;
            int z = 2;

            // Làm rỗng ngăn xếp
            s.clear();

            // Thực hiện các thao tác với ngăn xếp
            s.push(x); // s.push(3)
            s.push(4); // Ngăn xếp: [3, 4]
            s.pop();   // Loại bỏ 4; Ngăn xếp: [3]

            s.push(y); // s.push(5); Ngăn xếp: [3, 5]
            s.push(3); // Ngăn xếp: [3, 5, 3]
            s.push(z); // s.push(2); Ngăn xếp: [3, 5, 3, 2]
            s.pop();   // Loại bỏ 2; Ngăn xếp: [3, 5, 3]

            s.push(2); // Ngăn xếp: [3, 5, 3, 2]
            s.push(x); // s.push(3); Ngăn xếp: [3, 5, 3, 2, 3]

            // In ra các phần tử từ ngăn xếp cho đến khi ngăn xếp rỗng
            while (!s.isEmpty()) {
                System.out.println(s.pop() + " ");
            }
        }
    }

/*Với đoạn code sau:
x = 3;y = 5;z = 2;
s.makeEmpty( );
s.push(x);s.push(4);s.pop();
s.push(y);s.push(3); s.push(z);
s.pop();s.push(2);s.push(x);
while(! s.isEmpty( )) System.out.println(s.pop() + " ");
Khi chạy sẽ đưa ra kết quả là một stack [3, 5, 3, 2, 3]*/