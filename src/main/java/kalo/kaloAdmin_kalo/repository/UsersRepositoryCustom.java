package kalo.kaloAdmin_kalo.repository;

import java.util.List;

import kalo.kaloAdmin_kalo.domain.dto.ReadUsersDto;

public interface UsersRepositoryCustom {
    List<ReadUsersDto> getUserLedgers(String userId);
}
