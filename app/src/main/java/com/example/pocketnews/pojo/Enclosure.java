package com.example.pocketnews.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "enclosure ", strict = false)
public class Enclosure {
    @Attribute(name = "type", required = false)
    private String type;
    @Attribute(name = "url", required = false)
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
