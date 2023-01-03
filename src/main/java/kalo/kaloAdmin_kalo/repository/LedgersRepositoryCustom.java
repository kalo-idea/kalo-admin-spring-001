package kalo.kaloAdmin_kalo.repository;

import kalo.kaloAdmin_kalo.domain.dto.CountLedgersDto;

public interface LedgersRepositoryCustom {
    CountLedgersDto getSumLedgers(String userId);
}
