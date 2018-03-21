package rest;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/web")
public class UserEnvironment {

    @Resource
    private Environment environment;

    @RequestMapping("/env")
    public @ResponseBody
    String getEnv(){
        return environment.getProperty("test.name");
    }
}
