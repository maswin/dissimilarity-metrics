/**
 * dissimilarity-metrics is a JAVA library for measuring dissimilarity.
 * e.g. Jensen–Shannon(JS) divergence, (EMD) Earth movers distance,
 * Quadratic Chi histogram distance.
 *  
 * Copyright (C) 2015 dissimilarity-metrics authors
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package metrics;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import dissimilaritymetrics.MapMetric;
import helpermodules.MapHelperModule;
public class KLDivergence extends MapMetric{

	/**
	 * Calculates the KLDivergence value of wordMap1 with respect to wordMap2
	 * 
	 * @param wordMap1
	 * 	Map with word and its frequency.
	 * 
	 * @param wordMap1Count
	 * 	Sum of frequency of all words in wordMap1.
	 * 
	 *  @param wordMap2
	 * 	Map with word and its frequency.
	 * 
	 * @param wordMap2Count
	 * 	Sum of frequency of all words in wordMap1.
	 * 
	 * @return
	 * 	KLDivergence value of wordMap1 with respect to wordMap2.
	 */
	@Override
	public double findDissimilarity(Map<String, Integer> wordMap1, int wordMap1Count,
			Map<String, Integer> wordMap2, int wordMap2Count) {

		//Combine words in both wordMaps
		Map<String, Integer> combinedWordMap = new HashMap<String,Integer>();
		combinedWordMap.putAll(wordMap1);
		combinedWordMap.putAll(wordMap2);

		//Create vocabulary list with all words
		List<String> vocabulary = new ArrayList<String>();
		Set<String> words = combinedWordMap.keySet();
		for(String word : words){
			vocabulary.add(word);
		}

		//Generate probability distribtuion for wordMaps
		MapHelperModule m = new MapHelperModule();
		Map<String,Double> probabilityDistributionMap1 = 
				m.generateProbabilityDistributionMap(wordMap1, wordMap1Count);
		Map<String,Double> probabilityDistributionMap2 = 
				m.generateProbabilityDistributionMap(wordMap2, wordMap2Count);

		//Calculate KLDivergence
		double klDiv = 0.0;
		for(String word : vocabulary){
			double prob1 = 0.0;
			double prob2 = 0.0;
			if(probabilityDistributionMap1.containsKey(word))
				prob1 = probabilityDistributionMap1.get(word);
			if(probabilityDistributionMap2.containsKey(word))
				prob2 = probabilityDistributionMap2.get(word);
			if((prob1!=0.0) && (prob2!= 0.0))
				klDiv += prob1 * Math.log( prob1 / prob2 );
		}

		klDiv /= log2;
		return klDiv;
	}

}
