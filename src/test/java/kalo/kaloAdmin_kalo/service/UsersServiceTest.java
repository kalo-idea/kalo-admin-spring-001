package kalo.kaloAdmin_kalo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import kalo.kaloAdmin_kalo.domain.dto.ReadUsersDto;
import kalo.kaloAdmin_kalo.domain.dto.SearchResultDto;

@Transactional
@SpringBootTest
public class UsersServiceTest {
    
    @Autowired
    UsersService usersService;

    @Test
    @DisplayName("조회")
    public void getAllUsersWithPaging() {
        Pageable pageable = PageRequest.of(0, 5);
        
        List<List<ReadUsersDto>> result = usersService.readAllUsers(pageable);

        System.out.println(result);
        
    }

    @Test
    @DisplayName("이름, 닉네임 검색 테스트")
    public void searchByUsernameAndNickameTest() {

        Pageable pageable = PageRequest.of(0, 5);
        List<SearchResultDto> searchResultDto = usersService.searchByUsernameAndNickame(pageable, "조원", null);
        System.out.println( "결과 : " + searchResultDto); 
    }
}
