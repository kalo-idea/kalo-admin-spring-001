package kalo.kaloAdmin_kalo.repository;

import static com.querydsl.jpa.JPAExpressions.select;
import static kalo.kaloAdmin_kalo.domain.QAuths.auths;
import static kalo.kaloAdmin_kalo.domain.QLedgers.ledgers;
import static kalo.kaloAdmin_kalo.domain.QUsers.users;

import java.util.List;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kalo.kaloAdmin_kalo.domain.dto.ReadUsersDto;
import kalo.kaloAdmin_kalo.domain.dto.QReadUsersDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    
    /**
    String kakaoUID;
    String kaloUID;
    String username;
    String email;
    String phone;
    String nickname;
    String birth;
    String gender;
    String address;
    Long point;
     */
    @Override
    public List<ReadUsersDto> getUserLedgers (String userId) {
        return queryFactory
        .select(new QReadUsersDto(auths.id, users.id, auths.name, auths.email, auths.tel, users.nickname, auths.birth, auths.gender, auths.address, ledgersCount(userId)))
        .from(users)
        .join(users.auths, auths)
        .where(users.id.eq(userId))
        .fetch();
    }

    private Expression<Long> ledgersCount(String userId) {
        return select(ledgers.amount.sum()).from(ledgers).where(ledgers.users.id.eq(userId));
    }
}