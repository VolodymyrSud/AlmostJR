package Keys;

import java.io.File;

public class EncodingWithShiftBy3Letters extends Key {

    @Override
    public String encode(File file) {
        moveLetterRight(">>>", 3);
        return super.encode(file);
    }
}
