package kalo.kaloAdmin_kalo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kalo.kaloAdmin_kalo.repository.UsersRepository;
import kalo.kaloAdmin_kalo.domain.dto.ReadUsersDto;
import kalo.kaloAdmin_kalo.domain.Users;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    // 모든 회원 조회 - 테스트용
    public List<List<ReadUsersDto>> readAllUsers(Pageable pageable) {
        Page<Users> users = usersRepository.findAll(pageable);
        List<List<ReadUsersDto>> result = new ArrayList();
        System.out.println("passed");
        for (Users user : users) {        
            String userId = user.getId();
            System.out.println("userId : " + userId);
            List<ReadUsersDto> readUsersDto = usersRepository.getUserLedgers(userId);
            System.out.println("readUsersDto" + readUsersDto);
            result.add(readUsersDto);
        }

        return result;
    }
}