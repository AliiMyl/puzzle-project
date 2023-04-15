package hh.sof3as3.PuzzleProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MakerRepository extends CrudRepository<Maker, Long> {
	List<Maker> findByFirstname(String firstname);
	List<Maker> findByLastname(String lastname);
}
