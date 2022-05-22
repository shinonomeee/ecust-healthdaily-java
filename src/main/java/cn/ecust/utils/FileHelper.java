package cn.ecust.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static cn.ecust.constants.Info.fileName;

/**
 * @Description
 * @Author chris
 * @Date 2022/5/22, 23:31
 */
public interface FileHelper {

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
