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

import hh.sof3as3.PuzzleProject.domain.Puzzle;
import hh.sof3as3.PuzzleProject.domain.PuzzleRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class PuzzleRepositoryTest {
	@Autowired
	private PuzzleRepository puzzRepo;
	
	@Test //testataan haku
	public void FindByTitleShouldReturnPuzzle() {
		List<Puzzle> puzzles = puzzRepo.findByTitle("Field of Flowers");
		assertThat(puzzles.get(0).getManufacturer()).isEqualTo("TACTIC");
	}
	
	@Test //testataan lisäys
	public void createNewPuzzle() {
		Puzzle puzzle = new Puzzle("Ice Puzzle", "PuzzlesPrint", 1000, 49.90, 10);
		puzzRepo.save(puzzle);
		assertThat(puzzle.getPpId()).isNotNull();
	}
	
	@Test //testataan poisto
	@Rollback(false)
	public void deletePuzzle() {
		Puzzle puzzle = puzzRepo.findById(Long.valueOf(2)).get();
		puzzRepo.delete(puzzle);
		Optional<Puzzle> deletePuzzle = puzzRepo.findById(Long.valueOf(2));
		assertThat(deletePuzzle).isEmpty();
	}
	
}
