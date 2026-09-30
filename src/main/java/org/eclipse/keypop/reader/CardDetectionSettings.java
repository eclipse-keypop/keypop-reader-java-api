/* **************************************************************************************
 * Copyright (c) 2026 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.reader;

import java.util.Set;
import org.eclipse.keypop.definitions.RfTechnology;

/**
 * Builder carrying the configuration of a card detection cycle.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_CardDetectionSettings">CardDetectionSettings</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public interface CardDetectionSettings {

  /**
   * Sets the detection mode to apply once a card processing cycle has terminated.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardDetectionSettings_setDetectionMode">CardDetectionSettings.setDetectionMode</a>
   * for the normative contract.
   *
   * @param detectionMode The detection mode to apply.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided detection mode is null.
   * @since 3.0.0
   */
  CardDetectionSettings setDetectionMode(DetectionMode detectionMode);

  /**
   * Sets the RF technologies to be activated by the reader during polling.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardDetectionSettings_setRfTechnologies">CardDetectionSettings.setRfTechnologies</a>
   * for the normative contract.
   *
   * @param rfTechnologies The RF technologies to activate.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided set is null or empty.
   * @since 3.0.0
   */
  CardDetectionSettings setRfTechnologies(Set<RfTechnology> rfTechnologies);

  /**
   * Sets the ECP frame to be emitted by the reader at polling startup.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#op_CardDetectionSettings_setEcpFrame">CardDetectionSettings.setEcpFrame</a>
   * for the normative contract.
   *
   * @param ecpFrame The ECP frame to emit.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided array is null or empty.
   * @since 3.0.0
   */
  CardDetectionSettings setEcpFrame(byte[] ecpFrame);

  /**
   * Behaviour to apply after a card processing cycle has terminated.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_DetectionMode">DetectionMode</a>
   * for the normative contract.
   *
   * @since 3.0.0
   */
  enum DetectionMode {

    /**
     * The reader continues waiting for the next card insertion.
     *
     * @since 3.0.0
     */
    REPEATING,

    /**
     * The reader stops detection after the current card processing cycle.
     *
     * @since 3.0.0
     */
    SINGLE_SHOT
  }
}
