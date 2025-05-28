package com.doubleo.entranceservice.dto.request;

import java.util.List;

public record EnterVerificationInfoRequest(String deviceAreaCode, List<String> allowedAreas) {}
