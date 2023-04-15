package hh.sof3as3.PuzzleProject;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.PuzzleProject.domain.Maker;
import hh.sof3as3.PuzzleProject.domain.MakerRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class MakerRepositoryTest {
	@Autowired
	private MakerRepository makeRepo;
	
	@Test //testataan haku etunimen perusteella
	public void FindByFirstnameShouldReturnMaker() {
		List <Maker> makers = makeRepo.findByFirstname("Aliisa");
		assertThat(makers).hasSize(1);
		assertThat(makers.get(0).getLastname()).isEqualTo("Myllymäki");
	}
	
	@Test // testataan lisäys
	public void createNewMaker() {
		Maker maker = new Maker("Kristian", "Myllymäki", 52);
		makeRepo.save(maker);
		assertThat(maker.getMakerId()).isNotNull();
	}
}
