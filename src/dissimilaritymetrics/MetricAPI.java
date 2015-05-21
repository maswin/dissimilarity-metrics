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

import java.util.Map;

import metrics.KLDivergence;
import metrics.JSDivergence;
import metrics.EMD;
import metrics.QuadChiHistogramDistance;

public class MetricAPI {
	
	//KLDivergence methods
	public double findKLDivergence(Map<String, Integer> a,
			Map<String, Integer> b){
		return new KLDivergence().findDissimilarity(a, b);
	}
	public double findKLDivergence(Map<String, Integer> a,int aCount,
			Map<String, Integer> b, int bCount){
		return new KLDivergence().findDissimilarity(a, aCount, b, bCount);
	}
	
	//JSDivergence methods
	public double findJSDivergence(Map<String, Integer> a,
			Map<String, Integer> b){
		return new JSDivergence().findDissimilarity(a, b);
	}
	public double findJSDivergence(Map<String, Integer> a,int aCount,
			Map<String, Integer> b,int bCount){
		return new JSDivergence().findDissimilarity(a, aCount, b, bCount);
	}
	
	//Earth Movers Distance
	public double findEMD(Map<String, Integer> a,
			Map<String, Integer> b){
		return new EMD().findDissimilarity(a, b);
	}
	public double findEMD(Map<String, Integer> a, int aCount,
			Map<String, Integer> b, int bCount){
		return new EMD().findDissimilarity(a, aCount, b, bCount);
	}
	
	//Quadratic Chi Histogram Distance
	public double findQuadChiHistogramDistance(Map<String, Integer> a,
			Map<String, Integer> b){
		return new QuadChiHistogramDistance().findDissimilarity(a, b);
	}
	public double findQuadChiHistogramDistance(Map<String, Integer> a, int aCount,
			Map<String, Integer> b, int bCount){
		return new QuadChiHistogramDistance().findDissimilarity(a, aCount, b, bCount);
	}
	
}
