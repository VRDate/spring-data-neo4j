/**
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.neo4j.transaction;

import org.neo4j.helpers.Service;
import org.neo4j.kernel.impl.core.KernelPanicEventGenerator;
import org.neo4j.kernel.impl.transaction.AbstractTransactionManager;
import org.neo4j.kernel.impl.transaction.TransactionManagerProvider;
import org.neo4j.kernel.impl.transaction.TxHook;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@Service.Implementation( TransactionManagerProvider.class )
public class SpringProvider extends TransactionManagerProvider
{
    public SpringProvider()
    {
        super( "spring-jta" );
    }

    @Override
    protected AbstractTransactionManager loadTransactionManager(String s, KernelPanicEventGenerator kernelPanicEventGenerator, TxHook txHook) {
        return new SpringServiceImpl();
    }
}
