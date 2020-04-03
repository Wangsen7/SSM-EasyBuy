package com.entity;

import java.io.Serializable;

public class Result implements Serializable{
	private char stuno;
	private char subjectName;
	private int score;
	private int age;
	public char getStuno() {
		return stuno;
	}
	public void setStuno(char stuno) {
		this.stuno = stuno;
	}
	public char getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(char subjectName) {
		this.subjectName = subjectName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Result(char stuno, char subjectName, int score, int age) {
		super();
		this.stuno = stuno;
		this.subjectName = subjectName;
		this.score = score;
		this.age = age;
	}
	public Result() {
		super();
	}
	

}
