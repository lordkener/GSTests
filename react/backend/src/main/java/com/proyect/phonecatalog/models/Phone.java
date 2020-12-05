package com.proyect.phonecatalog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Phone{  
    public interface MainInfo{}
    public interface PhoneDetails{}

    @JsonView({MainInfo.class, PhoneDetails.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView({MainInfo.class, PhoneDetails.class})
    private String name;

    @JsonView(PhoneDetails.class)
    private String manufacturer;

    @JsonView(PhoneDetails.class)
    @Column(length = 512)
    private String description;

    @JsonView(PhoneDetails.class)
    private String color;

    @JsonView({MainInfo.class, PhoneDetails.class})
    private int price;

    @JsonView({MainInfo.class, PhoneDetails.class})
    private String imageFileName;

    @JsonView(PhoneDetails.class)
    private String screen;

    @JsonView(PhoneDetails.class)
    private String processor;

    @JsonView(PhoneDetails.class)
    private int ram;

    @Lob
    private byte[] mainImage;

    //Empty contructor
    public Phone(){}

    //Constructor with all atributes
    public Phone(String name, String manufacturer, String description, String color, int price,
            String imageFileName, String screen, String processor, int ram, byte[] mainImage) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.color = color;
        this.price = price;
        this.imageFileName = imageFileName;
        this.screen = screen;
        this.processor = processor;
        this.ram = ram;
        this.mainImage = mainImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public byte[] getMainImage() {
        return mainImage;
    }

    public void setMainImage(byte[] mainImage) {
        this.mainImage = mainImage;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", description=" + description +
                ", color=" + color +
                ", price=" + price +
                ", imageFileName=" + imageFileName +
                ", screen=" + screen +
                ", processor=" + processor +
                ", ram=" + ram +
                '}';
    }

}