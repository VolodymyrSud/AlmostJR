package Keys;

import java.io.File;

public class EncodingWithShiftBy5Letters extends Key {

    @Override
    public String encode(File file) {
        moveLetterRight(">>>>>", 5);
        return super.encode(file);
    }
}
