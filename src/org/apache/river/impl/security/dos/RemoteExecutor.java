/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.river.impl.security.dos;

import java.io.IOException;
import java.rmi.Remote;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Peter Firmstone
 */
public interface RemoteExecutor extends Remote {

    public void shutdown() throws IOException;

    /**
     * 
     * @return List of Runnable tasks that haven't been run.
     * @throws IOException
     */
    public List shutdownNow() throws IOException;

    public boolean isShutdown() throws IOException;

    public boolean isTerminated() throws IOException;

    public boolean awaitTermination(long timeout, TimeUnit unit) 
            throws InterruptedException, IOException;

    public Future submit(Callable task) throws IOException;

    public Future submit(Runnable task, Object result) throws IOException;

    public Future submit(Runnable task) throws IOException;

    /**
     * 
     * @param tasks Collection of Callable tasks.
     * @return List<Future> 
     * @throws InterruptedException
     * @throws IOException
     */
    public List invokeAll(Collection tasks) 
            throws InterruptedException, IOException;

    public List invokeAll(Collection tasks,
            long timeout, TimeUnit unit) throws InterruptedException, IOException;

    public Object invokeAny(Collection tasks) 
            throws InterruptedException, ExecutionException, IOException;

    public Object invokeAny(Collection tasks, long timeout,
    TimeUnit unit) throws InterruptedException, ExecutionException, 
    TimeoutException, IOException;

    public void execute(Runnable command) throws IOException;
    
}
