public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setFirstName("Niyaz");
        user.setLastName("Amanzholov");
        user.setMidName("Bulatovich");
        user.setEmail("@gmail.com");

        System.out.println(getFio(user));
    }

//    public static String getFio(User user) {
//        String fio = "";
//        if (user.getLastName() != null) {
//            fio += user.getLastName();
//        }
//        if (user.getFirstName() != null) {
//            fio += " " + user.getFirstName();
//        }
//        if (user.getMidName() != null) {
//            fio += " " + user.getMidName();
//        }
//        String result = fio.isBlank() ? user.getEmail() : fio;
//        return result == null ? "" : result;
//    }

    public static String getFio(User user) {
        StringBuilder fio = new StringBuilder();

        if (user.getLastName() != null) {
            fio.append(user.getLastName());
        }
        if (user.getFirstName() != null) {
            fio.append(" ").append(user.getFirstName());
        }
        if (user.getMidName() != null) {
            fio.append(" ").append(user.getMidName());
        }

        String data = fio.toString();
        String result = data.isBlank() ? user.getEmail() : data;
        return result == null ? "" : result;
    }
}


class User {
    private String LastName;
    private String FirstName;
    private String MidName;
    private String Email;

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMidName() {
        return MidName;
    }

    public String getEmail() {
        return Email;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setMidName(String midName) {
        MidName = midName;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
