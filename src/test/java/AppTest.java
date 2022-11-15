import com.github.tebr5923.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.github.tebr5923.AppConfig.class)
public class AppTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void mainTest() {
        com.github.tebr5923.HelloWorld tree =
                applicationContext.getBean(com.github.tebr5923.HelloWorld.class);
        com.github.tebr5923.HelloWorld leaf =
                applicationContext.getBean(com.github.tebr5923.HelloWorld.class);

        Cat one = applicationContext.getBean(Cat.class);
        Cat two = applicationContext.getBean(Cat.class);

        Assert.assertSame("Тест провален, не корректная настройка бина com.github.tebr5923.HelloWorld", tree, leaf);
        Assert.assertNotSame("Тест провален, не корректная настройка бина Cat", one, two);
    }
}
