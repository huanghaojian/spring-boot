package com.hhjian.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>Dubbo Configuration</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.12
 */
@Configuration
@ConditionalOnClass(Exporter.class)
@PropertySource(value = "classpath:application.yml")
public class DubboConfiguration {

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
     * 服务协议名称
     */
    @Value("${dubbo.service.protocol}")
    private String serviceProtocol;

    /**
     * 服务协议端口
     */
    @Value("${dubbo.service.port}")
    private int servicePort;

    /**
     * 服务方法调用超时时间(毫秒)
     */
    @Value("${dubbo.provider.timeout}")
    private int timeout;

    /**
     * 远程服务调用重试次数
     */
    @Value("${dubbo.provider.retries}")
    private int retries;

    /**
     * 延迟注册服务时间(毫秒)
     */
    @Value("${dubbo.provider.delay}")
    private int delay;

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
     * 默认基于Dubbo协议提供服务
     *
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(serviceProtocol);
        protocolConfig.setPort(servicePort);
        protocolConfig.setThreads(200);
        return protocolConfig;
    }

    /**
     * Dubbo服务提供者配置
     *
     * @param applicationConfig
     * @param protocolConfig
     * @return
     */
    @Bean(name = "myProvider")
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig, ProtocolConfig protocolConfig) {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(timeout);
        providerConfig.setRetries(retries);
        providerConfig.setDelay(delay);
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig());
        providerConfig.setProtocol(protocolConfig);
        return providerConfig;
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

    public String getServiceProtocol() {
        return serviceProtocol;
    }

    public void setServiceProtocol(String serviceProtocol) {
        this.serviceProtocol = serviceProtocol;
    }

    public int getServicePort() {
        return servicePort;
    }

    public void setServicePort(int servicePort) {
        this.servicePort = servicePort;
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

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
