/**
  * Copyright 2018 bejson.com 
  */
package com.dataCapture.model;
import java.util.List;

/**
 * Auto-generated: 2018-01-15 19:25:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Results {

    private String comment;
    private int censored_replies_count;
    private int censored_replies_count_descendants;
    private List<String> attachments;
    private String content_uuid;
    private long created_at;
    private Author author;
    private long updated_at;
    private User_vote user_vote;
    private int legacy_id;
    private int replies_count_descendants;
    private int replies_count;
    private String author_id;
    private In_reply_to in_reply_to;
    private String thread_id;
    private String thread_uuid;
    private String id;
    
    
    /**
	 * @return the thread_uuid
	 */
	public String getThread_uuid() {
		return thread_uuid;
	}
	/**
	 * @param thread_uuid the thread_uuid to set
	 */
	public void setThread_uuid(String thread_uuid) {
		this.thread_uuid = thread_uuid;
	}
	public void setComment(String comment) {
         this.comment = comment;
     }
     public String getComment() {
         return comment;
     }

    public void setCensored_replies_count(int censored_replies_count) {
         this.censored_replies_count = censored_replies_count;
     }
     public int getCensored_replies_count() {
         return censored_replies_count;
     }

    public void setCensored_replies_count_descendants(int censored_replies_count_descendants) {
         this.censored_replies_count_descendants = censored_replies_count_descendants;
     }
     public int getCensored_replies_count_descendants() {
         return censored_replies_count_descendants;
     }

    public void setAttachments(List<String> attachments) {
         this.attachments = attachments;
     }
     public List<String> getAttachments() {
         return attachments;
     }

    public void setContent_uuid(String content_uuid) {
         this.content_uuid = content_uuid;
     }
     public String getContent_uuid() {
         return content_uuid;
     }

    public void setCreated_at(long created_at) {
         this.created_at = created_at;
     }
     public long getCreated_at() {
         return created_at;
     }

    public void setAuthor(Author author) {
         this.author = author;
     }
     public Author getAuthor() {
         return author;
     }

    public void setUpdated_at(long updated_at) {
         this.updated_at = updated_at;
     }
     public long getUpdated_at() {
         return updated_at;
     }

    public void setUser_vote(User_vote user_vote) {
         this.user_vote = user_vote;
     }
     public User_vote getUser_vote() {
         return user_vote;
     }

    public void setLegacy_id(int legacy_id) {
         this.legacy_id = legacy_id;
     }
     public int getLegacy_id() {
         return legacy_id;
     }

    public void setReplies_count_descendants(int replies_count_descendants) {
         this.replies_count_descendants = replies_count_descendants;
     }
     public int getReplies_count_descendants() {
         return replies_count_descendants;
     }

    public void setReplies_count(int replies_count) {
         this.replies_count = replies_count;
     }
     public int getReplies_count() {
         return replies_count;
     }

    public void setAuthor_id(String author_id) {
         this.author_id = author_id;
     }
     public String getAuthor_id() {
         return author_id;
     }

    public void setIn_reply_to(In_reply_to in_reply_to) {
         this.in_reply_to = in_reply_to;
     }
     public In_reply_to getIn_reply_to() {
         return in_reply_to;
     }

    public void setThread_id(String thread_id) {
         this.thread_id = thread_id;
     }
     public String getThread_id() {
         return thread_id;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

}