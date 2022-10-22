//package com.github.lionani07.appussers.config;
//
//
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.Collections;
//
////@Configuration
//public class AmazonSQSConfig {
//
//    @Value("${cloud.aws.region.static}")
//    private String region;
//
//    @Value("${cloud.aws.credentials.access-key}")
//    private String accessKey;
//
//    @Value("${cloud.aws.credentials.secret-key}")
//    private String secretKey;
//
//    @Value("${cloud.aws.sqs.pool.core-size}")
//    private Integer corePoolSize;
//
//    @Value("${cloud.aws.sqs.pool.wait-timeout}")
//    private Integer waitTimeOut;
//
//    @Value("${cloud.aws.sqs.pool.thread-name-prefix}")
//    private String threadNamePrefix;
//
//    @Value("${cloud.aws.proxy.host}")
//    private String proxyHost;
//
//    @Value("${cloud.aws.proxy.port}")
//    private Integer proxyPort;
//
//    @Bean
//    public ClientConfiguration clientConfiguration() {
//        final var clientConfiguration = new ClientConfiguration();
//        clientConfiguration.setProxyHost(this.proxyHost);
//        clientConfiguration.setProxyPort(this.proxyPort);
//
//        return clientConfiguration;
//    }
//
////    @Bean
//    @Primary
//    public AmazonSQSAsync amazonSQSAsync(final ClientConfiguration clientConfiguration) {
//        return AmazonSQSAsyncClientBuilder
//                .standard()
//                .withRegion(this.region)
//                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(this.accessKey, this.secretKey)))
//                .withClientConfiguration(clientConfiguration)
//                .build();
//    }
//
////    @Bean
//    public QueueMessagingTemplate queueMessagingTemplate(final AmazonSQSAsync amazonSQSAsync) {
//        return new QueueMessagingTemplate(amazonSQSAsync);
//    }
//
////    @Bean
//    public QueueMessageHandler queueMessageHandler(final AmazonSQSAsync amazonSQSAsync) {
//        final var queueMessageHandlerFactory = new QueueMessageHandlerFactory();
//        final var payloadArgumentResolver = new PayloadMethodArgumentResolver(new MappingJackson2MessageConverter());
//        queueMessageHandlerFactory.setArgumentResolvers(Collections.singletonList(payloadArgumentResolver));
//        queueMessageHandlerFactory.setAmazonSqs(amazonSQSAsync);
//
//        return queueMessageHandlerFactory.createQueueMessageHandler();
//    }
//
////    @Bean
//    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
//        final var threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setThreadNamePrefix(this.threadNamePrefix);
//        threadPoolTaskExecutor.setCorePoolSize(this.corePoolSize);
//        threadPoolTaskExecutor.initialize();
//
//        return threadPoolTaskExecutor;
//    }
//
////    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer(
//            final AmazonSQSAsync amazonSQSAsync,
//            final QueueMessageHandler queueMessageHandler,
//            final ThreadPoolTaskExecutor threadPoolTaskExecutor
//    ) {
//        final var simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//        simpleMessageListenerContainer.setMessageHandler(queueMessageHandler);
//        simpleMessageListenerContainer.setAmazonSqs(amazonSQSAsync);
//        simpleMessageListenerContainer.setWaitTimeOut(this.waitTimeOut);
//        simpleMessageListenerContainer.setTaskExecutor(threadPoolTaskExecutor);
//
//        return simpleMessageListenerContainer;
//    }
//
//}