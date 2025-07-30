package org.acme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public class Book {

    @NotBlank(message = "Title may not be blank")
    public String title;

    @NotBlank(message = "Author may not be blank")
    public String author;

    @Min(message = "Author has been very lazy", value = 1)
    public double pages;

    @EvenPages(message = "Number of pages must be even")
    @Min(message = "Book must have at least 2 pages", value = 2)
    @NotBlank(message = "Even pages must be specified")
    public int evenPages;
}