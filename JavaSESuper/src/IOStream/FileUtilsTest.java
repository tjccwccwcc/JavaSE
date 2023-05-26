package IOStream;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author date
 * @create 2023 上午 11:58
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        File srcFile = new File("D:\\IdeaProjects\\JavaSE\\JavaSESuper\\爱情与友情.jpg");
        File destFile = new File("D:\\IdeaProjects\\JavaSE\\JavaSESuper\\爱情与友情2.jpg");

        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
