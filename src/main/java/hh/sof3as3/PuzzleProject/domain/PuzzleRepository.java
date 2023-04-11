package hh.sof3as3.PuzzleProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PuzzleRepository extends CrudRepository <Puzzle, Long>{

	List<Puzzle> findByTitle(String title);
}
