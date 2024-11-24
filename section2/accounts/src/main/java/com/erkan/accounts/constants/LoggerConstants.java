package com.erkan.accounts.constants;

public final class LoggerConstants {
    private LoggerConstants() {}

    public static final String ACCOUNT_OPS = "account-ops";
    public static final String CRITICAL_OPS = "critical-ops";

    public static final String METHOD_PARAMS = "Parametreler: {}";
    public static final String METHOD_RESULT = "Sonuç: {}";
    public static final String METHOD_DURATION = "Çalışma Süresi: {} ms";
    public static final String METHOD_USER = "Çalıştıran Kullanıcı: {}";
    public static final String METHOD_IP = "İstek IP: {}";
    public static final String METHOD_PATH = "Endpoint: {}";
    public static final String MEMORY_USAGE = "Memory Kullanımı: {} MB";
    public static final String REQUEST_HEADERS = "Request Headers: {}";
    public static final String CORRELATION_ID = "Correlation ID: {}";
    public static final String ENVIRONMENT = "Ortam: {}";
}
