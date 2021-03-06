/*
 * Copyright (C) 2016 Tercio Gaudencio Filho
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.github.x3333.dagger.aop.user.impl;

import com.github.x3333.dagger.aop.test.Interceptor;
import com.github.x3333.dagger.aop.user.Some;

/**
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
public abstract class SomeImpl implements Some {

  @Override
  @Interceptor
  public String doWork1() {
    return "doWork1";
  }

  @Override
  @Interceptor
  public int doWork2() {
    return 2;
  }

  @Override
  @Interceptor
  public int doWork3(final double param) {
    return Double.valueOf(param).intValue();
  }

}
