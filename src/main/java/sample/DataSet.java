package sample;

import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulating the generic dataset
 */
public class DataSet {
    private String[][] data;

    private String[] labels;

    private Attribute.AttributeType[] attributeTypes;

    private Map<String, Integer> labelIndexMap;

    public DataSet(String[][] X, String[] labels) {
        this.data = X;
        this.labels = labels;

        int numCols = X[0].length;
        attributeTypes = new Attribute.AttributeType[numCols];
        for (int col = 0; col < numCols; col++) {
            attributeTypes[col] = Attribute.getDataColumnAttributeType(X, col);
        }

        labelIndexMap = new HashMap<>();
        int labelIndex = 0;
        for (String label : labels) {
            if (!labelIndexMap.containsKey(label)) {
                labelIndexMap.put(label, labelIndex++);
            }
        }
    }

    public String[][] getData() {
        return data;
    }

    public String[] getLabels() {
        return labels;
    }

    public Attribute.AttributeType[] getAttributeTypes() {
        return attributeTypes;
    }

    public Map<String, Integer> getLabelIndexMap() {
        return labelIndexMap;
    }
}
