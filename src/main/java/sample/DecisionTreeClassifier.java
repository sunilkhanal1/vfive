package sample;

/**
 * Interface for the decision tree
 */
public class DecisionTreeClassifier {

    enum SplitCriterion {
        INNFORMATION_GAIN,
        GINI
    }

    private final SplitCriterion splitCriterion;
    private final int maxDepth;
    private final int minSamplesPerSplit;
    private final int minSamplesPerLeaf;
    private final int maxFeaturesForSplit;

    private DecisionTreeClassifier(DecisionTreeClassifierBuilder builder) {
        this.splitCriterion = builder.splitCriterion;
        if (!splitCriterion.equals(SplitCriterion.INNFORMATION_GAIN)) {
            throw new NotImplementedException("Not implemented:" + splitCriterion);
        }

        this.maxDepth = builder.maxDepth;
        this.minSamplesPerSplit = builder.minSamplesPerSplit;
        this.minSamplesPerLeaf = builder.minSamplesPerLeaf;
        this.maxFeaturesForSplit = builder.maxFeaturesForSplit;

        //TODO: initialize DecisionTree data structure with the dataset
    }

    public SplitCriterion getSplitCriterion() {
        return splitCriterion;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public int getMinSamplesPerSplit() {
        return minSamplesPerSplit;
    }

    public int getMinSamplesPerLeaf() {
        return minSamplesPerLeaf;
    }

    public int getMaxFeaturesForSplit() {
        return maxFeaturesForSplit;
    }


    public void train(Object[][] X, int labelColumn) {
        //TODO
    }
    public void train(Object[][] X, Object[] y) {
        //TODO
    }

    public void predict(Object[][] X) {
        //TODO
    }

    public void predictProbabilities(Object[][] X) {
        //TODO
    }

    public void featureImportance() {
        //TODO
    }

    public static class DecisionTreeClassifierBuilder {

        private SplitCriterion splitCriterion = SplitCriterion.INNFORMATION_GAIN;
        private int maxDepth = -1;
        private int minSamplesPerSplit = 2;

        private int minSamplesPerLeaf = 1;

        private int maxFeaturesForSplit = -1;

        public DecisionTreeClassifierBuilder withSplitCriterion(SplitCriterion splitCriterion) {
            this.splitCriterion = splitCriterion;
            return this;
        }

        public DecisionTreeClassifierBuilder withMaxDepth(int maxDepth) {
            this.maxDepth = maxDepth;
            return this;
        }

        public DecisionTreeClassifierBuilder withMinSamplesToSplit(int minSamplesPerSplit) {
            this.minSamplesPerSplit = minSamplesPerSplit;
            return this;
        }

        public DecisionTreeClassifierBuilder withMinSamplesPerLeaf(int minSamplesPerLeaf) {
            this.minSamplesPerLeaf = minSamplesPerLeaf;
            return this;
        }

        public DecisionTreeClassifierBuilder withMaxFeaturesForSplit(int maxFeaturesForSplit) {
            this.maxFeaturesForSplit = maxFeaturesForSplit;
            return this;
        }

        public DecisionTreeClassifier build() {
            return new DecisionTreeClassifier(this);
        }
    }
}
