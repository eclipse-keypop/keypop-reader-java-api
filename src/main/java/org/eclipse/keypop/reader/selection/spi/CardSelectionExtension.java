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
package org.eclipse.keypop.reader.selection.spi;

/**
 * SPI provided by a card extension, allowing to enrich a selection case with additional commands if
 * required, and to interpret the return to selection in order to build and fill the specific {@link
 * SmartCard} which acts as an image of the targeted card.
 *
 * @since 2.0.0
 */
public interface CardSelectionExtension {}
