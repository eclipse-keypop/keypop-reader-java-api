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
package org.eclipse.keypop.reader.selection;

import org.eclipse.keypop.reader.ReaderApiFactory;

/**
 * ISO filters used to restrict the selection process to certain ISO 7816-4 cards.
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
 * ReaderApiFactory#createIsoCardSelector()}.
 *
 * @since 2.0.0
 */
public interface IsoCardSelector extends CommonIsoCardSelector<IsoCardSelector> {}
