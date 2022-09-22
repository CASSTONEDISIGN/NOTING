package com.example.noting_backend.user.hash;

import com.example.noting_backend.user.dto.UserDto;
import com.example.noting_backend.user.entity.User;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.time.format.DateTimeFormatter;

@Component
public class UserHash {

    public String hashing(byte[] pw, String SALT) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        for(int i = 0; i < 10000; i++){
            String tmp = ByteString(pw) + SALT;
            md.update(tmp.getBytes());
            pw = md.digest();
        }

        return ByteString(md.digest());
    }

    public String getSALT(UserDto userDto) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String dateTimeEmail = userDto.getCreateAt().format((DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                + userDto.getEmail();

        md.update(dateTimeEmail.getBytes());

        return ByteString(md.digest());
    }

    public String ByteString(byte[] temp){
        StringBuilder sb = new StringBuilder();
        for(byte a: temp){
            sb.append(String.format("%02x", a));
        }
        return sb.toString();
    }
}
