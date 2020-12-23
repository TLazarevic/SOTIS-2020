package com.example.SOTIS.model.DTO;

import java.util.HashMap;

// matrix dto for iita algorithm
public class MatrixDTO {

	// matrix that contains correctnes of each question for each student that took
	// the test
	private HashMap<Long, HashMap<Long, Integer>> matrix = new HashMap<>();

	public HashMap<Long, HashMap<Long, Integer>> getMatrix() {
		return matrix;
	}

	public void setMatrix(HashMap<Long, HashMap<Long, Integer>> matrix) {
		this.matrix = matrix;
	}

}
