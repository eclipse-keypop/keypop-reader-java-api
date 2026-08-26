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
package org.eclipse.keypop.reader.selection;

import org.eclipse.keypop.reader.ReaderApiFactory;

/**
 * Basic, technology-agnostic card selector, obtained via the method {@link
 * ReaderApiFactory#createBasicCardSelector()}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-reader-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-Reader_v3.0.0-SNAPSHOT.html#type_BasicCardSelector">BasicCardSelector</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public interface BasicCardSelector extends CardSelector<BasicCardSelector> {}
