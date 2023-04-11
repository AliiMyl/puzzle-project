package hh.sof3as3.PuzzleProject;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.PuzzleProject.domain.Completion;
import hh.sof3as3.PuzzleProject.domain.CompletionRepository;
import hh.sof3as3.PuzzleProject.domain.Maker;
import hh.sof3as3.PuzzleProject.domain.MakerRepository;
import hh.sof3as3.PuzzleProject.domain.Puzzle;
import hh.sof3as3.PuzzleProject.domain.PuzzleRepository;

@SpringBootApplication
public class PuzzleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PuzzleProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner testidata(PuzzleRepository puzRepo, MakerRepository makerRepo, CompletionRepository compRepo) {
		return (args) -> {
			
			//lisätään tekijä
			Maker maker1 = new Maker("Aliisa", "Myllymäki", 20);
			makerRepo.save(maker1);
			
			//lisätään pari palapeliä
			Puzzle puzzle1 = new Puzzle("Divi Divi Tree", "HEYE", 1000, 20.00, 1);
			Puzzle puzzle2 = new Puzzle("Field of Flowers", "TACTIC", 1000, 18.99, 2);
			puzRepo.save(puzzle1);
			puzRepo.save(puzzle2);
			
			//lisätään suoritus/completion
			SimpleDateFormat fdate = new SimpleDateFormat("dd.MM.yyyy");
			
			Completion comp1 = new Completion(fdate.parse("03.04.2023"), fdate.parse("13.05.2023"), 14, puzzle1, maker1); //lisää tiedot
			compRepo.save(comp1);
		
			
			//haetaan palapelit tietokannasta
			List<Puzzle> puzzles = (List<Puzzle>) puzRepo.findAll();
			for (Puzzle puzzle : puzzles) {
				System.out.println(puzzle.toString());
			}
			
			List<Completion> completions = (List<Completion>) compRepo.findAll();
			for (Completion completion : completions) {
				System.out.println(completion.toString());
			}
		
		};
	}
}
