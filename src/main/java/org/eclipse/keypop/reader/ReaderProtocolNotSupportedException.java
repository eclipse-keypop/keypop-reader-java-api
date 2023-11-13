/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
package org.eclipse.keypop.reader;

/**
 * Indicates that the current card protocol is not supported by the reader.
 *
 * @since 1.0.0
 */
public class ReaderProtocolNotSupportedException extends RuntimeException {

  /**
   * @param physicalProtocolName The identification data used to identify the card.
   * @since 1.0.0
   */
  public ReaderProtocolNotSupportedException(String physicalProtocolName) {
    super("The protocol '" + physicalProtocolName + "' is not supported.");
  }
}
