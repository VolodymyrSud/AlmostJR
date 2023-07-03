package Keys;

import java.io.File;

public class DecodingWithShiftBy4Letters extends Key {

    @Override
    public String decode(File file) {
        moveLetterLeft(">>>>", 4);
        return super.decode(file);
    }
}
