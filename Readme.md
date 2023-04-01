# Instructions
1. Build project:

   `./gradlew shadowJar`

This builds the project as  `build/libs/*-SNAPSHOT-all.jar` with all dependencies packaged into the Jar.

2. Execute the project:

    `java -jar build/libs/*-SNAPSHOT-all.jar`