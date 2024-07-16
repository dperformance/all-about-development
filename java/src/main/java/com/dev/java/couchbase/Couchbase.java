package com.dev.java.couchbase;

import org.springframework.http.HttpStatus;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Couchbase {

//    private String couchBaseReactiveUpsert(EvStatusResponseData responseData) {
//        List<EvStatus> evStatusData = responseData.getChargers().stream()
//                .map(response -> EvStatus.builder()
//                        .id(response.getId())
//                        .rdate(response.getRdate() != null ? getFormat(response.getRdate()) : null)
//                        .cst(response.getCst())
//                        .statusUpdateDate(response.getStatusUpdateDate() != null ? getFormat(response.getStatusUpdateDate()) : null)
//                        .build())
//                .toList();
//
//        Flux<EvStatus> evFlux = Flux.fromIterable(evStatusData);
//        Instant start = Instant.now(); // 측정 시작 시간 측정
//        evStatusRepository.saveAll(evFlux)
//                .elapsed() // elapsed() 연산자를 사용하여 측정
//                .subscribe(
//                        null,
//                        null,
//                        () -> {
//                            Instant end = Instant.now(); // 측정 종료 시간 측정
//                            Duration timeElapsed = Duration.between(start, end); // 측정 시작 시간과 종료 시간의 차이를 계산
//                            // resultString.set 삭제예정
//                            log.info("데이터 저장 완료, 소요 시간: " + timeElapsed.toMillis() / 1000 + "s");
//                        }
//                );
//        return String.valueOf(HttpStatus.OK);
//    }
}
