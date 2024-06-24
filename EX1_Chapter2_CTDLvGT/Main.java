package EX1_Chapter2_CTDLvGT;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    SinglyLinkedList() {
        head = null;
    }

    // 1. Thêm vào đầu danh sách
    void addToHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Thêm vào cuối danh sách
    void addToTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // 3. Thêm sau một nút có giá trị cho trước
    void addAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Nút trước không tồn tại");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // 4. Duyệt danh sách
    void traverse() {
        if (head == null) {
            System.out.println("Danh sách rỗng");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 5. Xóa khỏi đầu danh sách
    int deleteFromHead() {
        if (head == null) {
            System.out.println("Danh sách rỗng");
            return -1;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    // 6. Xóa khỏi cuối danh sách
    int deleteFromTail() {
        if (head == null) {
            System.out.println("Danh sách rỗng");
            return -1;
        }
        if (head.next == null) {
            int value = head.data;
            head = null;
            return value;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int value = temp.next.data;
        temp.next = null;
        return value;
    }

    // 7. Xóa sau một nút có giá trị cho trước
    int deleteAfter(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("Nút trước không tồn tại hoặc không có nút tiếp theo");
            return -1;
        }
        int value = prevNode.next.data;
        prevNode.next = prevNode.next.next;
        return value;
    }

    // 8. Xóa nút có giá trị cho trước
    void dele(int data) {
        if (head == null) {
            System.out.println("Danh sách rỗng");
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Không tìm thấy nút");
            return;
        }
        temp.next = temp.next.next;
    }

    // 9. Tìm nút có giá trị cho trước
    Node search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // 10. Đếm số lượng nút trong danh sách
    int count() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 11. Xóa nút ở vị trí cho trước
    void deleAt(int position) {
        if (head == null) {
            System.out.println("Danh sách rỗng");
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Vị trí không hợp lệ");
            return;
        }
        temp.next = temp.next.next;
    }

    // 12. Sắp xếp danh sách
    void sort() {
        if (head == null || head.next == null) return;
        Node current = head;
        while (current != null) {
            Node index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // 13. Xóa nút cụ thể
    void dele(Node node) {
        if (head == null || node == null) return;
        if (head == node) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next != node) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = node.next;
    }

    // 14. Chuyển danh sách thành mảng
    int[] toArray() {
        int[] array = new int[count()];
        Node temp = head;
        int index = 0;
        while (temp != null) {
            array[index++] = temp.data;
            temp = temp.next;
        }
        return array;
    }

    // 15. Hợp nhất hai danh sách đã sắp xếp
    static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                mergedList.addToTail(temp1.data);
                temp1 = temp1.next;
            } else {
                mergedList.addToTail(temp2.data);
                temp2 = temp2.next;
            }
        }
        while (temp1 != null) {
            mergedList.addToTail(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            mergedList.addToTail(temp2.data);
            temp2 = temp2.next;
        }
        return mergedList;
    }

    // 16. Thêm trước một nút có giá trị cho trước
    void addBefore(Node nextNode, int data) {
        if (head == null || nextNode == null) {
            System.out.println("Danh sách rỗng hoặc nút tiếp theo không tồn tại");
            return;
        }
        if (head == nextNode) {
            addToHead(data);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next != nextNode) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Không tìm thấy nút");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = nextNode;
        temp.next = newNode;
    }

    // 17. Nối thêm danh sách khác vào cuối
    void append(SinglyLinkedList otherList) {
        if (head == null) {
            head = otherList.head;
            return;
        }
        if (otherList.head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = otherList.head;
    }

    // 18. Tìm giá trị lớn nhất
    int max() {
        if (head == null) throw new RuntimeException("Danh sách rỗng");
        int max = head.data;
        Node temp = head;
        while (temp != null) {
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }
        return max;
    }

    // 19. Tìm giá trị nhỏ nhất
    int min() {
        if (head == null) throw new RuntimeException("Danh sách rỗng");
        int min = head.data;
        Node temp = head;
        while (temp != null) {
            if (temp.data < min) min = temp.data;
            temp = temp.next;
        }
        return min;
    }

    // 20. Tính tổng các giá trị
    int sum() {
        int sum = 0;
        Node temp = head;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    // 21. Tính trung bình các giá trị
    int avg() {
        return (head == null) ? 0 : sum() / count();
    }

    // 22. Kiểm tra danh sách có trống không
    boolean isEmpty() {
        return head == null;
    }

    // 23. Làm rỗng danh sách
    void clear() {
        head = null;
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, position;
        Node node;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm vào đầu danh sách");
            System.out.println("2. Thêm vào cuối danh sách");
            System.out.println("3. Thêm sau một nút có giá trị cho trước");
            System.out.println("4. Duyệt danh sách");
            System.out.println("5. Xóa khỏi đầu danh sách");
            System.out.println("6. Xóa khỏi cuối danh sách");
            System.out.println("7. Xóa sau một nút có giá trị cho trước");
            System.out.println("8. Xóa nút có giá trị cho trước");
            System.out.println("9. Tìm nút có giá trị cho trước");
            System.out.println("10. Đếm số lượng nút trong danh sách");
            System.out.println("11. Xóa nút ở vị trí cho trước");
            System.out.println("12. Sắp xếp danh sách");
            System.out.println("13. Xóa nút cụ thể");
            System.out.println("14. Chuyển danh sách thành mảng");
            System.out.println("15. Hợp nhất hai danh sách đã sắp xếp");
            System.out.println("16. Thêm trước một nút có giá trị cho trước");
            System.out.println("17. Nối thêm danh sách khác vào cuối");
            System.out.println("18. Tìm giá trị lớn nhất");
            System.out.println("19. Tìm giá trị nhỏ nhất");
            System.out.println("20. Tính tổng các giá trị");
            System.out.println("21. Tính trung bình các giá trị");
            System.out.println("22. Kiểm tra danh sách có trống không");
            System.out.println("23. Làm rỗng danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập giá trị: ");
                    data = scanner.nextInt();
                    list.addToHead(data);
                    break;
                case 2:
                    System.out.print("Nhập giá trị: ");
                    data = scanner.nextInt();
                    list.addToTail(data);
                    break;
                case 3:
                    System.out.print("Nhập giá trị của nút trước: ");
                    data = scanner.nextInt();
                    node = list.search(data);
                    if (node != null) {
                        System.out.print("Nhập giá trị để thêm: ");
                        data = scanner.nextInt();
                        list.addAfter(node, data);
                    } else {
                        System.out.println("Không tìm thấy nút");
                    }
                    break;
                case 4:
                    list.traverse();
                    break;
                case 5:
                    System.out.println("Giá trị đã xóa: " + list.deleteFromHead());
                    break;
                case 6:
                    System.out.println("Giá trị đã xóa: " + list.deleteFromTail());
                    break;
                case 7:
                    System.out.print("Nhập giá trị của nút trước: ");
                    data = scanner.nextInt();
                    node = list.search(data);
                    if (node != null) {
                        System.out.println("Giá trị đã xóa: " + list.deleteAfter(node));
                    } else {
                        System.out.println("Không tìm thấy nút");
                    }
                    break;
                case 8:
                    System.out.print("Nhập giá trị: ");
                    data = scanner.nextInt();
                    list.dele(data);
                    break;
                case 9:
                    System.out.print("Nhập giá trị: ");
                    data = scanner.nextInt();
                    node = list.search(data);
                    System.out.println(node != null ? "Tìm thấy nút" : "Không tìm thấy nút");
                    break;
                case 10:
                    System.out.println("Số lượng nút: " + list.count());
                    break;
                case 11:
                    System.out.print("Nhập vị trí: ");
                    position = scanner.nextInt();
                    list.deleAt(position);
                    break;
                case 12:
                    list.sort();
                    System.out.println("Danh sách đã được sắp xếp");
                    break;
                case 13:
                    System.out.print("Nhập giá trị của nút để xóa: ");
                    data = scanner.nextInt();
                    node = list.search(data);
                    if (node != null) {
                        list.dele(node);
                    } else {
                        System.out.println("Không tìm thấy nút");
                    }
                    break;
                case 14:
                    int[] array = list.toArray();
                    System.out.print("Mảng: ");
                    for (int value : array) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;
                case 15:
                    SinglyLinkedList list2 = new SinglyLinkedList();
                    System.out.println("Nhập danh sách thứ hai (kết thúc bằng -1): ");
                    while (true) {
                        data = scanner.nextInt();
                        if (data == -1) break;
                        list2.addToTail(data);
                    }
                    list2.sort();
                    list = SinglyLinkedList.merge(list, list2);
                    System.out.println("Hai danh sách đã được hợp nhất");
                    break;
                case 16:
                    System.out.print("Nhập giá trị của nút tiếp theo: ");
                    data = scanner.nextInt();
                    node = list.search(data);
                    if (node != null) {
                        System.out.print("Nhập giá trị để thêm: ");
                        data = scanner.nextInt();
                        list.addBefore(node, data);
                    } else {
                        System.out.println("Không tìm thấy nút");
                    }
                    break;
                case 17:
                    SinglyLinkedList otherList = new SinglyLinkedList();
                    System.out.println("Nhập danh sách cần nối (kết thúc bằng -1): ");
                    while (true) {
                        data = scanner.nextInt();
                        if (data == -1) break;
                        otherList.addToTail(data);
                    }
                    list.append(otherList);
                    System.out.println("Danh sách đã được nối thêm");
                    break;
                case 18:
                    try {
                        System.out.println("Giá trị lớn nhất: " + list.max());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 19:
                    try {
                        System.out.println("Giá trị nhỏ nhất: " + list.min());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 20:
                    System.out.println("Tổng các giá trị: " + list.sum());
                    break;
                case 21:
                    System.out.println("Giá trị trung bình: " + list.avg());
                    break;
                case 22:
                    System.out.println(list.isEmpty() ? "Danh sách trống" : "Danh sách không trống");
                    break;
                case 23:
                    list.clear();
                    System.out.println("Danh sách đã được làm rỗng");
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
