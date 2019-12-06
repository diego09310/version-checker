# Version Checker
Web service that compares two versions and returns if the second is before, after or equal to the first one.

## Usage
Make the following GET call:
`http://localhost:8080/version?v1=1.0&v2=2.0`
substituting `1,0` and `2.0` with the versions to compare.
In this example v2 is greater than v1, so it returns after.

## Unit tests
The project includes a set of unit tests to verify the behavior of the comparator implemented.
