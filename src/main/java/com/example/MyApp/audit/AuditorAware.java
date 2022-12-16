package com.example.MyApp.audit;

import java.util.Optional;

public interface AuditorAware<T> {

  Optional<T> getCurrentAuditor();
}
