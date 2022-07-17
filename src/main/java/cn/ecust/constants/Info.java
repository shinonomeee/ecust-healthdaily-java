package cn.ecust.constants;

import cn.ecust.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用户信息和其他常量类
 * @Author chris
 * @Date 2022/5/2, 13:55
 */
public interface Info {
    // 单线程填报下的默认用户名和密码，要进行一次判空
    User defaultUser = new User("123", "123", "123");

    String loginURL = "https://workflow.ecust.edu.cn/default/work/uust/zxxsmryb/mrybcn.jsp", fillinURL = "https://workflow.ecust.edu.cn/default/work/uust/zxxsmryb/mrybtb.jsp", logoutURL = "https://i.ecust.edu.cn/_web/fusionportal/signOut.jsp?_p=YXM9MSZwPTEmbT1OJg__&service=http%3a%2f%2fi.ecust.edu.cn/";
    String loginButton = "//*[@id=\"casLoginForm\"]/p[5]/button";   // 登录按钮
    String flagButton = "//*[@id=\"radio_swjkzk20\"]/div/ins";

    String healthSituation = flagButton;
    Map<String, String> location = new HashMap<String, String>() {{
        put("Shanghai", "//*[@id=\"radio_xrywz36\"]/div/ins");       // 上海
        put("OtherProvinces", "//*[@id=\"radio_xrywz38\"]/div/ins"); // 国内其他地区
        put("XuhuiCampus", "//*[@id=\"radio_xrywz32\"]/div/ins");    // 徐汇校区
        put("FengxianCampus", "//*[@id=\"radio_xrywz34\"]/div/ins"); // 奉贤校区
    }};
    String tripCode = "//*[@id=\"radio_xcm5\"]/div/ins";
    String outOrNot = "//*[@id=\"radio_sfycxxwc44\"]/div/ins";
    String submit = "//*[@id=\"post\"]";
    String confirmSubmit = "//*[@id=\"layui-layer100001\"]/div[3]/a[1]";
    String finalConfirm = "//*[@id=\"layui-layer100002\"]/div[3]/a";
}