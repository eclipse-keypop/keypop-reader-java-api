/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.reader;

/**
 * Indicates that the communication with the reader failed.
 *
 * <p>The most likely reason is a physical disconnection of the reader, but other technical problems
 * may also be the origin of the failure.
 *
 * @since 1.0.0
 */
public class ReaderCommunicationException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.0.0
   */
  public ReaderCommunicationException(String message) {
    super(message);
  }

  /**
   * @param message The message to identify the exception context.
   * @param cause The cause.
   * @since 1.0.0
   */
  public ReaderCommunicationException(String message, Throwable cause) {
    super(message, cause);
  }
}
