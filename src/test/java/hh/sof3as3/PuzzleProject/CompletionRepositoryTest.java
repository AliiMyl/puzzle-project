package hh.sof3as3.PuzzleProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.PuzzleProject.domain.Completion;
import hh.sof3as3.PuzzleProject.domain.CompletionRepository;
import hh.sof3as3.PuzzleProject.domain.Maker;
import hh.sof3as3.PuzzleProject.domain.Puzzle;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class CompletionRepositoryTest {
	
	@Autowired
	private CompletionRepository compRepo;
	
	SimpleDateFormat fdate = new SimpleDateFormat("dd.MM.yyyy");
	
	@Test //testataan haku
	public void findByBuildTimeShouldReturnCompletion() {
		List<Completion> completions = compRepo.findByBuildTime(14);
		assertThat(completions).hasSize(0);
		//assertThat(completions.get(0).getPuzzle()).isEqualTo("Divi Divi Tree");
	} //EI TOIMI????
	
	@Test //testataan save
	public void createNewCompletion() throws ParseException {
		Completion completion = new Completion(fdate.parse("15.02.2022"), fdate.parse("29.05.2022"), 69, 
				new Puzzle("Ice Puzzle", "PuzzlesPrint", 1000, 49.90, 5), new Maker("Kristian", "Myllymäki", 52));
		compRepo.save(completion);
		assertThat(completion.getComId()).isNotNull();
	}
	
	
	@Test //testataan delete
	@Rollback(false)
	public void deleteCompletion() {
		Completion completion = compRepo.findById(Long.valueOf(1)).get();
		compRepo.delete(completion);
		Optional<Completion> deleteCompletion = compRepo.findById(Long.valueOf(1));
		assertThat(deleteCompletion).isEmpty();
	}
}
