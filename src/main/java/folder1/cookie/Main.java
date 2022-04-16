package folder1.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Main {
    public static void main(String[] args) {
        HttpServletRequest request = null;

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            cookie.getValue();
        }
    }
}
