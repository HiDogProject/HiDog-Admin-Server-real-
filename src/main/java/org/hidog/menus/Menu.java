package org.hidog.menus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private final static Map<String, List<MenuDetail>> menus;

    static {

        menus = new HashMap<>();

        menus.put("config", Arrays.asList(
                new MenuDetail("basic", "기본 설정", "/config"),
                new MenuDetail("api", "API 설정", "/config/api"),
                new MenuDetail("payment", "결제 설정", "/config/payment")
        ));

        menus.put("member", Arrays.asList(
            new MenuDetail("list", "회원 목록", "/member"),
            new MenuDetail("authority", "회원 설정", "/member/authority")
        ));
        
        menus.put("board", Arrays.asList(
                new MenuDetail("list", "게시판 목록", "/board"),
                new MenuDetail("add", "게시판 등록", "/board/add"),
                new MenuDetail("posts", "게시글 관리", "/board/posts")
        ));
    }

    public static List<MenuDetail> getMenus(String code) {
        return menus.get(code);
    }
}
