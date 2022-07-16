package helpers;


import core.Endpoints;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectHelper {


    public int addProject(Map jsonMap, int httpStatus) {

        JsonPath jsonPath = given()
                .body(jsonMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .assertThat()
                .statusCode(httpStatus)
                .log().body()
                .extract()
                .jsonPath();

        return jsonPath.getInt("id");

    }

    public void deleteProject(int projectId) {

        given()
                .when()
                .pathParams("project_id", projectId)
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
