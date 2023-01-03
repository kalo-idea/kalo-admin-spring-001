package kalo.kaloAdmin_kalo.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kalo.kaloAdmin_kalo.domain.dto.LedgersHistoryDto;
import kalo.kaloAdmin_kalo.domain.dto.SearchResultDto;
import kalo.kaloAdmin_kalo.domain.dto.kaloIdDto;
import kalo.kaloAdmin_kalo.service.LedgersService;
import kalo.kaloAdmin_kalo.service.UsersService;
import kalo.kaloAdmin_kalo.domain.Ledgers;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsersController {
    
    private final UsersService usersService;
    private final LedgersService ledgersService;

    @GetMapping("/test")
    public List<SearchResultDto> searchByUsernameAndNickame(Pageable pageable) {

        return usersService.searchByUsernameAndNickame(pageable, "원민", "");
    }

    @GetMapping("/ledgers")
    public List<LedgersHistoryDto> getLedgersHistory(@RequestBody kaloIdDto kaloId) {
        
        return ledgersService.getLedgersHistory(kaloId.getKaloId());
    }
}
