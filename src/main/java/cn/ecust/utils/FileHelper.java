package cn.ecust.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static cn.ecust.constants.Info.logFileName;

/**
 * @Description
 * @Author chris
 * @Date 2022/5/22, 23:31
 */
public class FileHelper {

    public static void logWriter(String logInfo) {
        Path filePath = Paths.get(logFileName);
        try {
            Files.write(filePath
                    , logInfo.getBytes(StandardCharsets.UTF_8)
                    , StandardOpenOption.APPEND);
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) {
        logWriter("TEST");
    }
}
