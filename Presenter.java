import java.util.Scanner;

public class Presenter {
    private Model model;
    private View view;

    public void run() {
        try (Scanner userChoice = new Scanner(System.in)) {
            view = new View();
            view.print();
            String userData = userChoice.nextLine();
            model = new Model(userData);
            if (model.parseStringCheck() != -1) {
                String[] parseStr = model.parseString();
                User user = model.checkUserData(parseStr);
                try {
                    model.fileCreator(user);

                } catch (UserIsNullException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println(
                        "Неверное количество введенных данных!\nПовторите ввод данных в соответствии с требованиями!");
                run();
            }
        }
    }

}