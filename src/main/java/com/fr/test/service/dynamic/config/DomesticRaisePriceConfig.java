package com.fr.test.service.dynamic.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.fr.test.service.dynamic.utils.DynamicFileUtils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jzj
 * @date 2018年10月26日 下午3:18:47
 * @desc domestic supplier 退改加价配置
 */
@Service
@DisconfFile(filename = "domesticRaisePrice.properties")
@DisconfUpdateService(confFileKeys = {"domesticRaisePrice.properties"})
public class DomesticRaisePriceConfig implements IDisconfUpdate{

    private static final Logger LOGGER = LoggerFactory.getLogger(DomesticRaisePriceConfig.class);

    private static final String FILE_NAME = "domesticRaisePrice.properties";

    private static Map<String, String> supplierRaisePriceMap = new HashMap<>();
    
    @PostConstruct
    @Override
    public void reload() throws Exception {
        try {
        	supplierRaisePriceMap = DynamicFileUtils.readPropertiesDisConfFile(FILE_NAME);
            LOGGER.info("==================domesticRaisePrice  disconf init content  = {}", supplierRaisePriceMap);
        } catch (Exception e) {
            LOGGER.error("domesticRaisePrice disconf init exception", e);
        }
        LOGGER.info("================== domesticRaisePrice disconf init end");
    }
    

}
