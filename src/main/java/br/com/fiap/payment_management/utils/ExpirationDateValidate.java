package br.com.fiap.payment_management.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpirationDateValidate {

    public static boolean isAValidExpirationDate(String expirationDate) {
        String regex = "^(0[1-9]|1[0-2])\\/\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expirationDate);

        return matcher.matches();
    }
}
