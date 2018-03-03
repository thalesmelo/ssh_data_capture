package com.dataCapture.model;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ObserverBean {

    /**
     * attachments : []
     * author : {"alias":"blondie14225","groups":[],"id":"9df754fc-4ebe-4b86-8ca2-34fbfb0d374a","legacy_id":1722}
     * author_id : 9df754fc-4ebe-4b86-8ca2-34fbfb0d374a
     * censored_replies_count : 0
     * censored_replies_count_descendants : 0
     * comment : <p>great update love it</p>
     * content_uuid : 28b12835-ae46-49e3-80f6-b3958ceea96e
     * created_at : 1.508062844666616E9
     * id : fd319e05-4e69-47f9-a85d-99c9e4fa3782
     * in_reply_to_uuid : null
     * legacy_id : 6048
     * locked : false
     * replies_count : 0
     * replies_count_descendants : 0
     * thread_uuid : f7ae4336-0990-4fd2-acfd-0c0107c7b32d
     * updated_at : 1.508062844666623E9
     * user_vote : {"count":0,"sum":0,"value":null}
     */

    private AuthorBean author;
    private String author_id;
    private int censored_replies_count;
    private int censored_replies_count_descendants;
    private String comment;
    private String content_uuid;
    private double created_at;
    private String id;
    private Object in_reply_to_uuid;
    private int legacy_id;
    private boolean locked;
    private int replies_count;
    private int replies_count_descendants;
    private String thread_uuid;
    private double updated_at;
    private UserVoteBean user_vote;
    private List<String> attachments;

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public int getCensored_replies_count() {
        return censored_replies_count;
    }

    public void setCensored_replies_count(int censored_replies_count) {
        this.censored_replies_count = censored_replies_count;
    }

    public int getCensored_replies_count_descendants() {
        return censored_replies_count_descendants;
    }

    public void setCensored_replies_count_descendants(int censored_replies_count_descendants) {
        this.censored_replies_count_descendants = censored_replies_count_descendants;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContent_uuid() {
        return content_uuid;
    }

    public void setContent_uuid(String content_uuid) {
        this.content_uuid = content_uuid;
    }

    public double getCreated_at() {
        return created_at;
    }

    public void setCreated_at(double created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getIn_reply_to_uuid() {
        return in_reply_to_uuid;
    }

    public void setIn_reply_to_uuid(Object in_reply_to_uuid) {
        this.in_reply_to_uuid = in_reply_to_uuid;
    }

    public int getLegacy_id() {
        return legacy_id;
    }

    public void setLegacy_id(int legacy_id) {
        this.legacy_id = legacy_id;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getReplies_count() {
        return replies_count;
    }

    public void setReplies_count(int replies_count) {
        this.replies_count = replies_count;
    }

    public int getReplies_count_descendants() {
        return replies_count_descendants;
    }

    public void setReplies_count_descendants(int replies_count_descendants) {
        this.replies_count_descendants = replies_count_descendants;
    }

    public String getThread_uuid() {
        return thread_uuid;
    }

    public void setThread_uuid(String thread_uuid) {
        this.thread_uuid = thread_uuid;
    }

    public double getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(double updated_at) {
        this.updated_at = updated_at;
    }

    public UserVoteBean getUser_vote() {
        return user_vote;
    }

    public void setUser_vote(UserVoteBean user_vote) {
        this.user_vote = user_vote;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public static class AuthorBean {
        /**
         * alias : blondie14225
         * groups : []
         * id : 9df754fc-4ebe-4b86-8ca2-34fbfb0d374a
         * legacy_id : 1722
         */

        private String alias;
        private String id;
        private int legacy_id;
        private List<?> groups;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getLegacy_id() {
            return legacy_id;
        }

        public void setLegacy_id(int legacy_id) {
            this.legacy_id = legacy_id;
        }

        public List<?> getGroups() {
            return groups;
        }

        public void setGroups(List<?> groups) {
            this.groups = groups;
        }
    }

    public static class UserVoteBean {
        /**
         * count : 0
         * sum : 0
         * value : null
         */

        private int count;
        private int sum;
        private Object value;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
