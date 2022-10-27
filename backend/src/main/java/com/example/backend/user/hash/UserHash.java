package com.example.backend.user.hash;

import com.example.backend.user.dto.UserDto;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.time.format.DateTimeFormatter;

@Component
public class UserHash {
    /**
     * 해싱하기
     */
    public String hash(UserDto userDto) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // MD5 해시를 하기 위한 클래스

        String strSalt = byteToString(getSalt(userDto));
        byte[] bytesPw = userDto.getPw().getBytes();

        for(int i = 0; i < 10000; i++){
            String tmp = byteToString(bytesPw) + strSalt;
            md.update(tmp.getBytes());
            bytesPw = md.digest();
        }

        return byteToString(bytesPw);
    }
    /**
     SALT를 만들기 위함
     **/
    public byte[] getSalt(com.example.backend.user.dto.UserDto userDto) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String dateTimeEmail = userDto.getCreateAt()
                .format((DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))) + userDto.getEmail();

        // 회원 생성 시간과 이메일을 문자열로 합침
        md.update(dateTimeEmail.getBytes());

        // 바이트로 바뀜
        return md.digest();
    }
    /**
     * 16진수로 바꾸기 위한 함수
     */
    public String byteToString(byte[] temp){
        StringBuilder sb = new StringBuilder();

        for(byte a: temp){
            sb.append(String.format("%02x", a));
        }

        return sb.toString();
    }
}
