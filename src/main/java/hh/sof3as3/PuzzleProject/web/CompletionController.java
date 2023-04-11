package hh.sof3as3.PuzzleProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3as3.PuzzleProject.domain.Completion;
import hh.sof3as3.PuzzleProject.domain.CompletionRepository;
import hh.sof3as3.PuzzleProject.domain.MakerRepository;
import hh.sof3as3.PuzzleProject.domain.PuzzleRepository;

@Controller
public class CompletionController {

	@Autowired
	private CompletionRepository comRepo;
	@Autowired
	private PuzzleRepository puzRepo;
	@Autowired
	private MakerRepository makerRepo;
	
	@GetMapping("/completionlist")
	public String getCompletions(Model model) {
		List<Completion> completions = (List<Completion>) comRepo.findAll();
		model.addAttribute("completions", completions);
		return "completionlist"; //html tiedosto?
	}
		
		 @GetMapping(value = "/addcompletion")
		 public String addCompletion(Model model) {
			 model.addAttribute("completion", new Completion());
			 model.addAttribute("puzzles", puzRepo.findAll());
			 model.addAttribute("makers", makerRepo.findAll());
			 return "addcompletion"; //html
		}
		 
		 @PostMapping("/savecompletion")
		 public String saveCompletion(@ModelAttribute Completion completion, Model model) {
			comRepo.save(completion);
			return "redirect:/completionlist";
		 }
	
		 @GetMapping("/delete/{comId}")
		 public String deleteCompletion(@PathVariable("comId") Long id, Model model) {
			 comRepo.deleteById(id);
			 return "redirect:../completionlist";
			 }
}
