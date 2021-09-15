package io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * IO操作
 *
 * @author HuHong
 * @date 2021/9/15
 */
public class IOTest {
    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            int t = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String s = FileUtils.readFileToString(new File("/Users/bytedance/temp/test.txt"));
                        FileUtils.writeStringToFile(new File("/Users/bytedance/temp/output.txt"), t + " time\n" + s + "\n\n\n\n", true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
