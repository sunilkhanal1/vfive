# Notes
This is an incomplete implementation of a generalized decision tree classifier, which supports both categorical and numerical 
data types in the input. This would be used as follows:

`DecisionTreeClassifier` initializes the decision tree classifier with different parameters, and the data structure `DecisionTree`.

`DecisionTree` contains the logic to train the decision tree, by computing dataset splits based on information gain. On a completed variant, it would also complete functionalities to predict the class for a given data point.

# Instructions
1. Build project:

   `./gradlew shadowJar`

This builds the project as  `build/libs/*-SNAPSHOT-all.jar` with all dependencies packaged into the Jar.

2. Execute the project:

   TODO: project is still incomplete