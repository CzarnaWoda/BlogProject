package me.blackwater.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class BlogProjectApplicationTests {

    @Test
    void contextLoads() {

        var modules = ApplicationModules.of(BlogProjectApplication.class);

        for(var m : modules){
            System.out.print("module: " + m.getName() + " : " + m.getBasePackage());
        }

        modules.verify();
    }

}
