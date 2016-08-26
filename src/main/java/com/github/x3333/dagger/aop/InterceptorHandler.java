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

package com.github.x3333.dagger.aop;

import java.lang.annotation.Annotation;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

import com.google.common.collect.Multimap;

/**
 * Base interface for {@link MethodInterceptor} handlers.
 * 
 * <p>
 * {@link MethodInterceptor}s must registered to this Java Service using this Interface. Can be done using
 * <code>@AutoService(InterceptorHandler.class)</code> from <a href="https://github.com/google/auto/tree/master/service">Google Auto</a>.
 * 
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
public interface InterceptorHandler {

  /**
   * The {@link Annotation} class that this handler is binded to.
   * 
   * @return Annotation class binded to this Handler.
   */
  Class<? extends Annotation> annotation();

  /**
   * The {@link MethodInterceptor} class that this handler is binded to.
   * 
   * @return Interceptor class binded to this Handler.
   */
  Class<? extends MethodInterceptor> methodInterceptorClass();

  /**
   * Validate a method {@link ExecutableElement} to be accepted by the Processor.
   * 
   * <p>
   * The {@link ExecutableElement} is the instance which has been annotated with {@link #annotation()}.
   * 
   * @param methodElement ExecutableElement to be validated.
   * @return <code>Null</code> if this element has passed validation, otherwise, a String with the error message.
   */
  default String validateMethod(final ExecutableElement methodElement) {
    return null;
  }

  /**
   * Called after the Generator has processed all annotated classes.
   * 
   * @param processingEnv {@link ProcessingEnvironment} associated with this generation.
   * @param bindings All bindings processed that belongs to this Handler.
   */
  default void postProcess(//
      final ProcessingEnvironment processingEnv, //
      final Multimap<TypeElement, MethodBind> bindings) {}

}
