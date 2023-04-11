package hh.sof3as3.PuzzleProject.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Puzzle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ppId;
	private String title;
	private String manufacturer;
	private int pieceNumber;
	private double price;
	private int difficultyLevel;
	// Completion 
	
	//Puzzle 1--* Completion
/*	@OneToMany(cascade = CascadeType.ALL, mappedBy = ("puzzle"))
	@JsonIgnoreProperties("puzzles")
	@JoinColumn(name = "comId") //FK
	private List<Completion> completions; */
	
	public Puzzle() {}
	//constructors	
	public Puzzle(String title, String manufacturer, int pieceNumber, double price, int difficultyLevel) {
		super();
		this.title = title;
		this.manufacturer = manufacturer;
		this.pieceNumber = pieceNumber;
		this.price = price;
		this.difficultyLevel = difficultyLevel;
	}
	//getters and setters
	public Long getPpId() {
		return ppId;
	}

	public void setPpId(Long ppId) {
		this.ppId = ppId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getPieceNumber() {
		return pieceNumber;
	}

	public void setPieceNumber(int pieceNumber) {
		this.pieceNumber = pieceNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	/*public List<Completion> getCompletions() {
		return completions;
	}
	public void setCompletions(List<Completion> completions) {
		this.completions = completions;
	} */
	//toString
	@Override
	public String toString() {
		return "Puzzle [ppId=" + ppId + ", title=" + title + ", manufacturer=" + manufacturer + ", pieceNumber="
				+ pieceNumber + ", price=" + price + ", difficultyLevel=" + difficultyLevel + "]";
	}

}
