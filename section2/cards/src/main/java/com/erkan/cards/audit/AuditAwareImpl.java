package com.erkan.cards.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @SuppressWarnings("null")
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("CARDS_MS");
    }
}
