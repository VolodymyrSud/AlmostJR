package Keys;

import java.io.File;

public class DecodingWithShiftBy3Letters extends Key {

    @Override
    public String decode(File file) {
        moveLetterLeft(">>>", 3);
        return super.decode(file);
    }
}
