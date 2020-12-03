package com.proyect.instarecipes.views;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.proyect.instarecipes.repositories.PhonesRepository;
import com.proyect.instarecipes.models.Phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase {

    @Autowired
    private PhonesRepository phonesRepository;

    @PostConstruct
    private void initDatabase() throws IOException {

        // Phone examples

        String description0 = "A little more than half a year after the Redmi Note 7 and Redmi Note 7 Pro come these renovations that maintain some design features, although they differ especially in the back. Both the Redmi Note 8 and the Pro keep the notch in the shape of a U, but the Pro integrates a 6.53-inch panel and according to the brand it achieves 91.4% use of the front by the screen.";
        String description1 = "A camera so good that it deserves unlimited storage. Capture all the details and access all your photos on any device. Take professional photos with the HDR + function built into Instagram, 10 WhatsApp and Snapchat. Integrated functions to use Google in a personalized way. Take a selfie, write to your mother, activate Bluetooth and receive directions to get home. You just have to use your voice.";
        String description2 = "At the pure hardware level it is surprising that the LG V30S does not change processor. It maintains the Snapdragon 835, which gives it a bit more push with the increase in the amount of RAM to 6 GB. Recall that the RAM of last year's LG V30 stays at 4 GB. Another very important step forward can be seen in the internal memory, which can now be 128 GB in the LG V30S and up to 256 GB in the hypervitamin version and that they have called LG V30S.";
        String description3 = "The Sony Xperia 10 II has IP65 / 68 which makes it resistant to water and dust, in addition to the durability and protection provided by the Corning Gorilla Glass on the front and back. All your images will be much sharper than with previous models, thanks to the motion prediction function. With it, you can say goodbye to out-of-focus photos by making an automatic focus of any person or object and capture almost impossible images even if the subject is moving.";
        String description4 = "The future is here with the Samsung Galaxy Z Flip. It is a foldable smartphone that folds over itself to cut its size in half and can be easily carried in your pocket. Of course, when you open it, you access a whole world of possibilities. Its AMOLED screen is 6.7 inches when open. It's capacitive and multi-touch, with a Full HD resolution of 2,636 x 1,080 pixels and a 22: 9 aspect ratio for HDR10 + cinematic quality. Its Qualcomm Snapdragon 588 Plus processor can work at a speed of up to 2.95 GHz.";
        String description5 = "OPPO A91 falls in love at first sight. Let yourself be carried away by your senses thanks to the bright colors in which it is designed that also move when you do it. Its lightness and speed what happens in your best travel and life companion.";
        String description6 = "Immerse yourself in the 6.1-inch Liquid Retina HD of the Apple iPhone 11 64 GB mobile in black. It also has the A13 Bionic chip, with intelligence and power never seen in a smartphone. Not forgetting its revolutionary dual camera system and even faster facial recognition. Everything you love about the iPhone, but taken to the extreme.";
        String description7 = "The HUAWEI P-series has always been a pioneer in smartphone photography. Once again the HUAWEI P20 Pro leads the way with a revolutionary Leica Triple Camera, where aesthetic vision meets an advanced camera system that ushers in a new era of smart photography.";
        String description8 = "This mobile is an off-road vehicle is equipped with an external camera that has a very sensitive cmos sensor to light specially designed for night scenes and low light. The internal structure of the four corners is designed with shock absorbers. The newest Android 9.0 system makes the rugged mobile work faster, saving memory and its 4380mAh battery";
        String description9 = "See the world on your screen. The Galaxy A40's 5.9 ”Infinity-U display shows your content in astonishing detail. From music videos to the latest compilation: FHD + and Super AMOLED bring images to life on an edge-to-edge screen. Designed in vibrant colors.";

        Phone phone0 = new Phone("Redmi Note 8", "Xiaomi", description0, "white", 179, "redmi_note_8.png", "6.3\"",
                "Helio G80", 4);
        Phone phone1 = new Phone("Google Pixel XL", "Google", description1, "black", 342, "google_pixel_xl.png",
                "5.5\"", "Qualcomm 4", 4);
        Phone phone2 = new Phone("LG V30 Plus", "LG", description2, "black", 289, "lg_v30_plus.png", "6\"",
                "Snapdragon 835", 4);
        Phone phone3 = new Phone("Sony Xperia 10 II", "Sony", description3, "black", 260, "sony_xperia_10_ii.png",
                "6\"", "Qualcomm Snapdragon 665", 4);
        Phone phone4 = new Phone("Samsung Z Flip", "Samsung", description4, "blue", 993, "samsung_z_flip.png", "6.7\"",
                "Qualcomm Snapdragon 855+", 8);
        Phone phone5 = new Phone("OPPO A91", "OPPO", description5, "blue", 279, "oppo_a91.png", "6.4\"", "Helio P70",
                8);
        Phone phone6 = new Phone("iPhone 11", "Apple", description6, "white", 739, "iphone_11.png", "6.1\"",
                "Chip A13 Bionic", 4);
        Phone phone7 = new Phone("Huawei 20 PRO", "Huawei", description7, "grey", 400, "huawei_20_pro.png", "6.1\"",
                " Kirin 970 8 Cores", 6);
        Phone phone8 = new Phone("Blackview BV9700 Pro", "Blackview", description8, "gray", 280,
                "blackview_bv9700_pro.png", "6.3\"", "Helio P70", 6);
        Phone phone9 = new Phone("Samsung Galaxy A40", "Samsung", description9, "grey", 219, "samsung_galaxy_a40.png",
                "5.9\"", " Exynos7904 Quad1.8 GHz + Quad1.6 GHz", 4);

        phonesRepository.save(phone0);
        phonesRepository.save(phone1);
        phonesRepository.save(phone2);
        phonesRepository.save(phone3);
        phonesRepository.save(phone4);
        phonesRepository.save(phone5);
        phonesRepository.save(phone6);
        phonesRepository.save(phone7);
        phonesRepository.save(phone8);
        phonesRepository.save(phone9);
        phonesRepository.flush();
    }

}