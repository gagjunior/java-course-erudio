package br.com.gagjunior.book.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;
    private String currency;
    private String environment;
}
