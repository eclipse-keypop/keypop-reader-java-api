/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.reader.selection.spi;

/**
 * SPI provided by a card extension, allowing to enrich a selection case with additional commands if
 * required, and to interpret the return to selection in order to build and fill the specific {@link
 * SmartCard} which acts as an image of the targeted card.
 *
 * @since 2.0.0
 */
public interface CardSelectionExtension {}
