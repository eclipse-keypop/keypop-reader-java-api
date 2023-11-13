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
package org.eclipse.keypop.reader.selection;

import org.eclipse.keypop.reader.CardReaderEvent;

/**
 * Response of the execution of a scheduled selection scenario provided by a {@link
 * CardReaderEvent}.
 *
 * <p>Contains the card's responses to one or more of the scenario's selection cases, i.e. the data
 * from the selection step itself and any responses to commands that may have been executed
 * afterward.
 *
 * <p>It is necessary to use the method {@link
 * CardSelectionManager#parseScheduledCardSelectionsResponse(ScheduledCardSelectionsResponse)} to
 * analyze the result.
 *
 * @since 1.0.0
 */
public interface ScheduledCardSelectionsResponse {}
