package tests.api;

import baseEntities.BaseApiTest;
import org.testng.annotations.Test;

public class ApeTests extends BaseApiTest {
    @Test
    public void getTest(){
        testRunAndResultHelper.iSetGETPostsApiEndpoint(1);
    }

}
