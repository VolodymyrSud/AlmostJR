import Keys.Key;

import java.io.File;

public class CeasarCypher {



    public void encode(String fileName, Key key) {
        key.encode(new File(fileName));

    }
    public void decode(String fileName, Key key) {
        key.decode(new File(fileName));

//        HashMap<String,Keys.Key> stringKeyHashMap = new HashMap<>();
//        stringKeyHashMap.put("$", new Keys.Key());
//        stringKeyHashMap.put("$$", new Keys.Key());
//        stringKeyHashMap.put("$$$", new Keys.Key());
//
//        return key.decode(value);
    }
}
