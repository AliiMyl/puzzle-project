package hh.sof3as3.PuzzleProject;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.PuzzleProject.web.MakerController;

@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
public class CompletionMakerTest {
	
	@Autowired
	private MakerController makeCont;
	
	@Test
	public void contextLoads() {
		assertThat(makeCont).isNotNull();
	}

}
