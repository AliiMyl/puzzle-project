package hh.sof3as3.PuzzleProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3as3.PuzzleProject.domain.Puzzle;
import hh.sof3as3.PuzzleProject.domain.PuzzleRepository;

@Controller
public class PuzzleController {

	@Autowired //etsitään PuzzleRepository
	private PuzzleRepository puzzleRepo;
	
	@GetMapping("/puzzlelist")
	public String getPuzzles(Model model) {
		List<Puzzle> puzzles = (List<Puzzle>) puzzleRepo.findAll(); //fixataan PuzzleRepository
		model.addAttribute("puzzles", puzzles);
		return "puzzlelist"; //tähän html tiedosto
	}
	
	@GetMapping(value= "/addpuzzle") //post?
	public String addPuzzle(Model model) {
		model.addAttribute("puzzle", new Puzzle());
		return "addpuzzle"; //html
	}
	
	@PostMapping("/savepuzzle")
	public String savePuzzle(@ModelAttribute Puzzle puzzle, Model model) {
		puzzleRepo.save(puzzle);
		return "redirect:/puzzlelist";	
	}
	/*
	@GetMapping("/delete/{ppId}")
	public String deletePuzzle(@PathVariable("ppId") Long id, Model model) {
		puzzleRepo.deleteById(id);
		return "redirect:../puzzlelist"; 
	}
	*/
}
