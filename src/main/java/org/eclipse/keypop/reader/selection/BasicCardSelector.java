/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.reader.selection;

import org.eclipse.keypop.reader.ReaderApiFactory;

/**
 * Basic filters used to restrict the selection process to certain cards.
 *
 * <p>These filters are all optional but can also be combined.
 *
 * <p>If no filtering is specified, any card that responds when inserted in the reader will be
 * considered selected.
 *
 * <p>Conversely, if one or more filters have been defined, the card will not be selected if one of
 * them rejects the card.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * ReaderApiFactory#createBasicCardSelector()}.
 *
 * @since 2.0.0
 */
public interface BasicCardSelector extends CardSelector<BasicCardSelector> {}
