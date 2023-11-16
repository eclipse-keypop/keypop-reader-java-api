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

import org.eclipse.keypop.reader.selection.BasicCardSelector;
import org.eclipse.keypop.reader.selection.CardSelectionManager;
import org.eclipse.keypop.reader.selection.IsoCardSelector;

/**
 * Reader API Factory.
 *
 * @since 2.0.0
 */
public interface ReaderApiFactory {

  /**
   * Returns a new instance of {@link CardSelectionManager}.
   *
   * @return A new instance of {@link CardSelectionManager}.
   * @since 2.0.0
   */
  CardSelectionManager createCardSelectionManager();

  /**
   * Returns a new instance of {@link BasicCardSelector}.
   *
   * @return A new instance of {@link BasicCardSelector}.
   * @since 2.0.0
   */
  BasicCardSelector createBasicCardSelector();

  /**
   * Returns a new instance of {@link IsoCardSelector}.
   *
   * @return A new instance of {@link IsoCardSelector}.
   * @since 2.0.0
   */
  IsoCardSelector createIsoCardSelector();
}
