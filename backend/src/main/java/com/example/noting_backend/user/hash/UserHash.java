package com.example.noting_backend.user.hash;

import com.example.noting_backend.user.dto.UserDto;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.time.format.DateTimeFormatter;

@Component
public class UserHash {

    public String hash(UserDto userDto) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String strSalt = byteToString(getSalt(userDto));
        byte[] bytesPw = userDto.getPw().getBytes();

        for(int i = 0; i < 10000; i++){
            String tmp = byteToString(bytesPw) + strSalt;
            md.update(tmp.getBytes());
            bytesPw = md.digest();
        }

        return byteToString(bytesPw);
    }

    public byte[] getSalt(UserDto userDto) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String dateTimeEmail = userDto.getCreateAt()
                .format((DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))) + userDto.getEmail();

        md.update(dateTimeEmail.getBytes());

        return md.digest();
    }

    public String byteToString(byte[] temp){
        StringBuilder sb = new StringBuilder();

        for(byte a: temp){
            sb.append(String.format("%02x", a));
        }

        return sb.toString();
    }
}
