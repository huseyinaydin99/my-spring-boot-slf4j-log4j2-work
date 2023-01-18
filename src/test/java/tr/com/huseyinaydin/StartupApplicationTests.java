package tr.com.huseyinaydin;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tr.com.huseyinaydin.SpringBean;

/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot Slf4j - Log4j
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartupApplicationTests {

	@Autowired
	SpringBean bean;

	@Value("${tr.com.huseyinaydin.filePath}")
	String file;

	@Test
	public void springBeanLog_whenLevelError_thenReadInfoAndError() throws IOException, InterruptedException {
		bean.log();
		String content = new String(Files.readAllBytes(Paths.get(file)));
		assertTrue(content.contains("INFO  tr.com.huseyinaydin.SpringBean - info")
				&& content.contains("ERROR tr.com.huseyinaydin.SpringBean - error"));
	}

}
