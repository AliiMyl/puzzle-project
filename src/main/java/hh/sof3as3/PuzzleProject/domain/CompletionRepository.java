package hh.sof3as3.PuzzleProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CompletionRepository extends CrudRepository<Completion, Long> {

	List<Completion> findByBuildTime(int buildTime);
}
