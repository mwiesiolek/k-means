/*
 * Go through the data points, and for each, work out which centroid it is closest to.
 */
package cluster.steps;

import cluster.calculations.Coordinate;
import cluster.calculations.EuclideanDistance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author katharine
 * 
 */
public class ClusterAssignmentStep {
    
    public static Map<Integer, List<Coordinate>> assignCluster(List<Coordinate> data_points, Map<Integer, Coordinate> centroids) {
        Map<Integer, List<Coordinate>> cluster_assignment = new HashMap<>();

        for (Coordinate point : data_points) {

            double min = Double.MAX_VALUE;
            int cluster = -1;
            for (Map.Entry<Integer, Coordinate> entry : centroids.entrySet()) {
                double distance = EuclideanDistance.calculate(point, entry.getValue());
                if (distance < min) {
                    cluster = entry.getKey();
                    min = distance;
                }
            }

            cluster_assignment.putIfAbsent(cluster, new ArrayList<>());
            cluster_assignment.get(cluster).add(point);
        }

        return cluster_assignment;
    }
}
