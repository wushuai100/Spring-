package testspring;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wutest.CDPlayerConfig;
import wutest.CompactDisc;

/**
 * Created by wushuai3 on 2017/1/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CompactDiscTest {
    @Rule

    @Autowired
    private CompactDisc cd;
    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

}
