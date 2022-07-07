package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class TestRuns {
    private int id;
    private int suite_id;
    private String name;
    private String description;
    private int milestone_id;
    private int assignedto_id;
    private boolean include_all;
    private boolean is_completed;
    private String completed_on;
    private String config;
//    private int[] config_ids; //вопрос
    private int passed_count;
    private int blocked_count;
    private int untested_count;
    private int retest_count;
    private int failed_count;
    private int custom_status1_count;
    private int custom_status2_count;
    private int custom_status3_count;
    private int custom_status4_count;
    private int custom_status5_count;
    private int custom_status6_count;
    private int custom_status7_count;
    private int project_id;
    private int plan_id;
    private int created_on;
    private int updated_on;
    private String refs;
    private int created_by;
    private String url;

}
