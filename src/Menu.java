import Keys.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    private static final int EXIT_NUMBER = 0;
    private static final int ENCODE_FILE = 1;
    private static final int DECODE_FILE = 2;
    private static final int MOVE_RIGHT_ON_3 = 3;
    private static final int MOVE_RIGHT_ON_4 = 4;
    private static final int MOVE_RIGHT_ON_5 = 5;
    private static final int MOVE_LEFT_ON_3 = 6;
    private static final int MOVE_LEFT_ON_4 = 7;
    private static final int MOVE_LEFT_ON_5 = 8;
    private static final int BRUTE_FORCE = 9;
    private static final String MENU_INFO =
            """
                    Select an action:
                    1 - Encode file
                    2 - Decode file
                    0 - Exit
                    """;
    private static final String OPTIONS_FOR_ENCODE =
            """
                    Select an action:
                    3 - Move letter on 3 points right
                    4 - Move letter on 4 points right
                    5 - Move letter on 5 points right
                    """;
    private static final String OPTIONS_FOR_DECODE =
            """
                    Select an action:
                    6 - Move letter on 3 points left
                    7 - Move letter on 4 points left
                    8 - Move letter on 5 points left
                    9 - Decode with brute force
                    """;
    private static boolean isRunning = true;
    final CeasarCypher ceasarCypher = new CeasarCypher();
    final Scanner scanner = new Scanner(System.in);

    public void run() {

        while (isRunning) {
            System.out.println(MENU_INFO);
            int menuItem = scanner.nextInt();

            switch (menuItem) {
                case ENCODE_FILE -> itemToEncodeFile();
                case DECODE_FILE -> itemToDecodeFile();
                case EXIT_NUMBER -> itemToExit();
            }
        }
    }

    private void itemToEncodeFile() {
        System.out.println(OPTIONS_FOR_ENCODE);
        var encodingScanner = new Scanner(System.in);
        int input = encodingScanner.nextInt();

        Key key = switch (input) {
            case MOVE_RIGHT_ON_3 -> new EncodingWithShiftBy3Letters();
            case MOVE_RIGHT_ON_4 -> new EncodingWithShiftBy4Letters();
            case MOVE_RIGHT_ON_5 -> new EncodingWithShiftBy5Letters();
            default -> null;
        };

        ceasarCypher.encode(validateFilePath(), key);
    }
    private void itemToDecodeFile() {
        System.out.println(OPTIONS_FOR_DECODE);
        var decodingScanner = new Scanner(System.in);
        int input = decodingScanner.nextInt();

        Key key = switch (input) {
            case MOVE_LEFT_ON_3 -> new DecodingWithShiftBy3Letters();
            case MOVE_LEFT_ON_4 -> new DecodingWithShiftBy4Letters();
            case MOVE_LEFT_ON_5 -> new DecodingWithShiftBy5Letters();
            case BRUTE_FORCE -> new BruteForce();
            default -> null;
        };
        ceasarCypher.decode(validateFilePath(), key);
    }

    // Повідомлення при виборі Exit
    private void itemToExit() {
        isRunning = false;
        System.out.println("Bye bye!");
    }

    // Повертає посилання на файл Стрінгою
    private String validateFilePath() {
        System.out.println("Provide path to file: ");
        Scanner scannerForFileName = new Scanner(System.in);
        String filePath = scannerForFileName.nextLine();
        if (!Files.exists(Path.of(filePath))) {
            throw new FilePathNotValid("Invalid file Path!");
        }
        return filePath;
    }
}
