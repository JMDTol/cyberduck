/*
 * DRACOON
 * Version 4.4.0 - built at: 2017-12-04 04:14:43, API server: https://demo.dracoon.com/api/v4
 *
 * OpenAPI spec version: 4.4.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import ch.cyberduck.core.sds.io.swagger.client.model.ObjectExpiration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CreateUploadShareRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-03T10:55:56.129+02:00")
public class CreateUploadShareRequest {
  @JsonProperty("targetId")
  private Long targetId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("maxSlots")
  private Integer maxSlots = null;

  @JsonProperty("maxSize")
  private Long maxSize = null;

  @JsonProperty("expiration")
  private ObjectExpiration expiration = null;

  @JsonProperty("filesExpiryPeriod")
  private Integer filesExpiryPeriod = null;

  @JsonProperty("notes")
  private String notes = null;

  @JsonProperty("notifyCreator")
  private Boolean notifyCreator = null;

  @JsonProperty("sendMail")
  private Boolean sendMail = null;

  @JsonProperty("mailRecipients")
  private String mailRecipients = null;

  @JsonProperty("mailSubject")
  private String mailSubject = null;

  @JsonProperty("mailBody")
  private String mailBody = null;

  @JsonProperty("sendSms")
  private Boolean sendSms = null;

  @JsonProperty("smsRecipients")
  private String smsRecipients = null;

  @JsonProperty("showUploadedFiles")
  private Boolean showUploadedFiles = null;

  public CreateUploadShareRequest targetId(Long targetId) {
    this.targetId = targetId;
    return this;
  }

   /**
   * Target room or folder id
   * @return targetId
  **/
  @ApiModelProperty(required = true, value = "Target room or folder id")
  public Long getTargetId() {
    return targetId;
  }

  public void setTargetId(Long targetId) {
    this.targetId = targetId;
  }

  public CreateUploadShareRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Alias name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Alias name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateUploadShareRequest password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Password
   * @return password
  **/
  @ApiModelProperty(value = "Password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CreateUploadShareRequest maxSlots(Integer maxSlots) {
    this.maxSlots = maxSlots;
    return this;
  }

   /**
   * Maximal amount of files to upload
   * @return maxSlots
  **/
  @ApiModelProperty(value = "Maximal amount of files to upload")
  public Integer getMaxSlots() {
    return maxSlots;
  }

  public void setMaxSlots(Integer maxSlots) {
    this.maxSlots = maxSlots;
  }

  public CreateUploadShareRequest maxSize(Long maxSize) {
    this.maxSize = maxSize;
    return this;
  }

   /**
   * Maximal total size of uploaded files (Bytes)
   * @return maxSize
  **/
  @ApiModelProperty(value = "Maximal total size of uploaded files (Bytes)")
  public Long getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(Long maxSize) {
    this.maxSize = maxSize;
  }

  public CreateUploadShareRequest expiration(ObjectExpiration expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Upload share expiration.
   * @return expiration
  **/
  @ApiModelProperty(value = "Upload share expiration.")
  public ObjectExpiration getExpiration() {
    return expiration;
  }

  public void setExpiration(ObjectExpiration expiration) {
    this.expiration = expiration;
  }

  public CreateUploadShareRequest filesExpiryPeriod(Integer filesExpiryPeriod) {
    this.filesExpiryPeriod = filesExpiryPeriod;
    return this;
  }

   /**
   * Number of days after which uploaded files expire
   * @return filesExpiryPeriod
  **/
  @ApiModelProperty(value = "Number of days after which uploaded files expire")
  public Integer getFilesExpiryPeriod() {
    return filesExpiryPeriod;
  }

  public void setFilesExpiryPeriod(Integer filesExpiryPeriod) {
    this.filesExpiryPeriod = filesExpiryPeriod;
  }

  public CreateUploadShareRequest notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * User notes
   * @return notes
  **/
  @ApiModelProperty(value = "User notes")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public CreateUploadShareRequest notifyCreator(Boolean notifyCreator) {
    this.notifyCreator = notifyCreator;
    return this;
  }

   /**
   * Notify creator on every upload
   * @return notifyCreator
  **/
  @ApiModelProperty(value = "Notify creator on every upload")
  public Boolean getNotifyCreator() {
    return notifyCreator;
  }

  public void setNotifyCreator(Boolean notifyCreator) {
    this.notifyCreator = notifyCreator;
  }

  public CreateUploadShareRequest sendMail(Boolean sendMail) {
    this.sendMail = sendMail;
    return this;
  }

   /**
   * Notify recipients
   * @return sendMail
  **/
  @ApiModelProperty(value = "Notify recipients")
  public Boolean getSendMail() {
    return sendMail;
  }

  public void setSendMail(Boolean sendMail) {
    this.sendMail = sendMail;
  }

  public CreateUploadShareRequest mailRecipients(String mailRecipients) {
    this.mailRecipients = mailRecipients;
    return this;
  }

   /**
   * CSV string of recipient emails
   * @return mailRecipients
  **/
  @ApiModelProperty(value = "CSV string of recipient emails")
  public String getMailRecipients() {
    return mailRecipients;
  }

  public void setMailRecipients(String mailRecipients) {
    this.mailRecipients = mailRecipients;
  }

  public CreateUploadShareRequest mailSubject(String mailSubject) {
    this.mailSubject = mailSubject;
    return this;
  }

   /**
   * Notification email subject
   * @return mailSubject
  **/
  @ApiModelProperty(value = "Notification email subject")
  public String getMailSubject() {
    return mailSubject;
  }

  public void setMailSubject(String mailSubject) {
    this.mailSubject = mailSubject;
  }

  public CreateUploadShareRequest mailBody(String mailBody) {
    this.mailBody = mailBody;
    return this;
  }

   /**
   * Notification email content
   * @return mailBody
  **/
  @ApiModelProperty(value = "Notification email content")
  public String getMailBody() {
    return mailBody;
  }

  public void setMailBody(String mailBody) {
    this.mailBody = mailBody;
  }

  public CreateUploadShareRequest sendSms(Boolean sendSms) {
    this.sendSms = sendSms;
    return this;
  }

   /**
   * Send Share password via SMS
   * @return sendSms
  **/
  @ApiModelProperty(value = "Send Share password via SMS")
  public Boolean getSendSms() {
    return sendSms;
  }

  public void setSendSms(Boolean sendSms) {
    this.sendSms = sendSms;
  }

  public CreateUploadShareRequest smsRecipients(String smsRecipients) {
    this.smsRecipients = smsRecipients;
    return this;
  }

   /**
   * Comma-separated list of SMS receivers
   * @return smsRecipients
  **/
  @ApiModelProperty(value = "Comma-separated list of SMS receivers")
  public String getSmsRecipients() {
    return smsRecipients;
  }

  public void setSmsRecipients(String smsRecipients) {
    this.smsRecipients = smsRecipients;
  }

  public CreateUploadShareRequest showUploadedFiles(Boolean showUploadedFiles) {
    this.showUploadedFiles = showUploadedFiles;
    return this;
  }

   /**
   * Allow display of already uploaded files
   * @return showUploadedFiles
  **/
  @ApiModelProperty(value = "Allow display of already uploaded files")
  public Boolean getShowUploadedFiles() {
    return showUploadedFiles;
  }

  public void setShowUploadedFiles(Boolean showUploadedFiles) {
    this.showUploadedFiles = showUploadedFiles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUploadShareRequest createUploadShareRequest = (CreateUploadShareRequest) o;
    return Objects.equals(this.targetId, createUploadShareRequest.targetId) &&
        Objects.equals(this.name, createUploadShareRequest.name) &&
        Objects.equals(this.password, createUploadShareRequest.password) &&
        Objects.equals(this.maxSlots, createUploadShareRequest.maxSlots) &&
        Objects.equals(this.maxSize, createUploadShareRequest.maxSize) &&
        Objects.equals(this.expiration, createUploadShareRequest.expiration) &&
        Objects.equals(this.filesExpiryPeriod, createUploadShareRequest.filesExpiryPeriod) &&
        Objects.equals(this.notes, createUploadShareRequest.notes) &&
        Objects.equals(this.notifyCreator, createUploadShareRequest.notifyCreator) &&
        Objects.equals(this.sendMail, createUploadShareRequest.sendMail) &&
        Objects.equals(this.mailRecipients, createUploadShareRequest.mailRecipients) &&
        Objects.equals(this.mailSubject, createUploadShareRequest.mailSubject) &&
        Objects.equals(this.mailBody, createUploadShareRequest.mailBody) &&
        Objects.equals(this.sendSms, createUploadShareRequest.sendSms) &&
        Objects.equals(this.smsRecipients, createUploadShareRequest.smsRecipients) &&
        Objects.equals(this.showUploadedFiles, createUploadShareRequest.showUploadedFiles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetId, name, password, maxSlots, maxSize, expiration, filesExpiryPeriod, notes, notifyCreator, sendMail, mailRecipients, mailSubject, mailBody, sendSms, smsRecipients, showUploadedFiles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUploadShareRequest {\n");
    
    sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    maxSlots: ").append(toIndentedString(maxSlots)).append("\n");
    sb.append("    maxSize: ").append(toIndentedString(maxSize)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    filesExpiryPeriod: ").append(toIndentedString(filesExpiryPeriod)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    notifyCreator: ").append(toIndentedString(notifyCreator)).append("\n");
    sb.append("    sendMail: ").append(toIndentedString(sendMail)).append("\n");
    sb.append("    mailRecipients: ").append(toIndentedString(mailRecipients)).append("\n");
    sb.append("    mailSubject: ").append(toIndentedString(mailSubject)).append("\n");
    sb.append("    mailBody: ").append(toIndentedString(mailBody)).append("\n");
    sb.append("    sendSms: ").append(toIndentedString(sendSms)).append("\n");
    sb.append("    smsRecipients: ").append(toIndentedString(smsRecipients)).append("\n");
    sb.append("    showUploadedFiles: ").append(toIndentedString(showUploadedFiles)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}
