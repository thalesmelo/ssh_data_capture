package com.dataCapture.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月15日
 *
 * @TIME 上午10:15:39
 */
@Entity
public class Activity {

	public Integer Id;

	/// 唯一

	public String UUID;

	/// 创建日期

	public Date CreateDateTime;

	/// 是否删除

	public Boolean IsDeleted;

	// 活动类型（1-Activity，2-Disscusion，3-Poll，4-QuickQuestion，5-Quiz，6-Survey）

	public Integer ActivityType;

	// 活动标题

	public String Title;

	// 所属网站(1-Team,2-Elevate,3-Champion)

	public Integer WebsiteName;

	// 活动状态(0-草稿,1-发布,2-结束，3-测试)

	public Integer Status;

	// 种类

	public Integer Category;

	// 活动开始日期

	public Date StartDate;

	// 活动结束日期

	public Date EndDate;

	// 活动描述

	public String Description;

	// 头部图片地址

	public String HeaderImageUrl;

	// 标题图片地址

	public String TitleImageUrl;

	// 评论设置级别（1-私人级别，不能被作者或其他人访问，且只能评论一次，2-公开级别，可以被作者和其他人访问，并且不限制评论次数，3-完全私人级别，仅限提交数据，提交的内容不能被作者或其他人访问，且搜索引擎不会搜索到这种级别的内容，4-仅限作者看得到提交的内容，5-所有人都可以查看）

	public Integer CommonType;

	// 是否允许评论

	public Boolean AllowComment;

	// 每个用户最大评论数量

	public Integer MaxCommnet;

	// 投票类型

	public Integer VotingType;

	// 访问级别（1-所有人可以访问，2-只允许部分用户组可以访问）

	public Integer VisibleLevel;

	// 访问级别（可以访问用户组名称）

	public String VisibleLevelName;

	// 评论等级（1-所有人可以访问，2-只允许部分用户组可以访问）

	public String CommentLevel;

	// 访问级别（可以访问用户组名称）

	public String CommentLevelName;

	// 是否显示该评论设置了访问限制

	public Boolean ShowLockImg;

	// 活动标签

	public String ActivityTag;

	// 指定访问人

	public String Managers;

	// 讨论类型

	public String DisscusionTaxonomy;

	// 分类文字

	public String TaxonomyLabel;

	// 分类辅助提示文字

	public String TaxonomyHelpText;

	// 标题文字

	public String TitleLabel;

	// 标题辅助提示文字

	public String TitleHelpText;

	// 是否包含特色图片

	public Boolean IsIncludeFeaturedImage;

	// 特色图片文字

	public String FeaturedImageLabel;

	// 特色图片辅助提示文字

	public String FeaturedImageHelpText;

	// 是否包含主要内容

	public Boolean IsIncludeBody;

	// 主要内容文字

	public String BodyLabel;

	// 主要内容辅助提示文字

	public String BodyHelpText;

	// 是否包含上传图片

	public Boolean IsIncludeImageUpload;

	// 上传图片文字

	public String ImageUploadLabel;

	// 上传图片辅助提示文字

	public String ImageUploadHelpText;

	// 是否包含上传文件

	public Boolean IsIncludeDocumentUpload;

	// 上传文件文字

	public String DocumentUploadLabel;

	// 上传文件辅助提示文字

	public String DocumentUploadHelpText;

	// 是否包含标签

	public Boolean IsIncludeTag;

	// 标签文字

	public String TagLabel;

	// 标签辅助提示文字

	public String TagHelpText;

	// 显示风格

	public Integer DisplayStyle;

	// 按钮文字

	public String ButtonText;

	// 编辑日期

	public Date ModifyDate;

	// 编辑用户ID

	public String ModifyUserId;

	// 问答表单

	public String QuestionForm;

	// 是否推荐

	public Boolean Feature;

	// 排序

	public Integer Sort;

	// 正确答案

	public String RightAnswer;

	// 模板内容

	public String Htmls;
	
	public Integer PersonNum;
	
	public Integer PostNum;
	
	public Integer CommonNum;
	

	/**
	 * @return the id
	 */
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the createDateTime
	 */
	public Date getCreateDateTime() {
		return CreateDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		CreateDateTime = createDateTime;
	}

	/**
	 * @return the isDeleted
	 */
	public Boolean getIsDeleted() {
		return IsDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		IsDeleted = isDeleted;
	}

	/**
	 * @return the activityType
	 */
	public Integer getActivityType() {
		return ActivityType;
	}

	/**
	 * @param activityType
	 *            the activityType to set
	 */
	public void setActivityType(Integer activityType) {
		ActivityType = activityType;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the websiteName
	 */
	public Integer getWebsiteName() {
		return WebsiteName;
	}

	/**
	 * @param websiteName
	 *            the websiteName to set
	 */
	public void setWebsiteName(Integer websiteName) {
		WebsiteName = websiteName;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return Status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		Status = status;
	}

	/**
	 * @return the category
	 */
	public Integer getCategory() {
		return Category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Integer category) {
		Category = category;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return StartDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return EndDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the headerImageUrl
	 */
	public String getHeaderImageUrl() {
		return HeaderImageUrl;
	}

	/**
	 * @param headerImageUrl
	 *            the headerImageUrl to set
	 */
	public void setHeaderImageUrl(String headerImageUrl) {
		HeaderImageUrl = headerImageUrl;
	}

	/**
	 * @return the titleImageUrl
	 */
	public String getTitleImageUrl() {
		return TitleImageUrl;
	}

	/**
	 * @param titleImageUrl
	 *            the titleImageUrl to set
	 */
	public void setTitleImageUrl(String titleImageUrl) {
		TitleImageUrl = titleImageUrl;
	}

	/**
	 * @return the commonType
	 */
	public Integer getCommonType() {
		return CommonType;
	}

	/**
	 * @param commonType
	 *            the commonType to set
	 */
	public void setCommonType(Integer commonType) {
		CommonType = commonType;
	}

	/**
	 * @return the allowComment
	 */
	public Boolean getAllowComment() {
		return AllowComment;
	}

	/**
	 * @param allowComment
	 *            the allowComment to set
	 */
	public void setAllowComment(Boolean allowComment) {
		AllowComment = allowComment;
	}

	/**
	 * @return the maxCommnet
	 */
	public Integer getMaxCommnet() {
		return MaxCommnet;
	}

	/**
	 * @param maxCommnet
	 *            the maxCommnet to set
	 */
	public void setMaxCommnet(Integer maxCommnet) {
		MaxCommnet = maxCommnet;
	}

	/**
	 * @return the votingType
	 */
	public Integer getVotingType() {
		return VotingType;
	}

	/**
	 * @param votingType
	 *            the votingType to set
	 */
	public void setVotingType(Integer votingType) {
		VotingType = votingType;
	}

	/**
	 * @return the visibleLevel
	 */
	public Integer getVisibleLevel() {
		return VisibleLevel;
	}

	/**
	 * @param visibleLevel
	 *            the visibleLevel to set
	 */
	public void setVisibleLevel(Integer visibleLevel) {
		VisibleLevel = visibleLevel;
	}

	/**
	 * @return the visibleLevelName
	 */
	public String getVisibleLevelName() {
		return VisibleLevelName;
	}

	/**
	 * @param visibleLevelName
	 *            the visibleLevelName to set
	 */
	public void setVisibleLevelName(String visibleLevelName) {
		VisibleLevelName = visibleLevelName;
	}

	/**
	 * @return the commentLevel
	 */
	public String getCommentLevel() {
		return CommentLevel;
	}

	/**
	 * @param commentLevel
	 *            the commentLevel to set
	 */
	public void setCommentLevel(String commentLevel) {
		CommentLevel = commentLevel;
	}

	/**
	 * @return the commentLevelName
	 */
	public String getCommentLevelName() {
		return CommentLevelName;
	}

	/**
	 * @param commentLevelName
	 *            the commentLevelName to set
	 */
	public void setCommentLevelName(String commentLevelName) {
		CommentLevelName = commentLevelName;
	}

	/**
	 * @return the showLockImg
	 */
	public Boolean getShowLockImg() {
		return ShowLockImg;
	}

	/**
	 * @param showLockImg
	 *            the showLockImg to set
	 */
	public void setShowLockImg(Boolean showLockImg) {
		ShowLockImg = showLockImg;
	}

	/**
	 * @return the activityTag
	 */
	public String getActivityTag() {
		return ActivityTag;
	}

	/**
	 * @param activityTag
	 *            the activityTag to set
	 */
	public void setActivityTag(String activityTag) {
		ActivityTag = activityTag;
	}

	/**
	 * @return the managers
	 */
	public String getManagers() {
		return Managers;
	}

	/**
	 * @param managers
	 *            the managers to set
	 */
	public void setManagers(String managers) {
		Managers = managers;
	}

	/**
	 * @return the disscusionTaxonomy
	 */
	public String getDisscusionTaxonomy() {
		return DisscusionTaxonomy;
	}

	/**
	 * @param disscusionTaxonomy
	 *            the disscusionTaxonomy to set
	 */
	public void setDisscusionTaxonomy(String disscusionTaxonomy) {
		DisscusionTaxonomy = disscusionTaxonomy;
	}

	/**
	 * @return the taxonomyLabel
	 */
	public String getTaxonomyLabel() {
		return TaxonomyLabel;
	}

	/**
	 * @param taxonomyLabel
	 *            the taxonomyLabel to set
	 */
	public void setTaxonomyLabel(String taxonomyLabel) {
		TaxonomyLabel = taxonomyLabel;
	}

	/**
	 * @return the taxonomyHelpText
	 */
	public String getTaxonomyHelpText() {
		return TaxonomyHelpText;
	}

	/**
	 * @param taxonomyHelpText
	 *            the taxonomyHelpText to set
	 */
	public void setTaxonomyHelpText(String taxonomyHelpText) {
		TaxonomyHelpText = taxonomyHelpText;
	}

	/**
	 * @return the titleLabel
	 */
	public String getTitleLabel() {
		return TitleLabel;
	}

	/**
	 * @param titleLabel
	 *            the titleLabel to set
	 */
	public void setTitleLabel(String titleLabel) {
		TitleLabel = titleLabel;
	}

	/**
	 * @return the titleHelpText
	 */
	public String getTitleHelpText() {
		return TitleHelpText;
	}

	/**
	 * @param titleHelpText
	 *            the titleHelpText to set
	 */
	public void setTitleHelpText(String titleHelpText) {
		TitleHelpText = titleHelpText;
	}

	/**
	 * @return the isIncludeFeaturedImage
	 */
	public Boolean getIsIncludeFeaturedImage() {
		return IsIncludeFeaturedImage;
	}

	/**
	 * @param isIncludeFeaturedImage
	 *            the isIncludeFeaturedImage to set
	 */
	public void setIsIncludeFeaturedImage(Boolean isIncludeFeaturedImage) {
		IsIncludeFeaturedImage = isIncludeFeaturedImage;
	}

	/**
	 * @return the featuredImageLabel
	 */
	public String getFeaturedImageLabel() {
		return FeaturedImageLabel;
	}

	/**
	 * @param featuredImageLabel
	 *            the featuredImageLabel to set
	 */
	public void setFeaturedImageLabel(String featuredImageLabel) {
		FeaturedImageLabel = featuredImageLabel;
	}

	/**
	 * @return the featuredImageHelpText
	 */
	public String getFeaturedImageHelpText() {
		return FeaturedImageHelpText;
	}

	/**
	 * @param featuredImageHelpText
	 *            the featuredImageHelpText to set
	 */
	public void setFeaturedImageHelpText(String featuredImageHelpText) {
		FeaturedImageHelpText = featuredImageHelpText;
	}

	/**
	 * @return the isIncludeBody
	 */
	public Boolean getIsIncludeBody() {
		return IsIncludeBody;
	}

	/**
	 * @param isIncludeBody
	 *            the isIncludeBody to set
	 */
	public void setIsIncludeBody(Boolean isIncludeBody) {
		IsIncludeBody = isIncludeBody;
	}

	/**
	 * @return the bodyLabel
	 */
	public String getBodyLabel() {
		return BodyLabel;
	}

	/**
	 * @param bodyLabel
	 *            the bodyLabel to set
	 */
	public void setBodyLabel(String bodyLabel) {
		BodyLabel = bodyLabel;
	}

	/**
	 * @return the bodyHelpText
	 */
	public String getBodyHelpText() {
		return BodyHelpText;
	}

	/**
	 * @param bodyHelpText
	 *            the bodyHelpText to set
	 */
	public void setBodyHelpText(String bodyHelpText) {
		BodyHelpText = bodyHelpText;
	}

	/**
	 * @return the isIncludeImageUpload
	 */
	public Boolean getIsIncludeImageUpload() {
		return IsIncludeImageUpload;
	}

	/**
	 * @param isIncludeImageUpload
	 *            the isIncludeImageUpload to set
	 */
	public void setIsIncludeImageUpload(Boolean isIncludeImageUpload) {
		IsIncludeImageUpload = isIncludeImageUpload;
	}

	/**
	 * @return the imageUploadLabel
	 */
	public String getImageUploadLabel() {
		return ImageUploadLabel;
	}

	/**
	 * @param imageUploadLabel
	 *            the imageUploadLabel to set
	 */
	public void setImageUploadLabel(String imageUploadLabel) {
		ImageUploadLabel = imageUploadLabel;
	}

	/**
	 * @return the imageUploadHelpText
	 */
	public String getImageUploadHelpText() {
		return ImageUploadHelpText;
	}

	/**
	 * @param imageUploadHelpText
	 *            the imageUploadHelpText to set
	 */
	public void setImageUploadHelpText(String imageUploadHelpText) {
		ImageUploadHelpText = imageUploadHelpText;
	}

	/**
	 * @return the isIncludeDocumentUpload
	 */
	public Boolean getIsIncludeDocumentUpload() {
		return IsIncludeDocumentUpload;
	}

	/**
	 * @param isIncludeDocumentUpload
	 *            the isIncludeDocumentUpload to set
	 */
	public void setIsIncludeDocumentUpload(Boolean isIncludeDocumentUpload) {
		IsIncludeDocumentUpload = isIncludeDocumentUpload;
	}

	/**
	 * @return the documentUploadLabel
	 */
	public String getDocumentUploadLabel() {
		return DocumentUploadLabel;
	}

	/**
	 * @param documentUploadLabel
	 *            the documentUploadLabel to set
	 */
	public void setDocumentUploadLabel(String documentUploadLabel) {
		DocumentUploadLabel = documentUploadLabel;
	}

	/**
	 * @return the documentUploadHelpText
	 */
	public String getDocumentUploadHelpText() {
		return DocumentUploadHelpText;
	}

	/**
	 * @param documentUploadHelpText
	 *            the documentUploadHelpText to set
	 */
	public void setDocumentUploadHelpText(String documentUploadHelpText) {
		DocumentUploadHelpText = documentUploadHelpText;
	}

	/**
	 * @return the isIncludeTag
	 */
	public Boolean getIsIncludeTag() {
		return IsIncludeTag;
	}

	/**
	 * @param isIncludeTag
	 *            the isIncludeTag to set
	 */
	public void setIsIncludeTag(Boolean isIncludeTag) {
		IsIncludeTag = isIncludeTag;
	}

	/**
	 * @return the tagLabel
	 */
	public String getTagLabel() {
		return TagLabel;
	}

	/**
	 * @param tagLabel
	 *            the tagLabel to set
	 */
	public void setTagLabel(String tagLabel) {
		TagLabel = tagLabel;
	}

	/**
	 * @return the tagHelpText
	 */
	public String getTagHelpText() {
		return TagHelpText;
	}

	/**
	 * @param tagHelpText
	 *            the tagHelpText to set
	 */
	public void setTagHelpText(String tagHelpText) {
		TagHelpText = tagHelpText;
	}

	/**
	 * @return the displayStyle
	 */
	public Integer getDisplayStyle() {
		return DisplayStyle;
	}

	/**
	 * @param displayStyle
	 *            the displayStyle to set
	 */
	public void setDisplayStyle(Integer displayStyle) {
		DisplayStyle = displayStyle;
	}

	/**
	 * @return the buttonText
	 */
	public String getButtonText() {
		return ButtonText;
	}

	/**
	 * @param buttonText
	 *            the buttonText to set
	 */
	public void setButtonText(String buttonText) {
		ButtonText = buttonText;
	}

	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return ModifyDate;
	}

	/**
	 * @param modifyDate
	 *            the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		ModifyDate = modifyDate;
	}

	/**
	 * @return the modifyUserId
	 */
	public String getModifyUserId() {
		return ModifyUserId;
	}

	/**
	 * @param modifyUserId
	 *            the modifyUserId to set
	 */
	public void setModifyUserId(String modifyUserId) {
		ModifyUserId = modifyUserId;
	}

	/**
	 * @return the questionForm
	 */
	public String getQuestionForm() {
		return QuestionForm;
	}

	/**
	 * @param questionForm
	 *            the questionForm to set
	 */
	public void setQuestionForm(String questionForm) {
		QuestionForm = questionForm;
	}

	/**
	 * @return the feature
	 */
	public Boolean getFeature() {
		return Feature;
	}

	/**
	 * @param feature
	 *            the feature to set
	 */
	public void setFeature(Boolean feature) {
		Feature = feature;
	}

	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return Sort;
	}

	/**
	 * @param sort
	 *            the sort to set
	 */
	public void setSort(Integer sort) {
		Sort = sort;
	}

	/**
	 * @return the rightAnswer
	 */
	public String getRightAnswer() {
		return RightAnswer;
	}

	/**
	 * @param rightAnswer
	 *            the rightAnswer to set
	 */
	public void setRightAnswer(String rightAnswer) {
		RightAnswer = rightAnswer;
	}

	/**
	 * @return the htmls
	 */
	public String getHtmls() {
		return Htmls;
	}

	/**
	 * @param htmls
	 *            the htmls to set
	 */
	public void setHtmls(String htmls) {
		Htmls = htmls;
	}


	/**
	 * @return the personNum
	 */
	public Integer getPersonNum() {
		return PersonNum;
	}

	/**
	 * @param personNum the personNum to set
	 */
	public void setPersonNum(Integer personNum) {
		PersonNum = personNum;
	}

	/**
	 * @return the postNum
	 */
	public Integer getPostNum() {
		return PostNum;
	}

	/**
	 * @param postNum the postNum to set
	 */
	public void setPostNum(Integer postNum) {
		PostNum = postNum;
	}

	/**
	 * @return the commonNum
	 */
	public Integer getCommonNum() {
		return CommonNum;
	}

	/**
	 * @param commonNum the commonNum to set
	 */
	public void setCommonNum(Integer commonNum) {
		CommonNum = commonNum;
	}

	@Override
	public String toString() {
		return "Activity [Id=" + Id + ", UUID=" + UUID + ", CreateDateTime=" + CreateDateTime + ", IsDeleted="
				+ IsDeleted + ", ActivityType=" + ActivityType + ", Title=" + Title + ", WebsiteName=" + WebsiteName
				+ ", Status=" + Status + ", Category=" + Category + ", StartDate=" + StartDate + ", EndDate=" + EndDate
				+ ", Description=" + Description + ", HeaderImageUrl=" + HeaderImageUrl + ", TitleImageUrl="
				+ TitleImageUrl + ", CommonType=" + CommonType + ", AllowComment=" + AllowComment + ", MaxCommnet="
				+ MaxCommnet + ", VotingType=" + VotingType + ", VisibleLevel=" + VisibleLevel + ", VisibleLevelName="
				+ VisibleLevelName + ", CommentLevel=" + CommentLevel + ", CommentLevelName=" + CommentLevelName
				+ ", ShowLockImg=" + ShowLockImg + ", ActivityTag=" + ActivityTag + ", Managers=" + Managers
				+ ", DisscusionTaxonomy=" + DisscusionTaxonomy + ", TaxonomyLabel=" + TaxonomyLabel
				+ ", TaxonomyHelpText=" + TaxonomyHelpText + ", TitleLabel=" + TitleLabel + ", TitleHelpText="
				+ TitleHelpText + ", IsIncludeFeaturedImage=" + IsIncludeFeaturedImage + ", FeaturedImageLabel="
				+ FeaturedImageLabel + ", FeaturedImageHelpText=" + FeaturedImageHelpText + ", IsIncludeBody="
				+ IsIncludeBody + ", BodyLabel=" + BodyLabel + ", BodyHelpText=" + BodyHelpText
				+ ", IsIncludeImageUpload=" + IsIncludeImageUpload + ", ImageUploadLabel=" + ImageUploadLabel
				+ ", ImageUploadHelpText=" + ImageUploadHelpText + ", IsIncludeDocumentUpload="
				+ IsIncludeDocumentUpload + ", DocumentUploadLabel=" + DocumentUploadLabel + ", DocumentUploadHelpText="
				+ DocumentUploadHelpText + ", IsIncludeTag=" + IsIncludeTag + ", TagLabel=" + TagLabel
				+ ", TagHelpText=" + TagHelpText + ", DisplayStyle=" + DisplayStyle + ", ButtonText=" + ButtonText
				+ ", ModifyDate=" + ModifyDate + ", ModifyUserId=" + ModifyUserId + ", QuestionForm=" + QuestionForm
				+ ", Feature=" + Feature + ", Sort=" + Sort + ", RightAnswer=" + RightAnswer + ", Htmls=" + Htmls
				+ ", PersonNum=" + PersonNum + ", PostNum=" + PostNum + ", CommonNum=" + CommonNum + "]";
	}

	
}
