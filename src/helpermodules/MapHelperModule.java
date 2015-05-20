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

package helpermodules;

import java.util.HashMap;
import java.util.Map;

public class MapHelperModule {
	
	/**
	 * Calculates the total number of words.
	 * 
	 * @param wordMap 
	 * 	Map object a for which total number of words is to be found.
	 * 
	 * @return
	 * 	Total number of words
	 */
	
	public int findTotalCount(Map<String, Integer> wordMap){
		int total = 0;
		for (Integer value : wordMap.values()) {
		    total += value;
		}
		return total;
	}
	
	/**
	 * Calculates the total number of words.
	 * 
	 * @param wordMap 
	 * 	Map object a for which total number of words is to be found.
	 * 
	 * @param total
	 * 	Sum of frequency of the words.
	 * 
	 * @return
	 * 	Total number of words
	 */
	
	public Map<String, Double> generateProbabilityDistributionMap(
			Map<String, Integer> wordMap, int total){
		
		Map<String,Double> probabilityDistributionMap = new HashMap<String,Double>();
		for(String word : wordMap.keySet()){
			probabilityDistributionMap.put(word, 
					wordMap.get(word)/(total*0.1));
		}
		return probabilityDistributionMap;
	}
}
