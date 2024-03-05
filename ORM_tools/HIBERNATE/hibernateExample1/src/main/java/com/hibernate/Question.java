package com.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Questions")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToOne
	private Answer ans;
	
	
//	@OneToMany
//	@ManyToMany
//	List<Answer> answers;
	
	public Question() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the answers
	 */
//	public List<Answer> getAnswers() {
//		return answers;
//	}
//
//	/**
//	 * @param answers the answers to set
//	 */
//	public void setAnswers(List<Answer> answers) {
//		this.answers = answers;
//	}

	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + "]";
	}

	/**
	 * @return the ans
	 */
	public Answer getAns() {
		return ans;
	}

	/**
	 * @param ans the ans to set
	 */
	public void setAns(Answer ans) {
		this.ans = ans;
	}
	
	
}
