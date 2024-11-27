package com.erkan.accounts.aspect;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.erkan.accounts.annotation.ImportantLog;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class ImportantLogAspect {

        private static final Logger logger = LoggerFactory.getLogger("important-ops");
        private final ObjectMapper objectMapper;
        private final HttpServletRequest request;
        private final Environment environment;

        @Around("@annotation(importantLog)")
        public Object logImportant(ProceedingJoinPoint joinPoint, ImportantLog importantLog)
                        throws Throwable {
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                String methodName = signature.getName();
                long startTime = System.currentTimeMillis();
                String correlationId = UUID.randomUUID().toString();

                MDC.put("correlationId", correlationId);

                try {
                        // Başlangıç bilgileri
                        Authentication auth =
                                        SecurityContextHolder.getContext().getAuthentication();
                        String username = auth != null ? auth.getName() : "anonymous";
                        String clientIP = request.getRemoteAddr();
                        Map<String, String> headers = Collections.list(request.getHeaderNames())
                                        .stream().collect(Collectors.toMap(headerName -> headerName,
                                                        request::getHeader));

                        // Memory kullanımı
                        Runtime runtime = Runtime.getRuntime();
                        long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / 1024
                                        / 1024;

                        // Ortam bilgisi
                        String activeProfile = environment.getActiveProfiles().length > 0
                                        ? environment.getActiveProfiles()[0]
                                        : "default";

                        // Detaylı başlangıç logu
                        logger.warn("""
                                        🚀 İşlem Başlıyor
                                        Metod: {}
                                        Kullanıcı: {}
                                        IP: {}
                                        Headers: {}
                                        Memory: {} MB
                                        Ortam: {}
                                        CorrelationId: {}
                                        Parametreler: {}""", methodName, username, clientIP,
                                        objectMapper.writeValueAsString(headers), usedMemory,
                                        activeProfile, correlationId,
                                        objectMapper.writeValueAsString(joinPoint.getArgs()));

                        Object result = joinPoint.proceed();

                        long duration = System.currentTimeMillis() - startTime;

                        // Performans kontrolü
                        String performanceWarning =
                                        duration > 1000 ? "⚠️ YAVAŞ İŞLEM!" : "✅ Normal süre";

                        // Sonuç logu
                        logger.warn("""
                                        ✅ İşlem Tamamlandı
                                        Metod: {}
                                        Süre: {} ms {}
                                        Sonuç: {}
                                        CorrelationId: {}
                                        """, methodName, duration, performanceWarning,
                                        objectMapper.writeValueAsString(result), correlationId);

                        return result;
                } catch (Exception e) {
                        logger.error("""
                                        ❌ Hata Oluştu
                                        Metod: {}
                                        Hata: {}
                                        Zaman: {}
                                        Stack: {}
                                        CorrelationId: {}
                                        """, methodName, e.getMessage(), LocalDateTime.now(),
                                        e.getStackTrace(), correlationId);
                        throw e;
                } finally {
                        MDC.remove("correlationId");
                }
        }
}
