package com.DataInfo.Api.util;

public class Util {
    public static boolean checkCep(String cep) {
        if (!cep.matches("\\d{8}")) {
            return false;
        }

        return true;
    }
}
