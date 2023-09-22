package ms.cliutils.in;

import java.util.Scanner;
import java.util.function.Predicate;
import ms.cliutils.in.validator.Validator;

/**
 *
 * @author MS
 */
interface PromptValidate {
     @SuppressWarnings("unchecked")
    default String get(Predicate kondisi, String pesanInput, String pesanError) {
        String inputStr = "";

        do {
            System.out.print(pesanInput);
            inputStr = new Scanner(System.in).nextLine();

            if (kondisi.test(inputStr)) {
                break;
            } else {
                System.err.println("\n" + pesanError);
            }
        } while (true);

        return inputStr;
    }

    default String get(Validator validator, String pesanInput) {
        do {
            System.out.print(pesanInput);
            String input = new Scanner(System.in).nextLine();

            try {
                validator.validasi(input);

                return input;
            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        } while (true);
    }

}
