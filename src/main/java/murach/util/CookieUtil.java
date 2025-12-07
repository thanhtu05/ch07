package murach.util;

import javax.servlet.http.Cookie;

public class CookieUtil {

    /**
     * Phương thức tĩnh để lấy giá trị của một Cookie cụ thể từ mảng Cookie.
     * * @param cookies Mảng các đối tượng Cookie được lấy từ HttpServletRequest.
     * @param cookieName Tên của Cookie cần tìm giá trị (ví dụ: "emailAddress").
     * @return Giá trị (String) của Cookie nếu tìm thấy, ngược lại trả về String rỗng ("").
     */
    public static String getCookieValue(Cookie[] cookies, String cookieName) {

        // Kiểm tra xem mảng cookies có tồn tại hay không.
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Kiểm tra tên của từng cookie
                if (cookie.getName().equals(cookieName)) {
                    // Nếu tên khớp, trả về giá trị của cookie đó
                    return cookie.getValue();
                }
            }
        }
        // Nếu mảng cookies là null hoặc không tìm thấy cookie với tên đã cho
        return "";
    }
}