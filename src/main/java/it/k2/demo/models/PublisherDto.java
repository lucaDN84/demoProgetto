package it.k2.demo.models;

public class PublisherDto
{
    private String name;

    public PublisherDto() {}

    public PublisherDto(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
