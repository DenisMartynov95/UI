package DataGeneration.SmokeTests;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class t1_RegistrationAccount {

    Random random = new Random();


    public static String username_generation = RandomStringUtils.randomAlphabetic(4);
    public static String email_generation = RandomStringUtils.randomAlphabetic(4) + "@mail.com";
    public static String password_generation = RandomStringUtils.randomAlphabetic(4) + "!A1";




}
