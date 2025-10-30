package com.cpro.accounts.mongo.infrastructure.adapter.out;

import com.cpro.accounts.mongo.application.port.out.AccountRepository;
import com.cpro.accounts.mongo.domain.model.Account;
import com.cpro.accounts.mongo.infrastructure.mapper.AccountMapper;
import com.cpro.accounts.mongo.infrastructure.persistence.document.AccountDocument;
import com.cpro.accounts.mongo.infrastructure.persistence.repository.SpringDataAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final SpringDataAccountRepository dataAccountRepository;
    private final AccountMapper accountMapper;

    @Override
    public Optional<Account> findById(String id) {
        return dataAccountRepository.findById(id)
                .map(accountMapper::toDomain);
    }

    @Override
    public List<Account> findByOwner(String identification) {
        return dataAccountRepository.findByOwner(identification)
                .stream()
                .map(accountMapper::toDomain)
                .toList();
    }

    @Override
    public Account save(Account account) {
        AccountDocument document = accountMapper.toDocument(account);
        AccountDocument saved = dataAccountRepository.insert(document);
        return accountMapper.toDomain(saved);
    }
}
