# RtJava
RtJava is a ReactiveX based implementation of a Java testing framework designed to be highly extensible.

# Approach
1. Construct a Stream of events that represent the classes that contain the tests to execute
2. Use Rx operations to perform the following:
 - Convert classes to "tests" that represent an instance and test method (with parameters if appropriate)
 - Construct child tests to support iterating over parameter options or security options
 - Execute typical testing capabilities such as JUnit4's @BeforeClass, @Before, @After, @AfterClass
3. The "test" stream ends with execution of the test method
4. Assertions within the test construct a new Stream of events representing the Assertions for the test
5. Use Rx operations to perform the following:
 - Monitor for expected exceptions and convert "failed with exception" to success results
 - Aggregate assertions into a test result that is either considered a success or a failure
 
# Extension Points
RtJava's goal is to provide a first-class integration point for all aspects of the testing process, including at least the following:
 - Test Identification within a class
 - Construction of a test instance
 - Identification of Child tests within a Test (i.e. Parameterized tests)
 - Filtering of Tests to ignore
 - Validation of tests
 - Pre- and Post- processing of tests at both a class and test level (possibly more)
 - Execution of tests
 - Assertion Results alteration (i.e. Identify an exception as expected)
 
RtJava will also provide a mechanism to bundle all of these extension points into a "Dialect" that can be configured on a per class or execution basis so that projects that are in the process of migrating frameworks (i.e. JUnit4 to JUnit5) could do so on a per-class basis.  This same Dialect approach could also allow developers to easily construct their own Dialect from the pieces that they like in different test frameworks.
  
# Beginnings
RtJava is in its infancy stage as I learn more about RxJava (I would welcome feedback and pull requests to clear up any misinterpretations).  I am starting with implementing it in a single-threaded model, but I would hope that in time it would support each test executing on its own thread from a Thread pool.


# Contributing to RtJava
If you are interested in improving RtJava, great! The RtJava community looks forward to your contribution. Please follow this process:

1. Submit a bug or enhancement request as an issue.
2. [Fork](http://help.github.com/forking/) apexmob/RtJava. Ideally, create a new branch from your fork for your contribution to make it easier to merge your changes back.
3. Make your changes on the branch you hopefuly created in Step 2. Be sure that your code passes existing unit tests. Please add unit tests for your work if appropriate. It usually is.
4. Push your changes to your fork/branch in github. Don't push it to your master! If you do it will make it harder to submit new changes later.
5. Submit a pull request to apexmob from your commit page on github.
