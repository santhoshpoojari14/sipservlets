/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jdiameter.common.api.app.ro;

import java.util.concurrent.ScheduledFuture;

import org.jdiameter.api.Request;
import org.jdiameter.api.ro.ServerRoSession;

/**
 * Diameter Credit Control Application Server Additional listener
 * Actions for FSM
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a> 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a> 
 */
public interface IServerRoSessionContext {

  public void sessionSupervisionTimerExpired(ServerRoSession session);

  /**
   * This is called always when Tcc starts
   * @param session
   * @param future
   */
  @SuppressWarnings("unchecked")
  public void sessionSupervisionTimerStarted(ServerRoSession session, ScheduledFuture future);

  @SuppressWarnings("unchecked")
  public void sessionSupervisionTimerReStarted(ServerRoSession session, ScheduledFuture future);

  @SuppressWarnings("unchecked")
  public void sessionSupervisionTimerStopped(ServerRoSession session, ScheduledFuture future);

  /**
   * Returns seconds value representing default validity time, App session uses 2x for Tcc timer
   * @return
   */
  public long getDefaultValidityTime();

  public void timeoutExpired(Request request);

}