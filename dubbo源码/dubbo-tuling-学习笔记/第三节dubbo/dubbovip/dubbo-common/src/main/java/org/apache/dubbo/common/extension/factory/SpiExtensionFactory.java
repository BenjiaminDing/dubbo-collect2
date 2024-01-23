/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.common.extension.factory;

import org.apache.dubbo.common.extension.ExtensionFactory;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.extension.SPI;

/**
 * SpiExtensionFactory
 */
public class SpiExtensionFactory implements ExtensionFactory {

    @Override
    public <T> T getExtension(Class<T> type, String name) {


        // 接口上存在SPI注解
        if (type.isInterface() && type.isAnnotationPresent(SPI.class)) {
            // 通过Car.class 获取对应的扩展点
            ExtensionLoader<T> loader = ExtensionLoader.getExtensionLoader(type);

            if (!loader.getSupportedExtensions().isEmpty()) {
                // laoder是Car.class的扩展点加载器
                /**
                 *  ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension());  这个地方是dubbo使用自己的方式
                 *  创建了自己的代理对象AdaptiveExtensionFactory，原因是在 AdaptiveExtensionFactory 的类上面有注解 @Adaptive
                 *  那么同样道理， 如果想获取Car.class的代理对象就需要在这个属性或者类上添加注解  @Adaptive
                 */
                return loader.getAdaptiveExtension(); // 接口的Adaptive类（代理对象）
            }
        }
        return null;
    }

}
