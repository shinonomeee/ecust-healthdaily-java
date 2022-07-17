package cn.ecust.utils;

import cn.ecust.constants.FilePaths;
import cn.ecust.constants.Info;
import cn.ecust.entity.User;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author chris
 * @Date 2022/7/18, 00:05
 */
public class JSONUtil {
    public static List<User> getUsers() {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(FilePaths.userInfosFilePath));
        } catch (FileNotFoundException ignored) {
        }
        return gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
    }

    public static void main(String[] args) {
        System.out.println(getUsers());
    }
}
