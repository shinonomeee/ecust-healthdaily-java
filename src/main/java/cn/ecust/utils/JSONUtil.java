package cn.ecust.utils;

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
            reader = new JsonReader(new FileReader(Info.userInfoFileName));
        } catch (FileNotFoundException ignored) {
        }
        Type type = new TypeToken<List<User>>(){}.getType();
        return gson.fromJson(reader, type);
    }

    public static void main(String[] args) {
        System.out.println(getUsers());
    }
}
