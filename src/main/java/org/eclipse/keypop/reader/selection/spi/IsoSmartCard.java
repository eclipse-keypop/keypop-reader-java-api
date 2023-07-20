/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.reader.selection.spi;

/**
 * ISO 7816-4 smart card with which communication has been established after a selection process and
 * which is ready to receive APDUs.
 *
 * <p>The information that could be collected by the selection process, i.e. the power-on data or
 * the response to the "Select Application" command are made available.<br>
 * Both are optional but cannot be null at the same time.
 *
 * <p>Must be implemented and possibly extended by a ISO card extension to meet its specific needs.
 *
 * @since 2.0.0
 */
public interface IsoSmartCard extends SmartCard {

  /**
   * Gets the card data received in response to the "Select Application" command (including the
   * status word).
   *
   * @return Null if no selection application has been performed.
   * @since 1.0.0
   */
  byte[] getSelectApplicationResponse();
}
