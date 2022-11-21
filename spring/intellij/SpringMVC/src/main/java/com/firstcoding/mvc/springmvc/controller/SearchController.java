package com.firstcoding.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @RequestMapping("/search/search")
    public String searchForm(){
        return "searchForm";
    }

    @RequestMapping("/board/board") // 같은 클래스 mapping이 가지고 있는 view에 ModelAttribute 공유된다
    public String board(){
        return "board";
    }

    @ModelAttribute("keywords")
    public String[] getKeywords(){
        return new String[]{"손흥민", "월드컵", "이강인", "호날두", "카타르"};
    }

    @ModelAttribute("searchType")
    public List<String> getSearchType(){
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("id");
        list.add("keyword");

        return list;
    }
}
