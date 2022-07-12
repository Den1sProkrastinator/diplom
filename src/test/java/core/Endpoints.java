package core;

public class Endpoints {

    //suite endpoints

    public static final String GET_SUITE = "index.php?/api/v2/get_suite/{suite_id}";
    public static final String GET_SUITES = "index.php?/api/v2/get_suites/{project_id}";
    public static final String ADD_SUITE = "index.php?/api/v2/add_suite/{project_id}";

    public static final String DELETE_SUITE = "index.php?/api/v2/delete_suite/{suite_id}";


    //project endpoints

    public static final String ADD_PROJECT = "index.php?/api/v2/add_project";

    public static final String DELETE_PROJECT = "index.php?/api/v2/delete_project/{project_id}";


}
