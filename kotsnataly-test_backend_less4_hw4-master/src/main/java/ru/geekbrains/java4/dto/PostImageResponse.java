package ru.geekbrains.java4.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "data",
        "success",
        "status"
})

@Data
public class PostImageResponse extends CommonResponse<PostImageResponse.ImageData> {
    @Data
    public static class ImageData {
        @JsonProperty("id")
        public String id;
        @JsonProperty("title")
        public String title;
        @JsonProperty("description")
        public String description;
        @JsonProperty("datetime")
        public Integer datetime;
        @JsonProperty("type")
        public String type;
        @JsonProperty("animated")
        public Boolean animated;
        @JsonProperty("width")
        public Integer width;
        @JsonProperty("height")
        public Integer height;
        @JsonProperty("size")
        public Integer size;
        @JsonProperty("views")
        public Integer views;
        @JsonProperty("bandwidth")
        public Integer bandwidth;
        @JsonProperty("vote")
        public String vote;
        @JsonProperty("favorite")
        public Boolean favorite;
        @JsonProperty("nsfw")
        public String nsfw;
        @JsonProperty("section")
        public String section;
        @JsonProperty("account_url")
        public String accountUrl;
        @JsonProperty("account_id")
        public Integer accountId;
        @JsonProperty("is_ad")
        public Boolean isAd;
        @JsonProperty("in_most_viral")
        public Boolean inMostViral;
        @JsonProperty("has_sound")
        public Boolean hasSound;
        @JsonProperty("tags")
        public List<String> tags = new ArrayList<>();
        @JsonProperty("ad_type")
        public Integer adType;
        @JsonProperty("ad_url")
        public String adUrl;
        @JsonProperty("edited")
        public String edited;
        @JsonProperty("in_gallery")
        public Boolean inGallery;
        @JsonProperty("deletehash")
        public String deletehash;
        @JsonProperty("name")
        public String name;
        @JsonProperty("link")
        public String link;

    }
}