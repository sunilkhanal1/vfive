package sample;

import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The main decision tree data structure
 */
public class DecisionTree {

    public class CategorySplits {

    }

    public class DatasetSplits {

    }

    public class SplitData {

        public List<String[]> leftDataPoints;
        public List<String[]> rightDataPoints;

        public List<String> leftLabels;

        public List<String> rightLabels;

    }

    private SplitData splitDataSetBasedOnAttribute() {
        return new SplitData(); //TODO
    }

    private String label;
    private int attributeIndex;
    private Object attributeValue;

    private DecisionTree leftTree = null;

    private DecisionTree rightTree = null;


    // Split the dataset for categorical features
    private DatasetSplits getCategoricalSplits(DataSet dataSet, int colIndex, List<String[]> dataPoints, List<String> labels) {
        return null; //TODO: fill in this
    }

    // Split the dataset for numerical features
    private DatasetSplits getNumericalSplits(DataSet dataSet, int colIndex, List<String[]> dataPoints, List<String> labels) {
        Set<Double> values = new HashSet<>();
        for (Object[] dataPoint : dataPoints) {
            values.add(Double.parseDouble(String.valueOf(dataPoint[colIndex])));
        }
        for (Double value : values) {
            MathUtils.computeNumericalEntropy(dataSet.getLabelIndexMap(), colIndex, dataPoints, labels, value);
        }
        return null; //TODO: fill in this
    }

    public DecisionTree(DataSet dataSet, List<String[]> dataPoints, List<String> labels) {
        Preconditions.checkArgument(dataPoints.size() == labels.size());
        if (dataPoints.size() == 1) { //TODO: use min leaves number
            this.label = labels.get(0);
        } else {
            Attribute.AttributeType[] attributeTypes = dataSet.getAttributeTypes();
            double rootEntropy = MathUtils.computeEntropy(attributeTypes, dataPoints, labels);

            double maxInformationGain = Double.MIN_VALUE;
            int bestAttributeIndex = -1;
            Object bestAttributeValue = null;
            for (int attributeIndex = 0; attributeIndex < attributeTypes.length; attributeIndex++) {
                Attribute.AttributeType attribute = attributeTypes[attributeIndex];
                double attributeEntropy;
                Object attributeValue = null;
                if (attribute == Attribute.AttributeType.CATEGORICAL) {
                    DatasetSplits categorySplits = getCategoricalSplits(dataSet, attributeIndex, dataPoints, labels);
                    attributeEntropy = 0; //TODO
                    attributeValue = null; //TODO
                } else if (attribute == Attribute.AttributeType.NUMERICAL) {
                    DatasetSplits numericalSplits = getNumericalSplits(dataSet, attributeIndex, dataPoints, labels);
                    attributeEntropy = 0; //TODO
                    attributeValue = null; //TODO
                } else {
                    throw new IllegalArgumentException("unsupported attribute type");
                }
                if (attributeEntropy > maxInformationGain) {
                    maxInformationGain = attributeEntropy;
                    bestAttributeIndex = attributeIndex;
                    bestAttributeValue = attributeValue;
                }
            }

            attributeIndex = bestAttributeIndex;
            attributeValue = bestAttributeValue;

            SplitData splits = splitDataSetBasedOnAttribute();
            leftTree = new DecisionTree(dataSet, splits.leftDataPoints, splits.leftLabels);
            rightTree = new DecisionTree(dataSet, splits.rightDataPoints, splits.rightLabels);
        }
    }

    //TODO: implement method
    public String predict(DataSet dataSet, String[] dataPoint) {
        return null;
    }
}
