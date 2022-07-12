package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@Builder
@Getter

public class TestRuns {
    //uncorrected field
    private String uncorrectedField;

    //corrected fields
    private int id;
    @SerializedName(value = "suite_id")
    private int suiteId;
    private String name;
    private String description;
    @SerializedName(value = "milestone_id")
    private int milestoneId;
    @SerializedName(value = "assignedto_id;")
    private int assignedToId;
    @SerializedName(value = "include_all")
    private boolean includeAll;
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
    @SerializedName(value = "completed_on")
    private String completedOn;
    private String config;
    @SerializedName(value = "config_ids")
    private int[] configIds; //вопрос
    @SerializedName(value = "passed_count")
    private int passedCount;
    @SerializedName(value = "blocked_count")
    private int blockedCount;
    @SerializedName(value = "untested_count")
    private int untestedCount;
    @SerializedName(value = "retest_count")
    private int retestCount;
    @SerializedName(value = "failed_count")
    private int failedCount;
    @SerializedName(value = "custom_status1_count")
    private int customStatus1Count;
    @SerializedName(value = "custom_status2_count")
    private int customStatus2Count;
    @SerializedName(value = "custom_status3_count")
    private int customStatus3Count;
    @SerializedName(value = "custom_status4_count")
    private int customStatus4Count;
    @SerializedName(value = "custom_status5_count")
    private int customStatus5Count;
    @SerializedName(value = "custom_status6_count")
    private int customStatus6Count;
    @SerializedName(value = "custom_status7_count")
    private int customStatus7Count;
    @SerializedName(value = "project_id")
    private int projectId;
    @SerializedName(value = "plan_id")
    private int planId;
    @SerializedName(value = "created_on")
    private int createdOn;
    @SerializedName(value = "updated_on")
    private int updatedOn;
    private String refs;
    @SerializedName(value = "created_by")
    private int createdBy;
    private String url;

}
