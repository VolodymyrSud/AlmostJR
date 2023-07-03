package Keys;

import java.io.File;

public class DecodingWithShiftBy5Letters extends Key {

    @Override
    public String decode(File file) {
        moveLetterLeft( ">>>>>", 5);
        return super.decode(file);
    }
}
