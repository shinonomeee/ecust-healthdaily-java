package cn.ecust.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description
 * @Author chris
 * @Date 2022/5/22, 23:31
 */
public interface FileHelper {

    String fileName = "fillinHistory.txt";

    static void logWriter(String logInfo) {
        Path filePath = Paths.get(fileName);
        try {
            Files.write(filePath
                    , logInfo.getBytes(StandardCharsets.UTF_8)
                    , StandardOpenOption.APPEND);
        } catch (IOException ignored) {
        }
    }
}
