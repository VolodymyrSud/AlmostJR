package Keys;

import java.io.File;

public class EncodingWithShiftBy4Letters extends Key {

    @Override
    public String encode(File file) {
        moveLetterRight(">>>>", 4);
        return super.encode(file);
    }
}
