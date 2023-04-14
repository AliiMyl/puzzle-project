package hh.sof3as3.PuzzleProject.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Completion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date finish;
	private int buildTime;

	// Completion *--1 Puzzle
	@ManyToOne
	@JsonIgnoreProperties("completions")
	@JoinColumn(name = "ppId") // FK
	private Puzzle puzzle;
	// puzzleMaker Maker

	@ManyToOne
	@JsonIgnoreProperties("completions")
	@JoinColumn(name = "makerId") // FK
	private Maker maker;

	// constructors
	public Completion() {
	}

	public Completion(Date start, Date finish, int buildTime, Puzzle puzzle, Maker maker) {
		super();
		this.start = start;
		this.finish = finish;
		this.buildTime = buildTime;
		this.puzzle = puzzle;
		this.maker = maker;
	}

	// getters and setters

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public int getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(int buildTime) {
		this.buildTime = buildTime;
	}

	public Puzzle getPuzzle() {
		return puzzle;
	}

	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}

	public Maker getMaker() {
		return maker;
	}

	public void setMaker(Maker maker) {
		this.maker = maker;
	}

	// toString
	@Override
	public String toString() {
		return "Completion [comId=" + comId + ", start=" + start + ", finish=" + finish + ", buildTime=" + buildTime
				+ ", puzzle=" + puzzle + ", maker=" + maker + "]";
	}

}