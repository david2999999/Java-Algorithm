package Moderate.BestLine;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.Set;

public class BestLine {

    private Line findBestLine(GraphPoint[] points) {
        HashMapList<Double, Line> lineBySlope = getLineOfGraphs(points);
        return getBestLine(lineBySlope);
    }

    private HashMapList<Double, Line> getLineOfGraphs(GraphPoint[] graphPoints) {
        HashMapList<Double, Line> linesBySlope = new HashMapList<>();
        for (int i = 0; i < graphPoints.length; i++) {
            for (int j = i + 1; j < graphPoints.length; j++) {
                Line line = new Line(graphPoints[i], graphPoints[j]);
                double key = Line.floorToNearestEpsilon(line.slope);
                linesBySlope.put(key, line);
            }
        }

        return linesBySlope;
    }

    private Line getBestLine(HashMapList<Double, Line> lineBySlope) {
        Line bestLine = null;
        int bestCount = 0;

        Set<Double> slopes = lineBySlope.keySet();

        for (Double slope: slopes) {
            ArrayList<Line> lines = lineBySlope.get(slope);

            for (Line line: lines) {
                int count = countEquivalentLines(lineBySlope, line);

                if (count > bestCount) {
                    bestCount = count;
                    bestLine = line;
                }
            }

        }

        return bestLine;
    }

    private int countEquivalentLines(HashMapList<Double, Line> lineBySlope, Line line) {
        double key = Line.floorToNearestEpsilon(line.slope);
        int count = countEquivalentLines(lineBySlope.get(key), line);
        count += countEquivalentLines(lineBySlope.get(key - Line.epsilon), line);
        count += countEquivalentLines(lineBySlope.get(key + Line.epsilon), line);
        return count;
    }

    private int countEquivalentLines(ArrayList<Line> lines, Line line) {
        if (lines == null) return 0;

        int count = 0;

        for (Line l: lines) {
            if (line.isEquivalent(l)) {
                count++;
            }
        }

        return count;
    }
}
