package EX1_Chapter2_CTDLvGT;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        head = null;
    }

    // 1. Thêm một nút với giá trị x vào đầu danh sách
    void addToHead(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    // 2. Thêm một nút với giá trị x vào cuối danh sách
    void addToTail(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // 3. Thêm một nút với giá trị x vào sau nút p
    void addAfter(Node p, int x) {
        if (p == null) return;
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }

    // 4. Duyệt danh sách
    void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 5. Xóa nút đầu và trả về giá trị của nó
    int deleteFromHead() {
        if (head == null) return -1;
        int val = head.data;
        head = head.next;
        return val;
    }

    // 6. Xóa nút cuối và trả về giá trị của nó
    int deleteFromTail() {
        if (head == null) return -1;
        if (head.next == null) {
            int val = head.data;
            head = null;
            return val;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        return val;
    }

    // 7. Xóa nút sau nút p và trả về giá trị của nó
    int deleteAfter(Node p) {
        if (p == null || p.next == null) return -1;
        int val = p.next.data;
        p.next = p.next.next;
        return val;
    }

    // 8. Xóa nút đầu tiên có giá trị bằng x
    void dele(int x) {
        if (head == null) return;
        if (head.data == x) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != x) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // 9. Tìm kiếm một nút có giá trị x
    Node search(int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) return temp;
            temp = temp.next;
        }
        return null;
    }

    // 10. Đếm số lượng nút
    int count() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 11. Xóa một nút thứ i trong danh sách, và nút có tồn tại
    void deleAt(int i) {
        if (head == null || i < 0) return;
        if (i == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int j = 0; j < i - 1 && temp.next != null; j++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // 12. Sắp xếp danh sách theo thứ tự tăng dần của giá trị
    void sort() {
        if (head == null || head.next == null) return;
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    // 13. Xóa nút p nếu nó tồn tại trong danh sách
    void dele(Node p) {
        if (head == null || p == null) return;
        if (head == p) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next != p) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // 14. Tạo và trả về một mảng chứa thông tin của tất cả các nút trong danh sách
    int[] toArray() {
        int size = count();
        int[] arr = new int[size];
        Node temp = head;
        for (int i = 0; i < size; i++) {
            arr[i] = temp.data;
            temp = temp.next;
        }
        return arr;
    }

    // 15. Hợp nhất hai danh sách liên kết đơn đã sắp xếp thành một danh sách đã sắp xếp
    static SinglyLinkedList merge(SinglyLinkedList l1, SinglyLinkedList l2) {
        SinglyLinkedList merged = new SinglyLinkedList();
        Node p1 = l1.head;
        Node p2 = l2.head;
        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                merged.addToTail(p1.data);
                p1 = p1.next;
            } else {
                merged.addToTail(p2.data);
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            merged.addToTail(p1.data);
            p1 = p1.next;
        }
        while (p2 != null) {
            merged.addToTail(p2.data);
            p2 = p2.next;
        }
        return merged;
    }

    // 16. Thêm một nút với giá trị x vào trước nút p
    void addBefore(Node p, int x) {
        if (head == null || p == null) return;
        if (head == p) {
            addToHead(x);
            return;
        }
        Node newNode = new Node(x);
        Node temp = head;
        while (temp.next != null && temp.next != p) {
            temp = temp.next;
        }
        if (temp.next != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // 17. Kết nối một danh sách liên kết đơn vào cuối của danh sách liên kết đơn khác
    void append(SinglyLinkedList other) {
        if (head == null) {
            head = other.head;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = other.head;
    }

    // 18. Tìm và trả về giá trị lớn nhất trong danh sách
    int max() {
        if (head == null) return Integer.MIN_VALUE;
        int maxVal = head.data;
        Node temp = head;
        while (temp != null) {
            if (temp.data > maxVal) {
                maxVal = temp.data;
            }
            temp = temp.next;
        }
        return maxVal;
    }

    // 19. Tìm và trả về giá trị nhỏ nhất trong danh sách
    int min() {
        if (head == null) return Integer.MAX_VALUE;
        int minVal = head.data;
        Node temp = head;
        while (temp != null) {
            if (temp.data < minVal) {
                minVal = temp.data;
            }
            temp = temp.next;
        }
        return minVal;
    }

    // 20. Trả về tổng của tất cả các giá trị trong danh sách
    int sum() {
        int sum = 0;
        Node temp = head;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    // 21. Trả về giá trị trung bình của tất cả các giá trị trong danh sách
    int avg() {
        int sum = sum();
        int count = count();
        return count == 0 ? 0 : sum / count;
    }

    // 22. Kiểm tra và trả về true nếu danh sách đã được sắp xếp, trả về false nếu danh sách chưa được sắp xếp
    boolean sorted() {
        if (head == null || head.next == null) return true;
        Node temp = head;
        while (temp.next != null) {
            if (temp.data > temp.next.data) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    // 23. Chèn một nút có giá trị x vào danh sách đã sắp xếp để danh sách mới vẫn được sắp xếp
    void insert(int x) {
        Node newNode = new Node(x);
        if (head == null || head.data >= x) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data < x) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 24. Đảo ngược một danh sách liên kết đơn chỉ trong một lần duyệt qua danh sách
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // 25. Kiểm tra xem hai danh sách liên kết đơn có cùng nội dung hay không
    boolean equals(SinglyLinkedList other) {
        Node temp1 = head;
        Node temp2 = other.head;
        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1 == null && temp2 == null;
    }

/*Hàm thực thi code từ phần 1 đến 25 t*/

    public static void main(String[] args) {
        //0. Danh sách ban đầu
        System.out.println("0. Danh sách ban đầu là rỗng.");

        SinglyLinkedList list1 = new SinglyLinkedList();

        // 1. Thêm một nút với giá trị x vào đầu danh sách
        list1.addToHead(3);
        System.out.print("1.1 Danh sách 1 sau khi thêm 3 vào đầu: ");
        list1.traverse();

        list1.addToHead(2);
        System.out.print("1.2 Danh sách 1 sau khi thêm 2 vào đầu: ");
        list1.traverse();

        // 2. Thêm một nút với giá trị x vào cuối danh sách
        list1.addToTail(4);
        System.out.print("2. Danh sách 1 sau khi thêm 4 vào cuối: ");
        list1.traverse();

        // 3. Thêm một nút với giá trị x vào sau nút p
        list1.addAfter(list1.search(3), 5);
        System.out.print("3. Danh sách 1 sau khi thêm 5 sau nút 3: ");
        list1.traverse();

        // 4. Duyệt danh sách
        System.out.print("4. Duyệt danh sách 1: ");
        list1.traverse();

        // 5. Xóa nút đầu và trả về giá trị của nó
        int deletedHead = list1.deleteFromHead();
        System.out.println("5.1 Giá trị nút đầu bị xóa: " + deletedHead);
        System.out.print("5.2 Danh sách 1 sau khi xóa đầu: ");
        list1.traverse();

        // 6. Xóa nút cuối và trả về giá trị của nó
        int deletedTail = list1.deleteFromTail();
        System.out.println("6.1 Giá trị nút cuối bị xóa: " + deletedTail);
        System.out.print("6.2 Danh sách 1 sau khi xóa cuối: ");
        list1.traverse();

        // 7. Xóa nút sau nút p và trả về giá trị của nó
        list1.addToHead(6);
        list1.addToTail(7);
        System.out.print("7.0 Danh sách 1 sau khi thêm nút 6 vào đầu và 7 vào cuối: ");
        list1.traverse();
        int deletedAfter = list1.deleteAfter(list1.search(6));
        System.out.println("7.1 Giá trị nút sau nút 6 bị xóa: " + deletedAfter);
        System.out.print("7.2 Danh sách 1 sau khi xóa nút sau 6: ");
        list1.traverse();

        // 8. Xóa nút đầu tiên có giá trị bằng x
        list1.dele(6);
        System.out.print("8. Danh sách 1 sau khi xóa nút có giá trị 6: ");
        list1.traverse();

        // 9. Tìm kiếm một nút có giá trị x
        Node foundNode = list1.search(4);
        System.out.println("9. Tìm thấy nút có giá trị 4: " + (foundNode != null));

        // 10. Đếm số lượng nút
        int count = list1.count();
        System.out.println("10. Số lượng nút trong danh sách 1: " + count);

        // 11. Xóa một nút thứ i trong danh sách, và nút có tồn tại
        list1.addToHead(8);
        list1.addToHead(9);
        System.out.print("11.1 Danh sách 1 sau khi thêm lần lượt nút 8 và 9 vào đầu: ");
        list1.traverse();
        list1.deleAt(2);
        System.out.print("11.2 Danh sách 1 sau khi xóa nút thứ 2: ");
        list1.traverse();

        // 12. Sắp xếp danh sách theo thứ tự tăng dần của giá trị
        list1.sort();
        System.out.print("12. Danh sách 1 sau khi sắp xếp: ");
        list1.traverse();

        // 13. Xóa nút p nếu nó tồn tại trong danh sách
        Node nodeToDelete = list1.search(8);
        list1.dele(nodeToDelete);
        System.out.print("13. Danh sách 1 sau khi xóa nút có giá trị 8: ");
        list1.traverse();

        // 14. Tạo và trả về một mảng chứa thông tin của tất cả các nút trong danh sách
        int[] arr = list1.toArray();
        System.out.print("14. Mảng chứa thông tin các nút: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 15. Hợp nhất hai danh sách liên kết đơn đã sắp xếp thành một danh sách đã sắp xếp
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addToHead(5);
        list2.addToHead(7);
        list2.sort();
        System.out.print("15.1 Danh sách 2 sau khi thêm lần lượt nút 5 và 7 vào đầu: ");
        list2.traverse();
        SinglyLinkedList mergedList = merge(list1, list2);
        System.out.print("15.2 Danh sách 0 sau khi hợp nhất ds1 và ds2: ");
        mergedList.traverse();

        // 16. Thêm một nút với giá trị x vào trước nút p
        mergedList.addBefore(mergedList.search(5), 1);
        System.out.print("16. Danh sách 0 sau khi thêm 1 trước nút 5: ");
        mergedList.traverse();

        // 17. Kết nối một danh sách liên kết đơn vào cuối của danh sách liên kết đơn khác
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.addToHead(10);
        System.out.print("17.1 Danh sách 3 sau khi thêm nút 10 vào đầu: ");
        list3.traverse();
        mergedList.append(list3);
        System.out.print("17.2 Danh sách 0 sau khi kết nối với danh sách 3: ");
        mergedList.traverse();

        // 18. Tìm và trả về giá trị lớn nhất trong danh sách
        int maxVal = mergedList.max();
        System.out.println("18. Giá trị lớn nhất trong danh sách 0: " + maxVal);

        // 19. Tìm và trả về giá trị nhỏ nhất trong danh sách
        int minVal = mergedList.min();
        System.out.println("19. Giá trị nhỏ nhất trong danh sách 0: " + minVal);

        // 20. Trả về tổng của tất cả các giá trị trong danh sách
        int sum = mergedList.sum();
        System.out.println("20. Tổng của tất cả các giá trị trong danh sách 0: " + sum);

        // 21. Trả về giá trị trung bình của tất cả các giá trị trong danh sách
        int avg = mergedList.avg();
        System.out.println("21. Giá trị trung bình của các giá trị trong danh sách 0: " + avg);

        // 22. Kiểm tra và trả về true nếu danh sách đã được sắp xếp, trả về false nếu danh sách chưa được sắp xếp
        boolean isSorted = mergedList.sorted();
        System.out.println("22. Danh sách 0 đã sắp xếp: " + isSorted);

        // 23. Chèn một nút có giá trị x vào danh sách đã sắp xếp để danh sách mới vẫn được sắp xếp
        mergedList.insert(6);
        System.out.print("23. Danh sách 0 sau khi chèn giá trị 6 sao cho danh sách mới vẫn được sắp xếp: ");
        mergedList.traverse();

        // 24. Đảo ngược một danh sách liên kết đơn chỉ trong một lần duyệt qua danh sách
        mergedList.reverse();
        System.out.print("24. Danh sách 0 sau khi đảo ngược: ");
        mergedList.traverse();

        // 25. Kiểm tra xem hai danh sách liên kết đơn có cùng nội dung hay không
        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.addToHead(10);
        list4.addToHead(9);
        list4.addToHead(8);
        list4.addToHead(7);
        list4.addToHead(6);
        list4.addToHead(5);
        list4.addToHead(4);
        list4.addToHead(3);
        System.out.print("25.1 Danh sách 4 sau khi thêm lần lượt các nút từ 10-3 vào đầu: ");
        list4.traverse();
        boolean isEqual = mergedList.equals(list4);
        System.out.println("25.2 Danh sách 0 và danh sách 4 có cùng nội dung: " + isEqual);
    }
}
