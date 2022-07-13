package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@Builder
@Getter
@EqualsAndHashCode
public class Suite {
    private int id;
    private String name;
    private String description;
    @SerializedName(value = "project_id")
    private int projectId;
    @SerializedName(value = "is_master")
    private boolean isMaster;
    @SerializedName(value = "is_baseline")
    private boolean isBaseline;
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
    @SerializedName(value = "completed_on")
    private String completedOn;
    private String url;
}
