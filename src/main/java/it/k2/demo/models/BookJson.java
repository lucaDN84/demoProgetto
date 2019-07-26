package it.k2.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class BookJson {

    private String title;
    private Double price;
    private Integer quantity;
    private String genreDto;
    private String publisherDto;
    private String authorsDto;


    public BookJson() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getGenreDto() {
        return genreDto;
    }

    public void setGenreDto(String genreDto) {
        this.genreDto = genreDto;
    }

    public String getPublisherDto() {
        return publisherDto;
    }

    public void setPublisherDto(String publisherDto) {
        this.publisherDto = publisherDto;
    }

    public String getAuthorsDto() {
        return authorsDto;
    }

    public void setAuthorsDto(String authorsDto) {
        this.authorsDto = authorsDto;
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("title:"+title)
            .append("price:"+price)
            .append("quantity:"+quantity)
            .append("genreDto:"+genreDto)
            .append("publisherDto:"+publisherDto)
            .append("authorDto:"+authorsDto)
            .toString();
    }
}
