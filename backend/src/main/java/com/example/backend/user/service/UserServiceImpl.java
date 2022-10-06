package com.example.backend.user.service;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;
import com.example.backend.user.hash.UserHash;
import lombok.RequiredArgsConstructor;
import com.example.backend.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserHash userHash;

    @Override
    public User join(UserDto userDto) throws Exception {
        String hashedPw = userHash.hash(userDto);

        userDto.setPw(hashedPw);
        User user = userDto.toEntity();

        validateDuplicateMember(user);
        userRepository.save(user);
        
        return user;
    }



    @Override
    public Optional<User> login(UserDto userDto) throws Exception {
        //생성 시간 가져 오기
        LocalDateTime createTime =  getCreateTime(userDto);
        // 생성 시간 셋
        userDto.setCreateAt(createTime);
        // 가져온 생성 시간으로 해쉬 돌리기
        String hashedPw = userHash.hash(userDto);
        userDto.setPw(hashedPw);
        // 엔티티 변환
        User user = userDto.toEntity();

        return userRepository.findUser(user);
    }
    @Override
    public Optional<User> change(UserDto userDto, String newpw) throws Exception {
        // 생성 시간 가져 오기
        LocalDateTime createTime =  getCreateTime(userDto);
        // 생성 시간 셋
        userDto.setCreateAt(createTime);
        // 전 비밀번호를 해쉬함
        String hashedPw = userHash.hash(userDto);
        // 비밀번호 셋
        userDto.setPw(hashedPw);
        // 엔티티 변환
        User user = userDto.toEntity();
        // 새로운 비밀번호 셋
        userDto.setPw(newpw);
        // 해쉬
        String hashedPw2 = userHash.hash(userDto);

        return userRepository.changePw(user,hashedPw2);
    }

    @Override
    public LocalDateTime getCreateTime(UserDto userDto) {
        // 이메일로 회원 가져오기
        Optional<User> User = userRepository.findByEmail(userDto.getEmail());
        // 가져온 회원 정보로 생성 시간 가져오기
        return User.get().getCreateAt();

    }

    private void validateDuplicateMember(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
