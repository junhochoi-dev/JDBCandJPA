package org.ccd.jdbc.service;

import lombok.RequiredArgsConstructor;
import org.ccd.jdbc.domain.Test;
import org.ccd.jdbc.repository.TestJDBCRepository;
import org.ccd.jdbc.repository.TestJPARepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TestService {

    private final int SIZE = 50000;
    private final String DUMMY = "@@@@@@@@@@";
    private final TestJPARepository testJPARepository;
    private final TestJDBCRepository testJDBCRepository;

    public void testJDBC(){
        List<Test> testList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            testList.add(Test.builder()
                    .value1(DUMMY).value2(DUMMY)
                    .value3(DUMMY).value4(DUMMY)
                    .value5(DUMMY).build()
            );
        }
        testJDBCRepository.saveAll(testList);
    }

    public void testJPA(){
        List<Test> testList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            testList.add(Test.builder()
                    .value1(DUMMY).value2(DUMMY)
                    .value3(DUMMY).value4(DUMMY)
                    .value5(DUMMY).build()
            );
        }
        testJPARepository.saveAll(testList);
    }
}
