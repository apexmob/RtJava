package com.apexmob.rtjava;

import java.util.List;

public interface TestResult {

    Test getTest();

    List<AssertionResult> getAssertionFailures();

    boolean wasSuccessful();

}
