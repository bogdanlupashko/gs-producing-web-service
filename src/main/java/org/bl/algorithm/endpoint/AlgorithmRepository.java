package org.bl.algorithm.endpoint;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import org.bl.algorithm.ws.Algorithm;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AlgorithmRepository {
	private static final List<Algorithm> algorithmList = new ArrayList<>();

	@PostConstruct
	public void initData() {
		Algorithm changeABvalues = new Algorithm();
		changeABvalues.setName("Change A and B values");
		changeABvalues.setAuthor("somebody");
		changeABvalues.setDescription("Needs to change values A and B. A should be = B, and vice versa.");
		changeABvalues.setAnswer("a=b");

		algorithmList.add(changeABvalues);

		Algorithm createTimeSheet = new Algorithm();
		createTimeSheet.setName("Time sheet creator");
		createTimeSheet.setAuthor("Branch's chef");
		createTimeSheet.setDescription("Clones working time to 6 days in the week, and split it by pipeline");
		createTimeSheet.setAnswer("a*7");

		algorithmList.add(createTimeSheet);
	}

	public Algorithm findAlgorithm(String name) {
		Assert.notNull(name);

		Algorithm result = null;

		for (Algorithm country : algorithmList) {
			if (name.equals(country.getName())) {
				return country;
			}
		}

		return algorithmList.get(0);
	}
}
