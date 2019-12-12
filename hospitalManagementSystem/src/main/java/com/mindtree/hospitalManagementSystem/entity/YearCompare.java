package com.mindtree.hospitalManagementSystem.entity;

import java.util.Comparator;

public class YearCompare implements Comparator<Doctor> {

	@Override
	public int compare(Doctor doc1, Doctor doc2) {
		if (doc1.getYearOfExperience() > doc2.getYearOfExperience()) {
			return 1;
		} else if (doc1.getYearOfExperience() < doc2.getYearOfExperience()) {
			return -1;
		} else {
			return 0;
		}
	}
}
