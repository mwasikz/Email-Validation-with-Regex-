import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dateValidation {

    public static void main(String[] args) {
        System.out.println("Enter number of string: ");
        Scanner scan = new Scanner(System.in);
        int num_of_strings = scan.nextInt();

        String[] output = new String[num_of_strings];
        for (int i = 0; i < num_of_strings; i++) {
            System.out.println("Enter date in 'dd/mm/yyyy' format: ");
            String input = scan.next();


            if (isValidDate(input)) {
                output[i] = input + " is a Valid Date";
            } else {
                output[i] = input + " is an Invalid Date";
            }
        }
        scan.close();

        for (int i = 0; i < num_of_strings; i++) {
            System.out.println(output[i]);
        }
    }

    public static boolean isValidDate(String date) {
        String dateRegex = "(^(((0[1-9]|1[0-9]|2[0-8])[/](0[1-9]|1[012]))|((29|30|31)[/](0[13578]|1[02]))|((29|30)[/](0[4,6,9]|11)))[/](19|[2-9][0-9])\\d\\d$)|(^29[/]02[/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
        Pattern datePat = Pattern.compile(dateRegex);
        Matcher matcher = datePat.matcher(date);
        return matcher.find();

    }
}

