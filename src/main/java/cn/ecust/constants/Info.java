package cn.ecust.constants;

import cn.ecust.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 常量类
 * @Author chris
 * @Date 2022/5/2, 13:55
 */
public interface Info {

    /**
     * 单线程填报下的默认用户名和密码，要进行一次判空
     */
    User defaultUser = new User("123", "123", "123");

    /**
     * 登陆地址
     */
    String loginURL = "https://workflow.ecust.edu.cn/default/work/uust/zxxsmryb/mrybcn.jsp";

    /**
     * 填报地址
     */
    String fillinURL = "https://workflow.ecust.edu.cn/default/work/uust/zxxsmryb/mrybtb.jsp";

    /**
     * 登出地址，暂无用
     */
    String logoutURL = "https://i.ecust.edu.cn/_web/fusionportal/signOut.jsp?_p=YXM9MSZwPTEmbT1OJg__&service=http%3a%2f%2fi.ecust.edu.cn/";

    /**
     * 登陆按钮
     */
    String loginButton = "//*[@id=\"casLoginForm\"]/p[5]/button";   // 登录按钮

    /**
     * 健康情况按钮，被视为flag，如果点按失败则代表今日已填报
     */
    String flagButton = "//*[@id=\"radio_swjkzk20\"]/div/ins";
    String healthSituation = flagButton;

    /**
     * 用来记录用户location所对应xpath的哈希表
     */
    Map<String, String> location = new HashMap<String, String>() {{
        put("Shanghai", "//*[@id=\"radio_xrywz36\"]/div/ins");       // 上海
        put("OtherProvinces", "//*[@id=\"radio_xrywz38\"]/div/ins"); // 国内其他地区
        put("XuhuiCampus", "//*[@id=\"radio_xrywz32\"]/div/ins");    // 徐汇校区
        put("FengxianCampus", "//*[@id=\"radio_xrywz34\"]/div/ins"); // 奉贤校区
    }};

    /**
     * 行程码
     */
    String tripCode = "//*[@id=\"radio_xcm5\"]/div/ins";

    /**
     * 是否从学校外出
     */
    String outOrNot = "//*[@id=\"radio_sfycxxwc44\"]/div/ins";

    /**
     * 提交
     */
    String submit = "//*[@id=\"post\"]";

    /**
     * 确认提交
     */
    String confirmSubmit = "//*[@id=\"layui-layer100001\"]/div[3]/a[1]";

    /**
     * 最终确认
     */
    String finalConfirm = "//*[@id=\"layui-layer100002\"]/div[3]/a";
}