package hh.sof3as3.PuzzleProject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3as3.PuzzleProject.domain.Completion;
import hh.sof3as3.PuzzleProject.domain.Maker;
import hh.sof3as3.PuzzleProject.domain.MakerRepository;

@CrossOrigin
@Controller
public class MakerController {

	@Autowired
	private MakerRepository makerRepo;

	// list makers
	@GetMapping("/listprofiles")
	public String getMakers(Model model) {
		List<Maker> makers = (List<Maker>) makerRepo.findAll();
		model.addAttribute("makers", makers);
		return "profiles"; // html
	}

	// create new profile
	@GetMapping(value = "/newprofile")
	public String addCompletion(Model model) {
		model.addAttribute("maker", new Maker());
		return "addmaker"; // html
	}

	// save new maker
	@PostMapping("/saveprofile")
	public String saveMaker(@ModelAttribute Maker maker, Model model) {
		makerRepo.save(maker);
		return "redirect:/listprofiles"; // ENDPOINT EI HTML
	}

	// REST hae makers
	@GetMapping("/makers")
	public @ResponseBody List<Maker> getMakersRest() {
		return (List<Maker>) makerRepo.findAll();
	}

	// find by Id REST
	@GetMapping("/makers/{makerId}")
	public @ResponseBody Optional<Maker> getOneMaker(@PathVariable("id") Long makerId) {
		return makerRepo.findById(makerId);
	}

	// REST lisätään uusi maker
	@PostMapping("/makers")
	public @ResponseBody Maker addNewMaker(@RequestBody Maker maker) {
		return makerRepo.save(maker);
	}
}
