package com.intellij.advancedExpressionFolding;

import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.impl.JavaSdkImpl;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.DefaultLightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import org.jetbrains.annotations.NotNull;

public class FoldingTest extends LightCodeInsightFixtureTestCase {

    public static final DefaultLightProjectDescriptor TEST_JDK = new DefaultLightProjectDescriptor() {
        public Sdk getSdk() {
            return ((JavaSdkImpl) JavaSdk.getInstance())
                    .createMockJdk("Test JDK", System.getProperty("java.home"), true);
        }
    };

    @Override
    public void setUp() throws Exception {
        super.setUp();
        disableAllFoldings();
    }

    @Override
    protected String getTestDataPath() {
        return "testData";
    }

    @NotNull
    protected LightProjectDescriptor getProjectDescriptor() {
        return TEST_JDK;
    }

    public void doFoldingTest() {
        myFixture.testFoldingWithCollapseStatus(getTestDataPath() + "/" + getTestName(false) + ".java");
    }

    public void doHighlightingTest() {
        myFixture.testHighlighting(getTestDataPath() + "/" + getTestName(false) + ".java");
    }

    public void testElvisTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setCheckExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testForRangeTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setRangeExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testStringBuilderTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setConcatenationExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testInterpolatedStringTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setConcatenationExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testConcatenationTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setConcatenationExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testGetSetPutTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setGetExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testSliceTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setSlicingExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testAppendSetterInterpolatedStringTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setConcatenationExpressionsCollapse(true);
        AdvancedExpressionFoldingSettings.getInstance().getState().setGetSetExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testEqualsCompareTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setComparingExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testTypeCastTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setCastExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testVarTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setVarExpressionsCollapse(true);
        doFoldingTest();
    }

    public void testGetterSetterTestData() {
        AdvancedExpressionFoldingSettings.getInstance().getState().setGetSetExpressionsCollapse(true);
        doFoldingTest();
    }

    private void disableAllFoldings() {
        AdvancedExpressionFoldingSettings.getInstance().getState().disableAll();
    }
}
