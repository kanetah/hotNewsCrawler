package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("aboutController")
public class AboutController {

    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}
