package spittr.web;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wushuai3 on 2017/2/22.
 */

@Controller
public class HomeController {
    @RequestMapping(value="/", method=GET)
    public String home(){
        return "home";
    }
}
