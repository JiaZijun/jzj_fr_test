package com.fr.test.service.dynamic.utils;

import com.baidu.disconf.client.config.DisClientConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Email: linlemo@gmail.com
 * Date: 16/9/26
 * Time: 15:12
 */
public class DynamicFileUtils {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DynamicFileUtils.class);

    public static String readDisConfFile(String fileName) {
        try {
            return FileUtils.readFileToString(new File(DisClientConfig.getInstance().userDefineDownloadDir, fileName), "utf8");
        } catch (Exception e) {
            LOGGER.error("readDisConfFile [{}] exception ", fileName, e);
        }
        return StringUtils.EMPTY;
    }

    public static Map<String, String> readPropertiesDisConfFile(String fileName) {
        try {
            return parseProperties(FileUtils.readFileToString(new File(DisClientConfig.getInstance().userDefineDownloadDir, fileName), "utf8"));
        } catch (Exception e) {
            LOGGER.error("readPropertiesDisConfFile [{}] exception ", fileName, e);
        }
        return Collections.emptyMap();
    }


    public static Map<String, String> parseProperties(String data) throws IOException {
        if (StringUtils.isBlank(data)) {
            return Collections.emptyMap();
        }

        Properties p = new Properties();
        p.load(new StringReader(data));

        Map<String, String> map = new LinkedHashMap<String, String>(p.size());

        Iterator iterator = p.stringPropertyNames().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            map.put(key, p.getProperty(key));
        }

        return map;
    }
}
