package ru.test.block;

import javax.xml.crypto.Data;
import java.security.MessageDigest;
import java.sql.SQLOutput;
import java.util.Objects;

public class Block {

    public String hash; // todo если все параметры инициализируются в конструкторе то можно их сделать final

    // todo также нужно сделать поля private - свойство инкапсуляции
    public int data;
    public long time;
    public String prevHash;

    //todo где Id блока ?????????????????


    public Block(int data, String prevHash) {
        this.data = data;
        this.time = System.currentTimeMillis();
        this.prevHash = prevHash;
        this.hash = calculateHash(data + prevHash); //todo не учитывается время при вычислении hashCode


    }

    public String calculateHash(String input) {
//         return Integer.toHexString((data+time+prevHash).hashCode());
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPrevHash() {
        return prevHash;

    }

}

