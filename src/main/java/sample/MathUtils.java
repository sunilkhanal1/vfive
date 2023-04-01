package sample;

import java.sql.Array;
import java.util.*;

public class MathUtils {

    public double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    // Compute entropy of root tree
    public static double computeEntropy(Attribute.AttributeType[] attributeTypes, List<String[]> dataPoints, List<String> labels) {
        return 0; //TODO
    }

    // Compute entropy for a numerical feature taking on a particular value
    public static double computeNumericalEntropy(Map<String, Integer> labelIndexMap, int colIndex, List<String[]> dataPoints, List<String> labels, double value) {
        List<String[]> lessThanValue = new ArrayList<>();
        List<String[]> greaterThanEqualToValue = new ArrayList<>();
        for (String[] dataPoint : dataPoints) {
            if (Double.parseDouble(dataPoint[colIndex]) < value) {
                lessThanValue.add(dataPoint);
            } else {
                greaterThanEqualToValue.add(dataPoint);
            }
        }

        double pGreaterThanEquals = -((double) greaterThanEqualToValue.size()) / dataPoints.size();
        double pGreaterThanEqualsSum = 0;
        double pLessThanSum = 0;

        for (Map.Entry<String, Integer> labelEntry : labelIndexMap.entrySet()) {
            int numItemsWithCurLabelGreaterThanEquals = 0;
            int numItemsWithCurLabelLessThan = 0;
            double totalInClass = 0;
            for (int i = 0; i < dataPoints.size(); i++) {
                String[] dataPoint = dataPoints.get(i);
                double dataPointValue = Double.parseDouble(dataPoint[colIndex]);

                if (labels.get(i).equals(labelEntry.getKey())) {
                    if (dataPointValue >= value) {
                        numItemsWithCurLabelGreaterThanEquals++;
                    } else {
                        numItemsWithCurLabelLessThan++;
                    }
                    totalInClass++;
                }
            }

        }

        return 0; //TODO: complete this
    }
}
