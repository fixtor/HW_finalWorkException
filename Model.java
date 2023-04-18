import java.util.LinkedList;
import java.util.List;

public class Model {
    private String userData;
    private User user;
    private List<String> listOfUsersLastName;

    public Model(String userData) {
        this.userData = userData;
        this.user = new User();
        this.listOfUsersLastName = new LinkedList<>();
    }

    public int parseStringCheck() {
        String[] parseStr = userData.split(" ");
        if (parseStr.length < 6 || parseStr.length > 6) {
            return -1;
        }
        return 0;
    }

    public String[] parseString() {
        String[] parseStr = userData.split(" ");
        return parseStr;
    }

    public User checkUserData(String[] parseStr) throws RuntimeException {
        String[] userParse = parseStr;
        for (int i = 0; i < userParse.length; i++) {
            if ((userParse[i].matches("^[a-zA-Z]*$") && userParse[i + 1].matches("^[a-zA-Z]*$")
                    && userParse[i + 2].matches("^[a-zA-Z]*$"))
                    && (userParse[i].length() > 1 && userParse[i + 1].length() > 1 && userParse[i + 2].length() > 1)) {
                if (Character.isUpperCase(userParse[i].charAt(0)) && Character.isUpperCase(userParse[i + 1].charAt(0))
                        && Character.isUpperCase(userParse[i + 2].charAt(0))) {
                    user.setLastName(userParse[i]);
                    user.setFirstName(userParse[i + 1]);
                    user.setMiddleName(userParse[i + 2]);
                    i = i + 2;
                } else {
                    throw new RuntimeException("Неверно введены ФИО!");
                }
            } else if (userParse[i].matches("^[fm]*$")) {
                if (userParse[i].length() == 1) {
                    user.setGender(userParse[i]);
                } else {
                    throw new RuntimeException("Неверно введен пол!");
                }
            } else if (userParse[i].matches("[-+]?\\d+")) {
                if (userParse[i].length() > 1 && userParse[i].length() < 12) {
                    user.setPhoneNumber(userParse[i]);
                } else {
                    throw new RuntimeException("Неверно введен номер телефона!");
                }
            } else if (userParse[i].matches("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)")) {
                if (userParse[i].length() > 5) {
                    user.setDateBirth(userParse[i]);
                } else {
                    throw new RuntimeException("Неверный формат даты рождения!");
                }
            }
        }
        listOfUsersLastName.add(user.getLastName());
        return user;
    }

    public void fileCreator(User user) throws UserIsNullException {
        try {
            String fileName = user.getLastName();
            String fileData = user.toString();
            OurFileWriter ourFW = new OurFileWriter(fileName, fileData);
            for (String lastName : listOfUsersLastName) {
                if (user.getLastName().equals(lastName)) {
                    try {
                        ourFW.addToFile();
                    } catch (FileNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    try {
                        ourFW.writeFile();
                    } catch (FileNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new UserIsNullException(
                    "Catched Exception: " + e.getClass().getSimpleName() + "\nUser не может быть null!", e);
        }

    }

}