package helpers;

import core.Endpoints;
import io.restassured.path.json.JsonPath;
import models.Project;
import models.TestRuns;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectHelper {


    public int addProject(Map jsonMap) {

        JsonPath jsonPath= given()
                .body(jsonMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .jsonPath();

       return jsonPath.getInt("id");



    }
}
