package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToOne
	private Question ques;
	
//	@ManyToOne
//	@JoinColumn(name="q_id")
//	private Question question;
	
	public Answer() {
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
	 * @return the ques
	 */
	public Question getQues() {
		return ques;
	}

	/**
	 * @param ques the ques to set
	 */
	public void setQues(Question ques) {
		this.ques = ques;
	}

	/**
	 * @return the question
	 */
//	public Question getQuestion() {
//		return question;
//	}
//
//	/**
//	 * @param question the question to set
//	 */
//	public void setQuestion(Question question) {
//		this.question = question;
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Answer [id=" + id + ", name=" + name + "]";
	}
	
	

}
