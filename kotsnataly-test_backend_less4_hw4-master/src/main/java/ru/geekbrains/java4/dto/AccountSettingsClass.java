package ru.geekbrains.java4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

//класс работы с настройами аккаунта, содержит поля имеющие отношение к подписке, вкл.выкл. взрослого контента и т.д.
public class AccountSettingsClass extends CommonResponse<AccountSettingsClass.AccountDetails>{

    @Data
    public static class AccountDetails {

        @JsonProperty("account_url")
        private String accountUrl;
        @JsonProperty("email")
        private String email;
        @JsonProperty("avatar")
        private String avatar;
        @JsonProperty("cover")
        private String cover;
        @JsonProperty("public_images")
        private Boolean publicImages;
        @JsonProperty("album_privacy")
        private String albumPrivacy;
        @JsonProperty("pro_expiration")
        private Boolean proExpiration;
        @JsonProperty("accepted_gallery_terms")
        private Boolean acceptedGalleryTerms;
        @JsonProperty("active_emails")
        private List<String> activeEmails = new ArrayList<String>();
        @JsonProperty("messaging_enabled")
        private Boolean messagingEnabled;
        @JsonProperty("comment_replies")
        private Boolean commentReplies;
        @JsonProperty("blocked_users")
        private List<String> blockedUsers = new ArrayList<String>();
        @JsonProperty("show_mature")
        private Boolean showMature;
        @JsonProperty("newsletter_subscribed")
        private Boolean newsletterSubscribed;
        @JsonProperty("first_party")
        private Boolean firstParty;
    }
}
