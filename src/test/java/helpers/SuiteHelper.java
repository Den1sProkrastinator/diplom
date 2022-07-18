package helpers;

import core.Endpoints;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;


import java.util.Map;

import static io.restassured.RestAssured.given;


public class SuiteHelper {

    public void getSuite(int suiteID, int httpStatus) {
        given()
                .pathParam("suite_id", suiteID)
                .when()
                .get(Endpoints.GET_SUITE)
                .then()
                .assertThat()
                .statusCode(httpStatus)
                .log().body();

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

    public String getSuiteName(int suiteID) {

        JsonPath jsonPath = given()
                .pathParams("suite_id", suiteID)
                .when()
                .get(Endpoints.GET_SUITE)
                .then()
                .log().status()
                .log().body()
                .extract()
                .jsonPath();

        return jsonPath.getString("name");
    }
}

