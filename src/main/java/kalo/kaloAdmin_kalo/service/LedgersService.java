package kalo.kaloAdmin_kalo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kalo.kaloAdmin_kalo.repository.LedgersRepository;
import kalo.kaloAdmin_kalo.domain.Ledgers;
import kalo.kaloAdmin_kalo.domain.dto.LedgersHistoryDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LedgersService {
    private final LedgersRepository ledgersRepository;

    public List<LedgersHistoryDto> getLedgersHistory(String userId) {
        List<LedgersHistoryDto> result = new ArrayList();
        List<Ledgers> arr = ledgersRepository.findByUsersIdOrderByCreatedAtDesc(userId);
        for (Ledgers ledgers : arr) {
            result.add(new LedgersHistoryDto(ledgers.getType(), ledgers.getAmount(), ledgers.getCreatedAt(), ledgers.getUpdatedAt()));
        }
        return result;
    }
}
