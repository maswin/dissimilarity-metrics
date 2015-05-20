/**
 * dissimilarity-metrics is a JAVA library for measuring dissimilarity.
 * e.g. Jensen–Shannon(JS) divergence, (EMD) Earth movers distance,
 * Quadratic Chi histogram distance.
 *  
 * Copyright (C) 2015 Alagappan.M
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

import java.util.Map;

import dissimilaritymetrics.MapMetric;

public class JSDivergence extends MapMetric{

	/**
	 * Calculates the JSDivergence value of wordMap1 and wordMap2
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
	 * 	JSDivergence value of wordMap1 and wordMap2.
	 */
	@Override
	public double findDissimilarity(Map<String, Integer> wordMap1, int wordMap1Count,
			Map<String, Integer> wordMap2, int wordMap2Count) {
		
		KLDivergence klDiv = new KLDivergence();
		double klDiv1 = klDiv.findDissimilarity(wordMap1, wordMap1Count, wordMap2, wordMap2Count);
		double klDiv2 = klDiv.findDissimilarity(wordMap2, wordMap2Count, wordMap1, wordMap1Count);
		
		return (klDiv1 + klDiv2)/2;
	}

}
