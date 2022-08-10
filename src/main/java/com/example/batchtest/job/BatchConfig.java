package com.example.batchtest.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job testJob(){
        return jobBuilderFactory.get("testJob")
                .start(testStep(null))
                .build();
    }

    @Bean
    @JobScope
    public Step testStep(@Value("#{jobParameters[testParameter]}") String testParameter){
        return stepBuilderFactory.get("testStep")
                .tasklet((contribution, chunkContext) -> {
//                    log.info("=========Start testStep=========");
//                    log.info("=====================testParameter : "+testParameter+"===============");
//                    return RepeatStatus.FINISHED;
                    throw new IllegalArgumentException("================== 실패 ===============");
                })
                .build();
    }
}
