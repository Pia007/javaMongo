package com.javadev.joblisting.models;

import org.springframework.data.mongodb.core.mapping.Document;

// Map the pojo to a collection in the db
@Document(collection = "JobPost")
public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String techs[];


    // constructor
    public Post() {
    }

    // getters and setters

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs= techs;
    }

    // toString

    @Override
    public String toString() {
        return "{" +
            " profile='" + getProfile() + "'" +
            ", desc='" + getDesc() + "'" +
            ", exp='" + getExp() + "'" +
            ", techs[]='" + getTechs() + "'" +
            ", getTechs[]='" + getTechs() + "'" +
            ", techs[]='" + getTechs() + "'" +
            "}";
    }

    
}
