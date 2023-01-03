package kalo.kaloAdmin_kalo.repository;

import java.util.List;

import kalo.kaloAdmin_kalo.domain.dto.ReadUsersDto;
import kalo.kaloAdmin_kalo.domain.dto.UsersInfoDto;

public interface UsersRepositoryCustom {
    List<ReadUsersDto> getUserLedgers(String userId);
    List<UsersInfoDto> getUsersByUsernameAndNickname (String username, String nickname);
}
