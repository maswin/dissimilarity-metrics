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

package dissimilaritymetrics;

import helpermodules.MapHelperModule;

/**
 * MapMetric gets Map<String,Integer> as input where the key is a String
 * that represents the word and value is an Integer that represents the
 * frequency of that word.
 * 
 */
import java.util.Map;

public abstract class MapMetric implements Metric<Map<String,Integer>>{
	
	public abstract double findDissimilarity(Map<String,Integer> a, int aCount,
			Map<String,Integer> b, int bCount);
	
	public double findDissimilarity(Map<String,Integer> a,
			Map<String,Integer> b){
		MapHelperModule m = new MapHelperModule();
		return findDissimilarity(a, m.findTotalCount(a),
				b,m.findTotalCount(b));
	}
}
