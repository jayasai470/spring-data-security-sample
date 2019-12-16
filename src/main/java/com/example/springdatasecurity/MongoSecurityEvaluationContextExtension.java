package com.example.springdatasecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import java.util.Collections;
import java.util.Map;

@Slf4j
public class MongoSecurityEvaluationContextExtension extends SecurityEvaluationContextExtension {

  @Override
  public String getExtensionId() {
    return "security";
  }

  @Override
  public Map<String, Object> getProperties() {
    return Collections.singletonMap("principal", (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
  }
}