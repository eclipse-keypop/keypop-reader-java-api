/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.reader.spi;

/**
 * Reader observation error handler to implement in order to be notified of errors that may occur
 * during operations carried out by the card monitoring process.
 *
 * @since 1.0.0
 */
public interface CardReaderObservationExceptionHandlerSpi {

  /**
   * Called when an error occurs in the observed reader.
   *
   * <p>When an error occurs, the observation process is stopped.
   *
   * @param contextInfo The context information.
   * @param readerName The reader name.
   * @param e The original exception.
   * @since 1.0.0
   */
  void onReaderObservationError(String contextInfo, String readerName, Throwable e);
}
