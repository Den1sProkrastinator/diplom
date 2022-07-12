package helpers;

import core.Endpoints;
import io.restassured.path.json.JsonPath;
import models.Suite;
import models.TestRuns;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class SuiteHelper {

    public Suite getSuite(int suiteID, int httpStatus) {
        return given()
                .pathParam("suite_id", suiteID)
                .when()
                .get(Endpoints.GET_SUITE)
                .then()
                .assertThat()
                .statusCode(httpStatus)
                .log().body()
                .extract()
                .as(Suite.class);
    }

    public void getSuites(int projectID, int httpStatus) {
         given()
                .pathParams("project_id", projectID)
                .when()
                .get(Endpoints.GET_SUITES)
                .then()
                .assertThat()
                .statusCode(httpStatus);

    }

    public int addSuite(int projectID, Map jsonMap, int httpStatus) {

        JsonPath jsonPath = given()
                .pathParams("project_id", projectID)
                .body(jsonMap)
                .when()
                .post(Endpoints.ADD_SUITE)
                .then()
                .assertThat()
                .statusCode(httpStatus)
                .log().body()
                .extract()
                .jsonPath();

        return jsonPath.getInt("id");

    }

    public void deleteSuite(int suiteId) {

        given()
                .when()
                .pathParams("suite_id", suiteId)
                .post(Endpoints.DELETE_SUITE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    public Suite getExactProjectAsObjects(int suiteID) {
        return given()
                .pathParams("suite_id", suiteID)
                .get(Endpoints.GET_SUITE)
                .then()
                .extract()
                .as(Suite.class);
    }
}
