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
public class Author {

    private int legacy_id;
    private String avatar_thumbnail_url;
    private String alias;
    private String avatar_url;
    private List<String> groups;
    private String id;
    public void setLegacy_id(int legacy_id) {
         this.legacy_id = legacy_id;
     }
     public int getLegacy_id() {
         return legacy_id;
     }

    public void setAvatar_thumbnail_url(String avatar_thumbnail_url) {
         this.avatar_thumbnail_url = avatar_thumbnail_url;
     }
     public String getAvatar_thumbnail_url() {
         return avatar_thumbnail_url;
     }

    public void setAlias(String alias) {
         this.alias = alias;
     }
     public String getAlias() {
         return alias;
     }

    public void setAvatar_url(String avatar_url) {
         this.avatar_url = avatar_url;
     }
     public String getAvatar_url() {
         return avatar_url;
     }

    public void setGroups(List<String> groups) {
         this.groups = groups;
     }
     public List<String> getGroups() {
         return groups;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

}