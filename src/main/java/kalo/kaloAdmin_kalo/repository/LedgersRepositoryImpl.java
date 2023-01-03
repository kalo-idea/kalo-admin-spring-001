package kalo.kaloAdmin_kalo.repository;

import static com.querydsl.jpa.JPAExpressions.select;
import static kalo.kaloAdmin_kalo.domain.QLedgers.ledgers;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kalo.kaloAdmin_kalo.domain.dto.CountLedgersDto;
import kalo.kaloAdmin_kalo.domain.dto.QCountLedgersDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LedgersRepositoryImpl implements LedgersRepositoryCustom {
    
    private final JPAQueryFactory queryFactory;
    
    @Override
    public CountLedgersDto getSumLedgers(String userId) {
        return queryFactory
        .select(new QCountLedgersDto(ledgersCount(userId)))
        .from(ledgers)
        .where(ledgers.users.id.eq(userId))
        .fetchOne();
    }

    
    private Expression<Long> ledgersCount(String userId) {
        return select(ledgers.amount.sum()).from(ledgers).where(ledgers.users.id.eq(userId));
    }
}
