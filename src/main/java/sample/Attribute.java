package sample;

/**
 * Types of attributes in the decision tree.
 */
public class Attribute {

    enum AttributeType {
        NUMERICAL,
        CATEGORICAL
    }

    public static AttributeType getAttributeType(Object obj) {
        try {
            Double.parseDouble(String.valueOf(obj));
            return AttributeType.NUMERICAL;
        } catch (NumberFormatException e) {
            return AttributeType.CATEGORICAL;
        }
    }

    public static AttributeType getDataColumnAttributeType(Object[][] X, int col) {
        for (Object[] x : X) {
            if (getAttributeType(x[col]).equals(AttributeType.CATEGORICAL)) {
                return AttributeType.CATEGORICAL;
            }
        }
        return AttributeType.NUMERICAL;
    }
}
