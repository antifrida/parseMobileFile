import com.antifrida.dex.DexParser;
import com.antifrida.utils.Utils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ParseDexTest {

    @Test
    public void parse(){
        File file = new File("src/main/resources/dex_test.dex");
        try {
            DexParser dexParser = new DexParser(new FileInputStream(file), Utils.readAll(file));
            dexParser.parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
