package aop.controller;

import aop.aspect.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***********************************************************                                          *
 * Time: 2021/9/24
 * Author: HuHong
 * Desc:
 ***********************************************************/

@RestController
@RequestMapping("aop")
public class AopController {

    @GetMapping("hello")
    public String hello(@RequestParam String name){
        return "hello, " + name;
    }

    @GetMapping("hello2")
    public String hello2(@RequestParam String name, @RequestParam String age){
        return "hello, " + name + ", your age is " + age;
    }

    @GetMapping("bye")
    public String bye(@RequestParam String name){
        return "bye, " + name;
    }

    @GetMapping("cnt")
    public String getCnt(){
        return String.valueOf(MyLog.getHelloCnt());
    }

}
