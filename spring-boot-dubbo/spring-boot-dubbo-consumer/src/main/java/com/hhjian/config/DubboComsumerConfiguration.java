package com.hhjian.config;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>Dubbo Comsumer Configuration</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.12
 */
@Configuration
@ConditionalOnClass(Invoker.class)
@PropertySource(value = "classpath:application.yml")
public class DubboComsumerConfiguration {

    /**
     * 当前应用名
     */
    @Value("${dubbo.application.name}")
    private String applicationName;

    /**
     * 注册中心协议
     */
    @Value("${dubbo.registry.protocol}")
    private String registryProtocol;

    /**
     * 注册中心地址
     */
    @Value("${dubbo.registry.address}")
    private String registryAddress;

    /**
     * 服务方法调用超时时间(毫秒)
     */
    @Value("${dubbo.consumer.timeout}")
    private int timeout;

    /**
     * 远程服务调用重试次数
     */
    @Value("${dubbo.consumer.retries}")
    private int retries;

    /**
     * 设置dubbo扫描的包
     *
     * @param packageName 需要注册的服务的包名
     * @return
     */
    @Bean
    public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        return annotationBean;
    }

    /**
     * 注入Dubbo上下文
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    /**
     * 注入Dubbo注册中心配置,基于Zookeeper
     *
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        // 连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol(registryProtocol);
        registryConfig.setAddress(registryAddress);
        return registryConfig;
    }

    /**
     * Dubbo服务消费者配置
     *
     * @param applicationConfig
     * @param protocolConfig
     * @return
     */
    @Bean(name = "myConsumer")
    public ConsumerConfig consumerConfig(ApplicationConfig applicationConfig) {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setApplication(applicationConfig);
        consumerConfig.setRegistry(registryConfig());
        consumerConfig.setTimeout(timeout);
        consumerConfig.setRetries(retries);
        return consumerConfig;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getRegistryProtocol() {
        return registryProtocol;
    }

    public void setRegistryProtocol(String registryProtocol) {
        this.registryProtocol = registryProtocol;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }
}
