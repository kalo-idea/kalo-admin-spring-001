package kalo.kaloAdmin_kalo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kalo.kaloAdmin_kalo.repository.LedgersRepository;
import kalo.kaloAdmin_kalo.repository.UsersRepository;
import kalo.kaloAdmin_kalo.domain.dto.ReadUsersDto;
import kalo.kaloAdmin_kalo.domain.dto.SearchResultDto;
import kalo.kaloAdmin_kalo.domain.dto.UsersInfoDto;
import kalo.kaloAdmin_kalo.domain.Users;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final LedgersRepository ledgersRepository;

    // 모든 회원 조회 - QueryDsl 연결 확인용
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

    // 이름, 닉네임 검색
    public List<SearchResultDto> searchByUsernameAndNickame(Pageable pageable, String username, String nickname) {
        List<UsersInfoDto> usersInfoDtos = usersRepository.getUsersByUsernameAndNickname(username, nickname);

        List<SearchResultDto> result = new ArrayList<>();
        for (UsersInfoDto usersInfoDto : usersInfoDtos) {
            result.add(new SearchResultDto(usersInfoDto, ledgersRepository.getSumLedgers(usersInfoDto.getKaloUID())));
        }

        return result;
    }
}