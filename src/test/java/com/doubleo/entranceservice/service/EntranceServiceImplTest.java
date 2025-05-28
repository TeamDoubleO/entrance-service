package com.doubleo.entranceservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.doubleo.entranceservice.dto.request.EnterVerificationInfoRequest;
import java.util.List;
import org.junit.jupiter.api.Test;

class EntranceServiceImplTest {

    private final EntranceServiceImpl entranceService = new EntranceServiceImpl();

    @Test
    void 하위_구역이_허용되어_상위_출입_가능() {
        // allowedAreas에 A_01_01 -> A는 상위 -> 허용
        var request = new EnterVerificationInfoRequest("A", List.of("A_01_01"));
        boolean result = entranceService.verifyEntrance(request);
        assertThat(result).isTrue();
    }

    @Test
    void 동일_구역_출입_가능() {
        var request = new EnterVerificationInfoRequest("A_01_01", List.of("A_01_01"));
        boolean result = entranceService.verifyEntrance(request);
        assertThat(result).isTrue();
    }

    @Test
    void 상위만_허용된_경우_하위_출입_불가() {
        // allowedAreas에 A_01 -> A_01_01은 하위 -> x
        var request = new EnterVerificationInfoRequest("A_01_01", List.of("A_01"));
        boolean result = entranceService.verifyEntrance(request);
        assertThat(result).isFalse();
    }

    @Test
    void 빈_리스트는_불가() {
        var request = new EnterVerificationInfoRequest("A", List.of());
        boolean result = entranceService.verifyEntrance(request);
        assertThat(result).isFalse();
    }
}
