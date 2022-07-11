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
public class Project {
    private int id;
    private String name;
    private String announcement;
    @SerializedName(value = " show_announcement")
    private boolean showAnnouncement;
    @SerializedName(value = "suite_mode")
    private int suiteMode;



}
