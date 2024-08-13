
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số ISBN (10 chữ số): ");
        String isbn = scanner.nextLine();

        // Bước 2: Kiểm tra độ dài ISBN
        if (isbn.length() != 10 || !isbn.matches("\\d+")) {
            System.out.println("Số ISBN không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        // Bước 3: Sử dụng Stack để lưu trữ các chữ số và tính tổng
        Stack<Integer> stack = new Stack<>();
        for (char c : isbn.toCharArray()) {
            stack.push(Character.getNumericValue(c));
        }

        int sum = 0;
        for (int i = 1; !stack.isEmpty(); i++) {
            sum += i * stack.pop();
        }

        // Bước 4: Kiểm tra tính hợp lệ của ISBN
        if (sum % 11 == 0) {
            System.out.println("Số ISBN hợp lệ.");
        } else {
            System.out.println("Số ISBN không hợp lệ.");
        }

        scanner.close();
    }
}
