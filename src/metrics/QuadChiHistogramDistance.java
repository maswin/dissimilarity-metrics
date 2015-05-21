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

import helpermodules.MapHelperModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dissimilaritymetrics.MapMetric;

public class QuadChiHistogramDistance extends MapMetric{

	/**
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 * 	boolean value indicating if the two words are similar.
	 */
	public boolean isSimilar(String word1, String word2){

		//function with wordnet to be implemented
		if(word1.equals(word2))
			return true;
		return false;
	}
	
	/**
	 * Calculates quadratic chi histogram distance of wordMap1 and wordMap2..
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
	 * 	quadratic chi histogram distance of wordMap1 and wordMap2.
	 */
	@Override
	public double findDissimilarity(Map<String, Integer> wordMap1, int wordMap1Count,
			Map<String, Integer> wordMap2, int wordMap2Count) {

		//Normalization Constant
		float n=0.5f;
		
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
				m.generateProbabilityDistributionMap(wordMap2, wordMap1Count);
		
		//Calcualte qChiDistance
		double qChiDistance = 0.0;
		String iWord, jWord, kWord;
		for(int i=0;i<vocabulary.size();i++){
			
			iWord = vocabulary.get(i);
			double iDistance = 0.0;
			if(probabilityDistributionMap1.containsKey(iWord))
				iDistance += probabilityDistributionMap1.get(iWord);
			if(probabilityDistributionMap2.containsKey(iWord))
				iDistance += probabilityDistributionMap2.get(iWord);
			
			for(int j=0;j<vocabulary.size();j++){
				
				jWord = vocabulary.get(j);
				double jDistance = 0.0;
				if(probabilityDistributionMap1.containsKey(jWord))
					jDistance += probabilityDistributionMap1.get(jWord);
				if(probabilityDistributionMap2.containsKey(jWord))
					jDistance += probabilityDistributionMap2.get(jWord);
				
				if(isSimilar(iWord, jWord)){					
					double ikBase = 0.0;
					double jkBase = 0.0;
					for(int k=0;k<vocabulary.size();k++){
						
						kWord = vocabulary.get(k);
						double kDistance = 0.0;
						if(probabilityDistributionMap1.containsKey(kWord))
							kDistance += probabilityDistributionMap1.get(kWord);
						if(probabilityDistributionMap2.containsKey(kWord))
							kDistance += probabilityDistributionMap2.get(kWord);
						
						if(isSimilar(iWord,kWord)){
							ikBase += Math.pow(kDistance, n);
						}
						if(isSimilar(jWord,kWord)){
							jkBase += Math.pow(kDistance, n);
						}
					}				
					qChiDistance += (iDistance/ikBase)*(jDistance/jkBase);
				}
			}
		}
		
		qChiDistance = Math.sqrt(qChiDistance);
		return qChiDistance;
	}

}
