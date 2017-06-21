/*
 * For each of the centroids, look at the data points and work out the center
 * of the cluster
 */
package cluster.steps;

import cluster.calculations.Coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

/**
 * @author katharine
 */
public class MoveCentroidStep {

    public static Map<Integer, Coordinate> moveCentroids(Map<Integer, List<Coordinate>> centroid_index_to_data_points) {
        Map<Integer, Coordinate> new_centroids = new HashMap<>();

        for (Map.Entry<Integer, List<Coordinate>> entry : centroid_index_to_data_points.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                OptionalDouble xAverage = entry.getValue().stream()
                        .mapToDouble(Coordinate::getX)
                        .average();

                OptionalDouble yAverage = entry.getValue().stream()
                        .mapToDouble(Coordinate::getY)
                        .average();

                new_centroids.put(entry.getKey(), new Coordinate(xAverage.getAsDouble(), yAverage.getAsDouble()));
            }
        }

        return new_centroids;
    }

}
