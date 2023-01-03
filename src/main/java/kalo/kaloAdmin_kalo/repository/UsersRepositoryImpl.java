package kalo.kaloAdmin_kalo.repository;

import static com.querydsl.jpa.JPAExpressions.select;
import static kalo.kaloAdmin_kalo.domain.QAuths.auths;
import static kalo.kaloAdmin_kalo.domain.QLedgers.ledgers;
import static kalo.kaloAdmin_kalo.domain.QUsers.users;

import java.util.List;

import org.springframework.util.StringUtils;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kalo.kaloAdmin_kalo.domain.dto.ReadUsersDto;
import kalo.kaloAdmin_kalo.domain.dto.UsersInfoDto;
import kalo.kaloAdmin_kalo.domain.dto.QReadUsersDto;
import kalo.kaloAdmin_kalo.domain.dto.QUsersInfoDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    
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

    @Override
    public List<UsersInfoDto> getUsersByUsernameAndNickname (String username, String nickname) {
        return queryFactory
        .select(new QUsersInfoDto(auths.id, users.id, auths.name, auths.email, auths.tel, users.nickname, auths.birth, auths.gender, auths.address))
        .from(users)
        .join(users.auths, auths)
        .where(likeNickname(nickname), likeUsername(username))
        .fetch();
    }

    // 이름 검색
    private BooleanExpression likeUsername(String username) {
        if (StringUtils.hasText(username)) {
            return auths.name.like("%" + username + "%");
        }
        return null;
    }

    // 닉네임 검색
    private BooleanExpression likeNickname(String nickname) {
        if (StringUtils.hasText(nickname)) {
            return users.nickname.like("%" + nickname + "%");
        }
        return null;
    }
}