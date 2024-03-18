# Dev Documentation

## Publishing

- To release library to MavenLocal(~/.m2/):

  ```sh
  ./gradlew releaseToMavenLocal
  ```

- To release library
  to [MavenCentral](https://search.maven.org/artifact/com.github.nisrulz/devicetypektx):

  ```sh
  ./gradlew releaseToMavenCentral
  ```

- To generate documentation:

  ```sh
  ./gradlew assembleDocs
  ```
  > Docs are automatically published from the Github repo, via GH Pages building from `docs` dir
  from `master` branch.