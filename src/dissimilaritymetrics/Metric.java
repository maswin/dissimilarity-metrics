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

package dissimilaritymetrics;

import java.util.List;


public interface Metric <T>{
	/**
	 * Measures the dissimilarity between a and b.
	 * 
	 * @param a 
	 * 	object a to compare
	 * @param b
	 * 	object b to compare
	 * 
	 * @return
	 * 	dissimilarity value
	 */
	public double findDissimilarity(T a, T b);

}
