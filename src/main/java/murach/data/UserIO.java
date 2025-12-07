package murach.data;

import java.io.*;
import murach.business.User;

public class UserIO {

    /**
     * Ghi một đối tượng User vào cuối tệp.
     * Dữ liệu được ghi theo định dạng: firstName|lastName|email
     * @param user Đối tượng User cần ghi.
     * @param filepath Đường dẫn vật lý đến tệp (ví dụ: /WEB-INF/EmailList.txt).
     */
    public static void add(User user, String filepath) {
        try {
            // Sử dụng FileWriter với tham số true để thêm (append) vào cuối tệp
            File file = new File(filepath);
            PrintWriter out = new PrintWriter(
                    new FileWriter(file, true));

            // Ghi dữ liệu User vào tệp theo định dạng |
            out.println(user.getFirstName() + "|"
                    + user.getLastName() + "|"
                    + user.getEmail());

            out.close();
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi tệp: " + e.getMessage());
        }
    }

    /**
     * Tìm kiếm và trả về đối tượng User dựa trên địa chỉ email.
     * @param email Địa chỉ email của người dùng cần tìm.
     * @param filepath Đường dẫn vật lý đến tệp.
     * @return Đối tượng User nếu tìm thấy, ngược lại trả về null.
     */
    public static User getUser(String email, String filepath) {
        try {
            File file = new File(filepath);

            // Sử dụng FileReader và BufferedReader để đọc tệp hiệu quả
            BufferedReader in = new BufferedReader(
                    new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                String[] columns = line.split("\\|"); // Tách dòng theo ký tự |

                // Kiểm tra xem có đủ 3 cột dữ liệu không
                if (columns.length >= 3) {
                    String firstName = columns[0];
                    String lastName = columns[1];
                    String emailAddress = columns[2];

                    // So sánh email từ tệp với email đang tìm kiếm
                    if (emailAddress.equalsIgnoreCase(email)) {
                        in.close();
                        // Trả về đối tượng User đã tìm thấy
                        return new User(firstName, lastName, emailAddress);
                    }
                }
                line = in.readLine(); // Đọc dòng tiếp theo
            }
            in.close();

            // Nếu không tìm thấy email sau khi duyệt hết tệp
            return null;

        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp: " + e.getMessage());
            return null;
        }
    }
}